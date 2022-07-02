package com.lmnoppy.api.covid.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.lmnoppy.api.covid.ICovid;
import com.lmnoppy.api.covid.endpoints.NHSCovidEndPoint;
import com.lmnoppy.api.covid.model.enums.Area;
import com.lmnoppy.api.covid.model.enums.AreaType;
import com.lmnoppy.api.covid.model.enums.Metrics;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;

import static com.lmnoppy.api.covid.model.enums.Area.*;
import static com.lmnoppy.api.covid.model.enums.AreaType.NATION;
import static java.util.function.Predicate.not;

public class NHSCovidService implements ICovid {

    private final NHSCovidEndPoint nhsCovidEndPoint;

    public NHSCovidService(NHSCovidEndPoint nhsCovidEndPoint) {
        this.nhsCovidEndPoint = nhsCovidEndPoint;
    }

    @Override
    public Flux<JsonNode> fetchNHSCovidStatsFor(Area area, AreaType areaType, List<Metrics> metrics) {
        return nhsCovidEndPoint.fetchCovidStatsFor(area, areaType, metrics);
    }

    @Override
    public Flux<JsonNode> fetchAllSupportedNationDataForScotland() {
        return nhsCovidEndPoint.fetchCovidStatsFor(SCOTLAND, NATION, SCOTLAND.getNation().getSupportedMetrics().stream().filter(not(Metrics::getIsDeprecated)).collect(Collectors.toList()));
    }

    @Override
    public Flux<JsonNode> fetchAllSupportedNationDataForEngland() {
        return nhsCovidEndPoint.fetchCovidStatsFor(ENGLAND, NATION, ENGLAND.getNation().getSupportedMetrics().stream().filter(not(Metrics::getIsDeprecated)).collect(Collectors.toList()));
    }

    @Override
    public Flux<JsonNode> fetchAllSupportedNationDataForWales() {
        return nhsCovidEndPoint.fetchCovidStatsFor(WALES, NATION, WALES.getNation().getSupportedMetrics().stream().filter(not(Metrics::getIsDeprecated)).collect(Collectors.toList()));
    }

    @Override
    public Flux<JsonNode> fetchAllSupportedNationDataForNorthernIreland() {
        return nhsCovidEndPoint.fetchCovidStatsFor(NORTHERN_IRELAND, NATION, NORTHERN_IRELAND.getNation().getSupportedMetrics().stream().filter(not(Metrics::getIsDeprecated)).collect(Collectors.toList()));
    }

}
