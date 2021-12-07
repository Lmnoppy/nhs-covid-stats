package com.lmnoppy.api.covid.service;

import com.lmnoppy.api.covid.ICovid;
import com.lmnoppy.api.covid.endpoints.IEndpoint;
import com.lmnoppy.api.covid.model.enums.Metrics;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.util.List;

final class CovidService implements ICovid {

    private IEndpoint iEndpoint;
    
    CovidService(IEndpoint iEndpoint) {
        this.iEndpoint = iEndpoint;
    }

    @Override
    public Flux<List<String>> fetchCovidStatsForScotlandNationArea(List<Metrics> metrics, LocalDate date) {
        return iEndpoint.covidStatsForScotlandNationArea(metrics, date);
    }

}
