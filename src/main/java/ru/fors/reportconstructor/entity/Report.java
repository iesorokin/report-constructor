package ru.fors.reportconstructor.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice;

import javax.persistence.Column;
import javax.persistence.JoinColumns;
import java.util.Collection;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Report {
    @Column
    String id;
    @Column
    String user_id;
    @Column
    String name;
    @Column
    String description;
    @Column
    Collection<String> columnnames;
    @Column
    String rowname;
    @Column
    String period;
}
