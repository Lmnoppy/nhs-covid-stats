package com.lmnoppy.api.covid;

import com.lmnoppy.api.covid.model.enums.Area;
import com.lmnoppy.api.covid.model.Metrics;
import com.lmnoppy.api.covid.model.enums.AreaType;
import com.lmnoppy.api.covid.model.enums.MetricsEnum;
import reactor.core.publisher.Flux;

import java.util.List;

public interface ICovid  {

    Flux<List<Metrics>> fetchCovidStatsForNation(Area area, AreaType areaType, List<MetricsEnum> metrics);
}
