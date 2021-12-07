package com.lmnoppy.api.covid.endpoints;

import com.lmnoppy.api.covid.model.enums.Area;
import com.lmnoppy.api.covid.model.enums.Metrics;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.util.List;

@Slf4j
final class Endpoint implements IEndpoint{

    private static final String baseURL= "https://coronavirus.data.gov.uk/api/v2/data?";
    private final WebClient webClient;

    public Endpoint() {
        this.webClient = WebClient.builder().baseUrl(baseURL).build();
    }

    @Override
    public Flux<List<String>> covidStatsForScotland(List<Metrics> metrics, LocalDate date) {
        //areaType=nation&release=2021-12-01&metric=cumCasesByPublishDate&format=json&areaCode=S92000003
        WebClient webClient = WebClient.create();
        String urlBuilder = baseURL + "areaType=nation&" + date.toString() + "&" + metricURLBuilder(metrics) + "&" + "format=json&areaCode=" + Area.SCOTLAND.getAreaCode();
        return webClient.post()
                .uri(requestURL)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToFlux(CovidResponse.class);
    }

    @Override
    public Flux<List<String>> covidStatsForNation(Area area, List<Metrics> metrics, LocalDate date) {
        WebClient webClient = WebClient.create();
        String urlBuilder = baseURL + "areaType=nation&" + date.toString() + "&" + metricURLBuilder(metrics) + "&" + "format=json&areaCode=" + area.getAreaCode();
        return null;
    }

    private String metricURLBuilder(List<Metrics> metricsList) {
        StringBuilder stringBuilder = new StringBuilder();
        metricsList.forEach(metrics -> {
            stringBuilder.append("metric=").append(metrics.getValue()).append("&");
        });
        return stringBuilder.toString();
    }

}
