package com.lmnoppy.api.covid.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lmnoppy.api.covid.model.enums.Area;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Structure {

    private String date;
    private Area area;

    private String newCasesByPublishDate;
    private String cumCasesByPublishDate;
    private String newDeaths28DaysByPublishDate;
    private String cumDeaths28DaysByPublishDate;

}
