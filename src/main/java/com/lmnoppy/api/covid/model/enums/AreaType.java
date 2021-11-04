package com.lmnoppy.api.covid.model.enums;

public enum AreaType {
    OVERVIEW("overview", "Overview data for the United Kingdom"),
    NATION("nation", "Nation data (England, Northern Ireland, Scotland, and Wales)"),
    REGION("region", "Region data"),
    NHSREGION("nhsRegion", "NHS Region data"),
    UTLA("utla", "Upper-tier local authority data"),
    LTLA("ltla", "Lower-tier local authority data");

    private String id;
    private String description;

    AreaType(String id, String description){
        this.id = id;
        this.description = description;
    }
}
