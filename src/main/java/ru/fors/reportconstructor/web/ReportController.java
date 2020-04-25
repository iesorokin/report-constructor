package ru.fors.reportconstructor.web;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("v1")
public class ReportController {

    @ApiOperation("Hello")
    @GetMapping(value = "hello")
    public String hello() {
        return "Hello, dude";
    }

}
