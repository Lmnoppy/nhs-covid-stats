package com.lmnoppy.api.covid.model;

import com.lmnoppy.api.covid.model.enums.Area;

import java.time.LocalDate;

public class Response {

    //Example response
    //{"areaType":"nation","areaCode":"S92000003","areaName":"Scotland","date":"2021-12-01","newCasesByPublishDate":2796}

    private String areaType;
    private String areaCode;
    private String areaName;
    private LocalDate date;
    private int newCasesByPublishDate;

    public Response(String areaType, String areaCode, String areaName, LocalDate date, int value){
        this.areaType = areaType;
        this.areaCode = areaCode;
        this.areaName = areaName;
        this.date = date;
        this.newCasesByPublishDate = value;

    }
}
