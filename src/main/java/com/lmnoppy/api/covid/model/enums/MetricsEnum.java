package com.lmnoppy.api.covid.model.enums;

import lombok.Getter;

@Getter
public enum MetricsEnum {

    DATE("date"),
    AREA_NAME("areaName"),
    AREA_CODE("areaCode"),
    NEW_CASES_BY_PUBLISH_DATE("newCasesByPublishDate"),
    CUM_CASES_BY_PUBLISH_DATE("cumCasesByPublishDate"),
    NEW_DEATHS_28_DAYS_BY_PUBLISH_DATE("newDeaths28DaysByPublishDate"),
    CUM_DEATHS_28_DAYS_BY_PUBLISH_DATE("cumDeaths28DaysByPublishDate");

    private final String metricNameValue;

    MetricsEnum(String metricNameValue) {
        this.metricNameValue = metricNameValue;
    }
}
