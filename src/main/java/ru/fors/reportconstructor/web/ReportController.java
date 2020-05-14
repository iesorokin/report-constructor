package ru.fors.reportconstructor.web;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.fors.reportconstructor.entity.Report;
import ru.fors.reportconstructor.service.ReportService;
import ru.fors.reportconstructor.service.FinderService;
import ru.fors.reportconstructor.web.dto.ReportRequest;

import java.util.Collection;

@RestController
@AllArgsConstructor
@RequestMapping("v1")
public class ReportController {

    private ReportService reportService;
    private FinderService finderService;

    @ApiOperation("Creating report by fields from request")
    @PostMapping(value = "report")
    public Report createReport(@RequestBody ReportRequest reportRequest) {
        return reportService.createReport(reportRequest);
    }

    @ApiOperation("Creating report by fields from request")
    @PutMapping(value = "report")
    public Report updateReport(@RequestParam String reportId, @RequestBody ReportRequest reportRequest) {
        return reportService.updateReport(reportId, reportRequest);
    }

    @ApiOperation("Creating report by fields from request")
    @GetMapping(value = "report")
    public Report getReport(@RequestParam String reportId) {
        return reportService.getReport(reportId);
    }

    @ApiOperation("Get rows for report")
    @GetMapping(value = "fields")
    public Collection<String> getFields(@RequestParam String table) {
        return finderService.findFields(table);
    }

    @ApiOperation("Get tables for report")
    @GetMapping(value = "tables")
    public Collection<String> getTables() {
        return finderService.findTables();
    }


}
