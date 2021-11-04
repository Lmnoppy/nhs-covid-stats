package com.lmnoppy.api.covid.endpoints;

import com.lmnoppy.api.covid.model.Metrics;
import com.lmnoppy.api.covid.model.enums.Area;
import reactor.core.publisher.Flux;

import java.util.List;

public sealed interface IEndpoint permits Endpoint {

    Flux<List<Metrics>> getCovidStatsForNationArea(Area area);
    Flux<String> getCovidStatsForRegion(String region);

}
