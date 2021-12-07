package com.lmnoppy.api.covid;

import com.lmnoppy.api.covid.model.enums.Metrics;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.util.List;

public interface ICovid  {

    Flux<List<String>> fetchCovidStatsForScotlandNationArea(List<Metrics> metrics, LocalDate date);

}
