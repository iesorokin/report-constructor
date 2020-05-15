package ru.fors.reportconstructor.entity;

import ch.qos.logback.core.joran.spi.NoAutoStart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Table {
    @Id
    @Column
    String id;
    @Column
    String name;
    @Column
    @OneToMany
    String schema_id;
}
