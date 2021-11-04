package com.lmnoppy.api.covid.service;

import com.lmnoppy.api.covid.endpoints.IEndpoint;
import com.lmnoppy.api.covid.model.CovidResponse;
import com.lmnoppy.api.covid.model.enums.Area;
import reactor.core.publisher.Flux;

final class CovidService implements ICovid {

    private IEndpoint iEndpoint;
    
    CovidService(IEndpoint iEndpoint) {
        this.iEndpoint = iEndpoint;
    }

    @Override
    public Flux<CovidResponse> fetchCovidStatsForCountry(Area area) {
        return iEndpoint.getCovidStatsForNationArea(area);
    }

    @Override
    public Flux<String> fetchCovidStatsForRegion(String region) {
        return iEndpoint.getCovidStatsForRegion(region);
    }
}
