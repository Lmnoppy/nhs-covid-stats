package com.lmnoppy.api.covid;

import com.lmnoppy.api.covid.model.enums.Area;
import com.lmnoppy.api.covid.model.MetricsData;
import com.lmnoppy.api.covid.model.enums.AreaType;
import com.lmnoppy.api.covid.model.enums.Metrics;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ICovid  {

    Mono<List<MetricsData>> nhsFetchCovidStatsFor(Area area, AreaType areaType, List<Metrics> metrics);
}
