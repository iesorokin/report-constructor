package ru.fors.reportconstructor.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Collection;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ReportRequest {
    @NotEmpty
    String userId;
    @NotEmpty
    String table;
    Collection<String> fields;
}
