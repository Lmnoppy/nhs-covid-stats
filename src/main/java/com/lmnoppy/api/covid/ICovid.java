package com.lmnoppy.api.covid;

import com.lmnoppy.api.covid.model.Response;
import com.lmnoppy.api.covid.model.enums.Area;
import com.lmnoppy.api.covid.model.Metrics;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.util.List;

public interface ICovid  {

    Flux<Response> fetchCovidStatsForNationBulk(Area area, List<Metrics> metrics, LocalDate date);

    Flux<List<Metrics>> fetchCovidStatsForNation(Area area, List<Metrics> metrics);
}
