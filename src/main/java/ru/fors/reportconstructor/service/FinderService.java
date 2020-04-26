package ru.fors.reportconstructor.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FinderService {

    private DBService dbService;

    public String createReport(){

//        dbService.findByParam();


        return "String";
    }

    public String findRows() {
        return dbService.findRows();
    }

    public String findColumns() {
        return null;
    }
}
