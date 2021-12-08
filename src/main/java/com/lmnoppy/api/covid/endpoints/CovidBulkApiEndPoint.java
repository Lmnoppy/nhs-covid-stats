package com.lmnoppy.api.covid.endpoints;

import com.lmnoppy.api.covid.model.Response;
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
public class CovidBulkApiEndPoint {

    private static final String baseURL= "https://coronavirus.data.gov.uk/api/v2/data?";
    private final WebClient webClient;

    public CovidBulkApiEndPoint() {
        this.webClient = WebClient.builder().baseUrl(baseURL).build();
    }

    public Flux<Response> covidStatsForNation(Area area, List<Metrics> metrics, LocalDate date) {
        String urlBuilder = baseURL + "areaType=nation&" + date.toString() + "&" + metricURLBuilder(metrics) + "format=json&areaCode=" + area.getAreaCode();
        return webClient.post()
                .uri(urlBuilder)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToFlux(Response.class);
    }

    private String metricURLBuilder(List<Metrics> metricsList) {
        StringBuilder stringBuilder = new StringBuilder();
        metricsList.forEach(metrics -> {
            stringBuilder.append("metric=").append(metrics.getValue()).append("&");
        });
        return stringBuilder.toString();
    }

}
