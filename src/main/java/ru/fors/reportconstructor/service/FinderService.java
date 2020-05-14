package ru.fors.reportconstructor.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@AllArgsConstructor
@Service
public class FinderService {

    private DBService dbService;

    public String createReport(){

//        dbService.findByParam();


        return "String";
    }

    public Collection<String> findFields(String table) {
        return dbService.findRows();
    }

    public Collection<String> findTables() {
        return dbService.findTables();
    }
}
