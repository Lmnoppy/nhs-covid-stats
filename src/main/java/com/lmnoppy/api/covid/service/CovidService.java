package com.lmnoppy.api.covid.service;

import com.lmnoppy.api.covid.endpoints.IEndpoint;
import com.lmnoppy.api.covid.model.Metrics;
import com.lmnoppy.api.covid.model.enums.Area;
import reactor.core.publisher.Flux;

import java.util.List;

final class CovidService implements ICovid {

    private IEndpoint iEndpoint;
    
    CovidService(IEndpoint iEndpoint) {
        this.iEndpoint = iEndpoint;
    }

    @Override
    public Flux<List<Metrics>> fetchCovidStatsForCountry(Area area) {
        return iEndpoint.getCovidStatsForNationArea(area);
    }

    @Override
    public Flux<String> fetchCovidStatsForRegion(String region) {
        return iEndpoint.getCovidStatsForRegion(region);
    }
}
