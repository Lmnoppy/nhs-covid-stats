package com.lmnoppy.api.covid.model.enums;

import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
public enum Area {
    SCOTLAND(Nation.SCOTLAND, "", Collections.emptyList(), "", "", ""),
    WALES(Nation.WALES,"", Collections.emptyList(), "", "", ""),
    NORTHERN_IRELAND(Nation.NORTHERN_IRELAND, "", Collections.emptyList(), "", "", ""),
    ENGLAND(Nation.ENGLAND, "", Collections.emptyList(), "", "", "");

    private final Nation nation;
    private final String region;
    private final List<String> nhsRegions;
    private final String utla;
    private final String ltla;
    private final String areaCode;

    Area(Nation nation, String region, List<String> nhsRegions, String utla, String ltla, String areaCode){
        this.nation = nation;
        this.region = region;
        this.nhsRegions = nhsRegions;
        this.utla = utla;
        this.ltla = ltla;
        this.areaCode = areaCode;
    }
}
