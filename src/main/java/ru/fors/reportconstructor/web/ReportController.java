package ru.fors.reportconstructor.web;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.fors.reportconstructor.service.CreatorService;
import ru.fors.reportconstructor.service.FinderService;

@RestController
@AllArgsConstructor
@RequestMapping("v1")
public class ReportController {

    private CreatorService creatorService;
    private FinderService finderService;

    @ApiOperation("Creating report by fields from request")
    @PostMapping(value = "report")
    public String createReport() {
        return creatorService.createReport();
    }

    @ApiOperation("Get rows for report")
    @GetMapping(value = "rows")
    public String getRows() {
        return finderService.findRows();
    }

    @ApiOperation("Get columns for report")
    @GetMapping(value = "columns")
    public String getColumns() {
        return finderService.findColumns();
    }


}
