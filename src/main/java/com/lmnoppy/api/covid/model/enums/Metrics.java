package com.lmnoppy.api.covid.model.enums;

import lombok.Getter;

@Getter
public enum Metrics {

    CUM_CASES_BY_PUBLISH_DATE("cumCasesByPublishDate")
    ;

    private final String value;

    Metrics(String value) {
        this.value = value;
    }
}
