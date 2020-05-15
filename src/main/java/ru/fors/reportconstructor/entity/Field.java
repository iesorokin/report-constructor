package ru.fors.reportconstructor.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Field {
    @Column
    String id;
    @Column
    String name;
    @Column
    String type;
    @Column
    String table_id;
}
