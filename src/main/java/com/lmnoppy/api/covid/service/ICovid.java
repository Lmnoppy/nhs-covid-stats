package com.lmnoppy.api.covid.service;

import com.lmnoppy.api.covid.model.Metrics;
import com.lmnoppy.api.covid.model.enums.Area;
import reactor.core.publisher.Flux;

import java.util.List;

public interface ICovid  {

    Flux<List<Metrics>> fetchCovidStatsForCountry(Area area);
    Flux<String> fetchCovidStatsForRegion(String region);

}
