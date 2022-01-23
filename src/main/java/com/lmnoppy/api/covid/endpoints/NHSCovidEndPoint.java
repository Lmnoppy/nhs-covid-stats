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
