package com.lmnoppy.api.covid.endpoints;

import com.lmnoppy.api.covid.model.CovidResponse;
import com.lmnoppy.api.covid.model.enums.Area;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

final class Endpoint implements IEndpoint{

    private static final String baseURL= "https://api.coronavirus.data.gov.uk/v1/data?";

    public Flux<CovidResponse> getCovidStatsForNationArea(Area area) {
        String requestURL = "filters=areaName=" + area.name() +";areaType=nation&"
                + "structure={\"date\":\"date\",\"name\":\"areaName\",\"code\":\"areaCode\",\"newCasesByPublishDate\":\"newCasesByPublishDate\",\"cumCasesByPublishDate\":\"cumCasesByPublishDate\",\"newDeaths28DaysByPublishDate\":\"newDeaths28DaysByPublishDate\",\"cumDeaths28DaysByPublishDate\":\"cumDeaths28DaysByPublishDate\"}";

        WebClient webClient = WebClient.create(baseURL);

        return webClient.post()
                .uri(requestURL)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToFlux(CovidResponse.class);
    }

    @Override
    public Flux<String> getCovidStatsForRegion(String region) {
        return null;
    }
}
