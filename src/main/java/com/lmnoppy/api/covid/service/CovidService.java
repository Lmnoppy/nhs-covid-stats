package com.lmnoppy.api.covid.service;

import com.lmnoppy.api.covid.ICovid;
import com.lmnoppy.api.covid.endpoints.NHSCovidEndPoint;
import com.lmnoppy.api.covid.model.enums.Area;
import com.lmnoppy.api.covid.model.MetricsData;
import com.lmnoppy.api.covid.model.enums.AreaType;
import com.lmnoppy.api.covid.model.enums.Metrics;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CovidService implements ICovid {

    private final NHSCovidEndPoint nhsCovidEndPoint;

    public CovidService( final NHSCovidEndPoint nhsCovidEndPoint) {
        this.nhsCovidEndPoint = nhsCovidEndPoint;
    }

    @Override
    public Flux<List<MetricsData>> nhsFetchCovidStatsFor(Area area, AreaType areaType, List<Metrics> metrics) {
         return nhsCovidEndPoint.covidStatsFor(area, areaType, metrics);
    }

}
