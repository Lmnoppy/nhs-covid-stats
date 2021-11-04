package com.lmnoppy.api.covid.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Metrics {

    private String date;
    private String areaName;
    private String areaCode;

    private String newCasesByPublishDate;
    private String cumCasesByPublishDate;
    private String newDeaths28DaysByPublishDate;
    private String cumDeaths28DaysByPublishDate;

}
