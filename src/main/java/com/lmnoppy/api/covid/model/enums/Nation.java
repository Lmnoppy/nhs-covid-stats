package com.lmnoppy.api.covid.model.enums;

public enum Nation {

    SCOTLAND("Scotland"),
    WALES("Wales"),
    NORTHERN_IRELAND("Northern Ireland"),
    ENGLAND("England");

    private String name;

    Nation(String name){
        this.name = name;

    }

}
