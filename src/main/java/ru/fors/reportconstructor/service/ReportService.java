package ru.fors.reportconstructor.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.fors.reportconstructor.entity.Report;
import ru.fors.reportconstructor.web.dto.ReportRequest;

@AllArgsConstructor
@Service
public class ReportService {

    private DBService dbService;

    public Report createReport(ReportRequest reportRequest){

//        dbService.findByParam();


        return new Report();
    }

    public Report getReport(String reportId) {
        return null;
    }

    public Report updateReport(String reportId, ReportRequest reportRequest) {
        return null;
    }
}
