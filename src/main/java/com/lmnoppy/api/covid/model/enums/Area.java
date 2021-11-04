package com.lmnoppy.api.covid.model.enums;

public enum Area {
    SCOTLAND("scotland", "","", "", "", ""),
    WALES("wales","", "", "", "", ""),
    NORTHERNIRELAND("northern_ireland", "", "", "", "", ""),
    ENGLAND("england", "", "", "", "", "");

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
