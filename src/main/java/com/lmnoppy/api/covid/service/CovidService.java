package com.lmnoppy.api.covid.service;

import com.lmnoppy.api.covid.ICovid;
import com.lmnoppy.api.covid.endpoints.IEndpoint;
import com.lmnoppy.api.covid.model.Response;
import com.lmnoppy.api.covid.model.enums.Area;
import com.lmnoppy.api.covid.model.enums.Metrics;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.util.List;

final class CovidService implements ICovid {

    private IEndpoint iEndpoint;
    
    public CovidService(IEndpoint iEndpoint) {
        this.iEndpoint = iEndpoint;
    }

    @Override
    public Flux<List<Response>> fetchCovidStatsForNation(Area area, List<Metrics> metrics, LocalDate date) {
        return iEndpoint.covidStatsForNation(area, metrics, date);
    }

}
