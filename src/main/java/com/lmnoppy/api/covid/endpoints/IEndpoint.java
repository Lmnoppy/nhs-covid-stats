package com.lmnoppy.api.covid.endpoints;

import com.lmnoppy.api.covid.model.CovidResponse;
import com.lmnoppy.api.covid.model.enums.Area;
import reactor.core.publisher.Flux;

public sealed interface IEndpoint permits Endpoint {

    Flux<CovidResponse> getCovidStatsForNationArea(Area area);
    Flux<String> getCovidStatsForRegion(String region);

}
