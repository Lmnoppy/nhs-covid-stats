package com.lmnoppy.api.covid;

import com.fasterxml.jackson.databind.JsonNode;
import com.lmnoppy.api.covid.model.enums.Area;
import com.lmnoppy.api.covid.model.enums.AreaType;
import com.lmnoppy.api.covid.model.enums.Metrics;
import reactor.core.publisher.Flux;

import java.util.List;

public interface ICovid  {

    /**
     * Reusable generic service call
     * @param area Area name that you are searching for
     * @param areaType This can be nation, NHS region etc...
     * @param metrics The metrics you wish to return, please note, that not all Area types support all metrics
     * @return returns a mono list of the metrics.
     */
    Flux<JsonNode> fetchNHSCovidStatsFor(Area area, AreaType areaType, List<Metrics> metrics);

    /**
     * Fetches all available metrics for the given nation
     * @return returns a mono list of the metrics.
     */
    Flux<JsonNode> fetchAllSupportedNationDataForScotland();
    Flux<JsonNode> fetchAllSupportedNationDataForEngland();
    Flux<JsonNode> fetchAllSupportedNationDataForWales();
    Flux<JsonNode> fetchAllSupportedNationDataForNorthernIreland();
}
