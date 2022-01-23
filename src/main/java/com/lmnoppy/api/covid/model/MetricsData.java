package com.lmnoppy.api.covid.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MetricsData implements Serializable {

    @Serial
    private static final long serialVersionUID = 991286172506130502L;

    private String date;

    private String areaName;
    private String areaCode;

    private String newCasesByPublishDate;
    private String cumCasesByPublishDate;
    private String newDeaths28DaysByPublishDate;
    private String cumDeaths28DaysByPublishDate;
}
