package ru.fors.reportconstructor.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CreatorService {

    private DBService dbService;

    public String createReport(){

//        dbService.findByParam();


        return "String";
    }
}
