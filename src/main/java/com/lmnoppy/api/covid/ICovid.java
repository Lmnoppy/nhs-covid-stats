package com.lmnoppy.api.covid;

import com.lmnoppy.api.covid.model.enums.Area;
import com.lmnoppy.api.covid.model.MetricsData;
import com.lmnoppy.api.covid.model.enums.AreaType;
import com.lmnoppy.api.covid.model.enums.Metrics;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ICovid  {

    /**
     * Reusable generic service call
     * @param area Area name that you are searching for
     * @param areaType This can be nation, NHS region etc...
     * @param metrics The metics you wish to return, please note, that not all Area types support all metrics
     * @return returns a mono list of the metrics.
     */
    Mono<List<MetricsData>> fetchNHSCovidStatsFor(Area area, AreaType areaType, List<Metrics> metrics);

    /**
     * Fetches all available metrics for the given nation
     * @return returns a mono list of the metrics.
     */
    Mono<List<MetricsData>> fetchAllSupportedNationDataForScotland();
    Mono<List<MetricsData>> fetchAllSupportedNationDataForEngland();
    Mono<List<MetricsData>> fetchAllSupportedNationDataForWales();
    Mono<List<MetricsData>> fetchAllSupportedNationDataForNorthernIreland();
}
