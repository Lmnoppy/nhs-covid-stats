package com.lmnoppy.api.covid.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CovidResponse {

    private String length;
    private String maxPageLimit;
    private String totalRecords;

    private List<Metrics> data;

}
