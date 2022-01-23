package com.lmnoppy.api.covid;

import com.lmnoppy.api.covid.model.enums.Area;
import com.lmnoppy.api.covid.model.MetricsData;
import com.lmnoppy.api.covid.model.enums.AreaType;
import com.lmnoppy.api.covid.model.enums.Metrics;
import reactor.core.publisher.Flux;

import java.util.List;

public interface ICovid  {

    Flux<List<MetricsData>> fetchCovidStatsFor(Area area, AreaType areaType, List<Metrics> metrics);
}
