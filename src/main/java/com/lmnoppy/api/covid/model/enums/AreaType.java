package com.lmnoppy.api.covid.model.enums;

import lombok.Getter;

@Getter
public enum AreaType {
    OVERVIEW("overview", "Overview data for the United Kingdom"),
    NATION("nation", "Nation data"),
    REGION("region", "Region data"),
    NHSREGION("nhsRegion", "NHS Region data"),
    UTLA("utla", "Upper-tier local authority data"),
    LTLA("ltla", "Lower-tier local authority data");

    private final String id;
    private final String description;

    AreaType(final String id, final String description){
        this.id = id;
        this.description = description;
    }
}
