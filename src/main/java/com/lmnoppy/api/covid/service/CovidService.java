package com.lmnoppy.api.covid.service;

import com.lmnoppy.api.covid.ICovid;
import com.lmnoppy.api.covid.endpoints.CovidBulkApiEndPoint;
import com.lmnoppy.api.covid.model.Response;
import com.lmnoppy.api.covid.model.enums.Area;
import com.lmnoppy.api.covid.model.enums.Metrics;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.util.List;

@Service
public class CovidService implements ICovid {

    private final CovidBulkApiEndPoint covidBulkApiEndPoint;
    
    public CovidService(final CovidBulkApiEndPoint covidBulkApiEndPoint) {
        this.covidBulkApiEndPoint = covidBulkApiEndPoint;
    }

    @Override
    public Flux<Response> fetchCovidStatsForNation(Area area, List<Metrics> metrics, LocalDate date) {
        return covidBulkApiEndPoint.covidStatsForNation(area, metrics, date);
    }

}
