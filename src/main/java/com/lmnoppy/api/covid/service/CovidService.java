package com.lmnoppy.api.covid.service;

import com.lmnoppy.api.covid.ICovid;
import com.lmnoppy.api.covid.endpoints.CovidApiEndPoint;
import com.lmnoppy.api.covid.model.enums.Area;
import com.lmnoppy.api.covid.model.Metrics;
import com.lmnoppy.api.covid.model.enums.AreaType;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CovidService implements ICovid {

    private final CovidApiEndPoint covidApiEndPoint;

    public CovidService( final CovidApiEndPoint covidApiEndPoint) {
        this.covidApiEndPoint = covidApiEndPoint;
    }

    @Override
    public Flux<List<Metrics>> fetchCovidStatsForNation(Area area, AreaType areaType, List<Metrics> metrics) {
         return covidApiEndPoint.covidStatsForNation(area, areaType, metrics);
    }

}
