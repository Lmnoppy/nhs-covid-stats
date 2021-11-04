package com.lmnoppy.api.covid.service;

import com.lmnoppy.api.covid.model.CovidResponse;
import com.lmnoppy.api.covid.model.enums.Area;
import reactor.core.publisher.Flux;

public interface ICovid  {

    Flux<CovidResponse> fetchCovidStatsForCountry(Area area);
    Flux<String> fetchCovidStatsForRegion(String region);

}
