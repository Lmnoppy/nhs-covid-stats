package com.lmnoppy.api.covid.service;

import com.lmnoppy.api.covid.ICovid;
import com.lmnoppy.api.covid.endpoints.EndpointRegistry;
import com.lmnoppy.api.covid.model.enums.Area;
import com.lmnoppy.api.covid.model.MetricsData;
import com.lmnoppy.api.covid.model.enums.AreaType;
import com.lmnoppy.api.covid.model.enums.Metrics;
import reactor.core.publisher.Mono;

import java.util.List;

import static com.lmnoppy.api.covid.model.enums.Area.*;
import static com.lmnoppy.api.covid.model.enums.AreaType.NATION;

public class CovidService implements ICovid {

    private final EndpointRegistry endpointRegistry;

    public CovidService( EndpointRegistry endpointRegistry) {
        this.endpointRegistry = endpointRegistry;
    }

    @Override
    public Mono<List<MetricsData>> fetchNHSCovidStatsFor(Area area, AreaType areaType, List<Metrics> metrics) {
        return endpointRegistry.nhsCovidEndPoint().fetchCovidStatsFor(area, areaType, metrics);
    }

    @Override
    public Mono<List<MetricsData>> fetchAllSupportedNationDataForScotland() {
        return endpointRegistry.nhsCovidEndPoint().fetchCovidStatsFor(SCOTLAND, NATION, SCOTLAND.getNation().getSupportedMetrics());
    }

    @Override
    public Mono<List<MetricsData>> fetchAllSupportedNationDataForEngland() {
        return endpointRegistry.nhsCovidEndPoint().fetchCovidStatsFor(ENGLAND, NATION, ENGLAND.getNation().getSupportedMetrics());
    }

    @Override
    public Mono<List<MetricsData>> fetchAllSupportedNationDataForWales() {
        return endpointRegistry.nhsCovidEndPoint().fetchCovidStatsFor(WALES, NATION, WALES.getNation().getSupportedMetrics());
    }

    @Override
    public Mono<List<MetricsData>> fetchAllSupportedNationDataForNorthernIreland() {
        return endpointRegistry.nhsCovidEndPoint().fetchCovidStatsFor(NORTHERN_IRELAND, NATION, NORTHERN_IRELAND.getNation().getSupportedMetrics());
    }

}
