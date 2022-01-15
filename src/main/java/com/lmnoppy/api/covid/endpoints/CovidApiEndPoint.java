package com.lmnoppy.api.covid.endpoints;

import com.lmnoppy.api.covid.model.Metrics;
import com.lmnoppy.api.covid.model.Response;
import com.lmnoppy.api.covid.model.enums.Area;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;

@Slf4j
public class CovidApiEndPoint {

    private static final String baseURL= "https://api.coronavirus.data.gov.uk/v1/data?";
    private final WebClient webClient;

    public CovidApiEndPoint() {
        this.webClient = WebClient.builder().baseUrl(baseURL).build();
    }

    public Flux<List<Metrics>> covidStatsForNation(Area area, List<Metrics> structureList) {
        String requestFilters = "filters=areaName=" + area.getNation() +";areaType=nation&";
        String requestStructures= "structure={\"date\":\"date\",\"areaName\":\"areaName\",\"areaCode\":\"areaCode\",\"newCasesByPublishDate\":\"newCasesByPublishDate\",\"cumCasesByPublishDate\":\"cumCasesByPublishDate\",\"newDeaths28DaysByPublishDate\":\"newDeaths28DaysByPublishDate\"}";

        return webClient.get()
                .uri(uriBuilder ->
                        uriBuilder
                                .queryParam(requestFilters)
                                .queryParam(requestStructures
                                        .replace("{", "%7B" )
                                        .replace("\"", "%22")
                                        .replace("}", "%7D"))
                                .build()
                )
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToFlux(Response.class)
                .map(Response::getData);
    }

    //Response example
    //[Metrics(date=2021-12-15, areaName=Scotland, areaCode=S92000003, newCasesByPublishDate=5155, cumCasesByPublishDate=777885, newDeaths28DaysByPublishDate=22)
    // Metrics(date=2021-12-14, areaName=Scotland, areaCode=S92000003, newCasesByPublishDate=3117, cumCasesByPublishDate=772738, newDeaths28DaysByPublishDate=6)
    // Metrics(date=2021-12-13, areaName=Scotland, areaCode=S92000003, newCasesByPublishDate=3756, cumCasesByPublishDate=769642, newDeaths28DaysByPublishDate=0)
    // Metrics(date=2021-12-12, areaName=Scotland, areaCode=S92000003, newCasesByPublishDate=4002, cumCasesByPublishDate=765889, newDeaths28DaysByPublishDate=0)
    // Metrics(date=2021-12-11, areaName=Scotland, areaCode=S92000003, newCasesByPublishDate=4087, cumCasesByPublishDate=761889, newDeaths28DaysByPublishDate=12)
    // Metrics(date=2021-12-10, areaName=Scotland, areaCode=S92000003, newCasesByPublishDate=5018, cumCasesByPublishDate=757813, newDeaths28DaysByPublishDate=19)
    // Metrics(date=2021-12-09, areaName=Scotland, areaCode=S92000003, newCasesByPublishDate=3196, cumCasesByPublishDate=752805, newDeaths28DaysByPublishDate=16)
    // Metrics(date=2021-12-08, areaName=Scotland, areaCode=S92000003, newCasesByPublishDate=3077, cumCasesByPublishDate=749620, newDeaths28DaysByPublishDate=11)
    // Metrics(date=2021-12-07, areaName=Scotland, areaCode=S92000003, newCasesByPublishDate=3060, cumCasesByPublishDate=746549, newDeaths28DaysByPublishDate=12)
    // Metrics(date=2021-12-06, areaName=Scotland, areaCode=S92000003, newCasesByPublishDate=3894, cumCasesByPublishDate=743496, newDeaths28DaysByPublishDate=0)]

}
