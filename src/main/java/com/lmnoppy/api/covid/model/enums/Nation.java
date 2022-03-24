package com.lmnoppy.api.covid.model.enums;

import lombok.Getter;

import java.util.Collections;
import java.util.List;

import static com.lmnoppy.api.covid.model.enums.Metrics.*;

@Getter
public enum Nation {

    SCOTLAND("Scotland", List.of(CUM_ADMISSIONS, COVID_OCCUPIED_MV_BEDS, CUM_ADMISSIONS_BY_AGE, CUM_CASES_BY_PUBLISH_DATE, CUM_CASES_BY_PUBLISH_DATE_RATE)),
    WALES("Wales", Collections.emptyList()),
    NORTHERN_IRELAND("Northern Ireland", Collections.emptyList()),
    ENGLAND("England", Collections.emptyList());

    private final String name;
    private final List<Metrics> supportedMetrics;

    Nation(final String name, final List<Metrics> supportedMetrics){
        this.name = name;
        this.supportedMetrics = supportedMetrics;
    }
}
