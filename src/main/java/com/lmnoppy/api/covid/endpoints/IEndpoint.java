package com.lmnoppy.api.covid.endpoints;

import com.lmnoppy.api.covid.model.Response;
import com.lmnoppy.api.covid.model.enums.Area;
import com.lmnoppy.api.covid.model.enums.Metrics;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.util.List;

public sealed interface IEndpoint permits Endpoint {

    Flux<List<Response>> covidStatsForNation(Area area, List<Metrics> metrics, LocalDate date)
}
