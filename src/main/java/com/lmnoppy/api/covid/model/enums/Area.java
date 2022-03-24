package com.lmnoppy.api.covid.model.enums;

import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
public enum Area {
    SCOTLAND(Nation.SCOTLAND, Collections.emptyList(), Collections.emptyList(), "", "", "S92000003"),
    WALES(Nation.WALES,Collections.emptyList(), Collections.emptyList(), "", "", "W92000004"),
    NORTHERN_IRELAND(Nation.NORTHERN_IRELAND, Collections.emptyList(), Collections.emptyList(), "", "", "N92000002"),
    ENGLAND(Nation.ENGLAND, Collections.emptyList(), Collections.emptyList(), "", "", "E92000001");

    private final Nation nation;
    private final List<String> region;
    private final List<String> nhsRegions;
    private final String utla;
    private final String ltla;
    private final String areaCode;

    Area(Nation nation, List<String> region, List<String> nhsRegions, String utla, String ltla, String areaCode){
        this.nation = nation;
        this.region = region;
        this.nhsRegions = nhsRegions;
        this.utla = utla;
        this.ltla = ltla;
        this.areaCode = areaCode;
    }
}
