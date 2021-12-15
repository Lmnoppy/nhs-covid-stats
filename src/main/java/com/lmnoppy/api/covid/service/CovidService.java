package com.lmnoppy.api.covid.service;

import com.lmnoppy.api.covid.ICovid;
import com.lmnoppy.api.covid.endpoints.CovidApiEndPoint;
import com.lmnoppy.api.covid.endpoints.CovidBulkApiEndPoint;
import com.lmnoppy.api.covid.model.Response;
import com.lmnoppy.api.covid.model.enums.Area;
import com.lmnoppy.api.covid.model.Metrics;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.util.List;

@Service
public class CovidService implements ICovid {

    private final CovidBulkApiEndPoint covidBulkApiEndPoint;
    private final CovidApiEndPoint covidApiEndPoint;

    public CovidService(final CovidBulkApiEndPoint covidBulkApiEndPoint, final CovidApiEndPoint covidApiEndPoint) {
        this.covidBulkApiEndPoint = covidBulkApiEndPoint;
        this.covidApiEndPoint = covidApiEndPoint;
    }

    @Override
    public Flux<Response> fetchCovidStatsForNationBulk(Area area, List<Metrics> metrics, LocalDate date) {
        return covidBulkApiEndPoint.covidStatsForNation(area, metrics, date);
    }

    @Override
    public Flux<List<Metrics>> fetchCovidStatsForNation(Area area, List<Metrics> metrics) {
         return covidApiEndPoint.covidStatsForNation(area, metrics);
    }

}
