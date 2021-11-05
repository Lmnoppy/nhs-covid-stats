package com.lmnoppy.api.covid.endpoints;

import com.lmnoppy.api.covid.model.CovidResponse;
import com.lmnoppy.api.covid.model.Metrics;
import com.lmnoppy.api.covid.model.enums.Area;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.Collections;
import java.util.List;

@Slf4j
final class Endpoint implements IEndpoint{

    private static final String baseURL= "https://api.coronavirus.data.gov.uk/v1/data?";
    private WebClient webClient;

    public Endpoint() {
        this.webClient = WebClient.builder().baseUrl(baseURL).build();
    }

    public Flux<List<Metrics>> getCovidStatsForNationArea(Area area) {
        String requestFilters = "filters=areaName=" + area.getNation() +";areaType=nation&";
        String requestStructures= "structure={\"date\":\"date\",\"areaName\":\"areaName\",\"areaCode\":\"areaCode\",\"newCasesByPublishDate\":\"newCasesByPublishDate\",\"cumCasesByPublishDate\":\"cumCasesByPublishDate\",\"newDeaths28DaysByPublishDate\":\"newDeaths28DaysByPublishDate\",\"cumDeaths28DaysByPublishDate\":\"cumDeaths28DaysByPublishDate\"}";

        return this.webClient.get()
                .uri(uriBuilder ->
                        uriBuilder.queryParam(
                                requestFilters.concat(requestStructures.replace("{", "%7B" ).replace("}", "%7D")))
                                .build())
                .retrieve()
                .bodyToFlux(CovidResponse.class)
                .map(CovidResponse::getData);
    }

    @Override
    public Flux<String> getCovidStatsForRegion(String region) {
        return null;
    }
}
