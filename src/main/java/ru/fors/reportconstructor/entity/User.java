package ru.fors.reportconstructor.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;

@AllArgsConstructor
@Data
public class User {
    @Column
    String id;
    @Column
    String name;
    @Column
    String password;
}
