package com.lmnoppy.api.covid.model;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Data
public class Response implements Serializable {

    @Serial
    private static final long serialVersionUID = -1496910593772770020L;

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
