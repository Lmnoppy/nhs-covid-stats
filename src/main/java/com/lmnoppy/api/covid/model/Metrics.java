package com.lmnoppy.api.covid.model;

import lombok.Data;

@Data
public class Metrics {

    private String newCasesByPublishDate;
    private String cumCasesByPublishDate;
    private String newDeaths28DaysByPublishDate;
    private String cumDeaths28DaysByPublishDate;

}
