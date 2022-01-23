package com.lmnoppy.api.covid.model.enums;

import lombok.Getter;

@Getter
public enum Nation {

    SCOTLAND("Scotland"),
    WALES("Wales"),
    NORTHERN_IRELAND("Northern Ireland"),
    ENGLAND("England");

    private final String name;

    Nation(final String name){
        this.name = name;
    }

}
