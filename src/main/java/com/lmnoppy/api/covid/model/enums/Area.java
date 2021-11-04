package com.lmnoppy.api.covid.model.enums;

import lombok.Getter;

@Getter
public enum Area {
    SCOTLAND("Scotland", "","", "", "", ""),
    WALES("Wales","", "", "", "", ""),
    NORTHERNIRELAND("", "", "", "", "", ""),
    ENGLAND("England", "", "", "", "", "");

    private String nation;
    private String region;
    private String nhsRegion;
    private String utla;
    private String ltla;
    private String areaCode;

    Area(String nation, String region, String nhsRegion, String utla, String ltla, String areaCode){
        this.nation = nation;
        this.region = region;
        this.nhsRegion = nhsRegion;
        this.utla = utla;
        this.ltla = ltla;
        this.areaCode = areaCode;
    }
}
