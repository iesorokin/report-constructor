package ru.fors.reportconstructor;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.fors.reportconstructor.entity.Employee;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ReportConstructorApplicationTests {

	@Test
	void contextLoads() {
		try (Connection conn = DriverManager.getConnection(
				"jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "password1");
			 Statement statement = conn.createStatement();
			 PreparedStatement psInsert = conn.prepareStatement(SQL_INSERT);
			 PreparedStatement psUpdate = conn.prepareStatement(SQL_UPDATE)) {

			statement.execute(SQL_TABLE_DROP);
			statement.execute(SQL_TABLE_CREATE);

			// start transaction block
			conn.setAutoCommit(false); // default true

			// Run list of insert commands
			psInsert.setString(1, "mkyong");
			psInsert.setBigDecimal(2, new BigDecimal(10));
			psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
			psInsert.execute();

			psInsert.setString(1, "kungfu");
			psInsert.setBigDecimal(2, new BigDecimal(20));
			psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
			psInsert.execute();

			// Run list of update commands

			// error, test roolback
			// org.postgresql.util.PSQLException: No value specified for parameter 1.
			psUpdate.setBigDecimal(2, new BigDecimal(999.99));
			psUpdate.setBigDecimal(1, new BigDecimal(999.99));
			psUpdate.setString(2, "mkyong");
			psUpdate.execute();

			// end transaction block, commit changes
			conn.commit();

			// good practice to set it back to default true
			conn.setAutoCommit(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static final String SQL_INSERT = "INSERT INTO EMPLOYEE (NAME, SALARY, CREATED_DATE) VALUES (?,?,?)";

	private static final String SQL_UPDATE = "UPDATE EMPLOYEE SET SALARY=? WHERE NAME=?";

	private static final String SQL_TABLE_CREATE = "CREATE TABLE EMPLOYEE"
			+ "("
			+ " ID serial,"
			+ " NAME varchar(100) NOT NULL,"
			+ " SALARY numeric(15, 2) NOT NULL,"
			+ " CREATED_DATE timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,"
			+ " PRIMARY KEY (ID)"
			+ ")";

	private static final String SQL_TABLE_DROP = "DROP TABLE EMPLOYEE";


	@Test
	void setSqlInsert(){
		try (Connection conn = DriverManager.getConnection(
				"jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "password1")) {

			if (conn != null) {
				System.out.println("Connected to the database!");
			} else {
				System.out.println("Failed to make connection!");
			}

		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void a(){

		System.out.println("PostgreSQL JDBC Connection Testing ~");

		// https://docs.oracle.com/javase/8/docs/api/java/sql/package-summary.html#package.description
		// auto java.sql.Driver discovery -- no longer need to load a java.sql.Driver class via Class.forName

		// register JDBC driver, optional since java 1.6
		// Class.forName("org.postgresql.Driver");

		List<Employee> result = new ArrayList<>();

		String SQL_SELECT = "Select * from EMPLOYEE";

		// auto close connection and preparedStatement
		try (Connection conn = DriverManager.getConnection(
				"jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "password1");
			 PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				long id = resultSet.getLong("ID");
				String name = resultSet.getString("NAME");
				BigDecimal salary = resultSet.getBigDecimal("SALARY");
				Timestamp createdDate = resultSet.getTimestamp("CREATED_DATE");

				Employee obj = new Employee();
				obj.setId(id);
				obj.setName(name);
				obj.setSalary(salary);
				// Timestamp -> LocalDateTime
				obj.setCreatedDate(createdDate.toLocalDateTime());

				result.add(obj);

			}
			result.forEach(x -> System.out.println(x));

		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	void aa(){

		System.out.println("PostgreSQL JDBC Connection Testing ~");

		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {
			System.err.println("Unable to find the PostgreSQL JDBC Driver!");
			e.printStackTrace();
			return;
		}

		// default database: postgres
		// JDK 7, auto close connection with try-with-resources
		try (Connection connection =
					 DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres",
							 "postgres", "password1")) {


			DatabaseMetaData metaData = connection.getMetaData();

			try (ResultSet rs = metaData.getTables(null, null, "%", null)) {

				ResultSetMetaData rsMeta = rs.getMetaData();
				int columnCount = rsMeta.getColumnCount();

				while (rs.next()) {

					System.out.println("\n----------");
					System.out.println(rs.getString("TABLE_NAME"));
					System.out.println("----------");

					for (int i = 1; i <= columnCount; i++) {
						String columnName = rsMeta.getColumnName(i);
						System.out.format("%s:%s\n", columnName, rs.getString(i));
					}

				}
			}

		} catch (SQLException e) {
			System.err.println("Something went wrong!");
			e.printStackTrace();
			return;
		}
	}

}
