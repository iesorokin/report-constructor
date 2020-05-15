package ru.fors.reportconstructor.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.fors.reportconstructor.entity.Field;
import ru.fors.reportconstructor.entity.Table;

import java.util.Collection;

@AllArgsConstructor
@Service
public class FinderService {

    private DBService dbService;

    public String createReport(){

//        dbService.findByParam();


        return "String";
    }

    public Collection<Field> findFields(String table) {
        return dbService.findRows();
    }

    public Collection<Table> findTables() {
        return dbService.findTables();
    }
}
