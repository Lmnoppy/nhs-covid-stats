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
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
public class NHSCovidEndPoint {

    private final WebClient webClient;

    public NHSCovidEndPoint(final String baseURL) {
        this.webClient = WebClient.builder().baseUrl(baseURL).build();
    }

    public Mono<List<MetricsData>> fetchCovidStatsFor(Area area, AreaType areaType, List<Metrics> metricsList) {
        log.info("Making rest call to NHS end point for {}, {} with metrics: {}", area, areaType, metricsList.toString() );
        return webClient.get()
                .uri(uriBuilder ->
                        uriBuilder
                                .queryParam(buildRequestFilters(area, areaType))
                                .queryParam(buildRequestStructures(metricsList))
                                .build()
                )
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(Response.class)
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
