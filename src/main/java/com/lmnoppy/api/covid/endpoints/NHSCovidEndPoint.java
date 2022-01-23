package com.lmnoppy.api.covid.endpoints;

import com.lmnoppy.api.covid.model.MetricsData;
import com.lmnoppy.api.covid.model.Response;
import com.lmnoppy.api.covid.model.enums.Area;
import com.lmnoppy.api.covid.model.enums.AreaType;
import com.lmnoppy.api.covid.model.enums.Metrics;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;

@Slf4j
public class NHSCovidEndPoint {

    private final WebClient webClient;
    private final String baseURL;

    public NHSCovidEndPoint(final String baseURL) {
        this.baseURL = baseURL;
        this.webClient = WebClient.builder().baseUrl(baseURL).build();
    }

    public Flux<List<MetricsData>> covidStatsFor(Area area, AreaType areaType, List<Metrics> structureList) {
        log.debug(baseURL+buildRequestFilters(area, areaType)+buildRequestStructures(structureList));
        return webClient.get()
                .uri(uriBuilder ->
                        uriBuilder
                                .queryParam(buildRequestFilters(area, areaType))
                                .queryParam(buildRequestStructures(structureList))
                                .build()
                )
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToFlux(Response.class)
                .map(Response::getData);
    }

    private String buildRequestFilters(Area area, AreaType areaType){
        StringBuilder s = new StringBuilder("filters=");
        switch (areaType) {
            case NATION -> s.append("areaName=").append(area.getNation().getName()).append(";areaType=nation");
            case REGION -> s.append("areaName=").append(area.getRegion()).append(";areaType=region");
            case LTLA, UTLA, NHSREGION -> throw new IllegalArgumentException("Valid filter, but currently not supported, please see Jira: ABC");
            default -> throw new IllegalArgumentException("Unrecognized filter");
        }
        return s.append("&").toString();
    }

    private String buildRequestStructures(List<Metrics> structureList){
        StringBuilder s = new StringBuilder("structure={");
        structureList.forEach(metric ->
                s.append("\"").append(metric.getMetricNameValue()).append("\"").append(":").append("\"").append(metric.getMetricNameValue()).append("\"").append(",")
        );
        return s.deleteCharAt(s.length() - 1).append("}").toString()
                .replace("{", "%7B")
                .replace("\"", "%22")
                .replace("}", "%7D");
    }
}
