package com.lmnoppy.api.covid.endpoints;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lmnoppy.api.covid.model.Metrics;
import com.lmnoppy.api.covid.model.enums.Area;
import com.lmnoppy.api.covid.model.enums.AreaType;
import com.lmnoppy.api.covid.model.enums.MetricsEnum;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CovidApiEndPointTest {

    private CovidApiEndPoint covidApiEndPoint;
    private static MockWebServer mockBackEnd;
    private ObjectMapper objectMapper;

    @BeforeAll
    static void setUp() throws IOException {
        mockBackEnd = new MockWebServer();
        mockBackEnd.start();
    }

    @AfterAll
    static void tearDown() throws IOException {
        mockBackEnd.shutdown();
    }

    @BeforeEach
    void initialize() {
        objectMapper = new ObjectMapper();
        String baseUrl = String.format("http://localhost:%s", mockBackEnd.getPort());
        covidApiEndPoint = new CovidApiEndPoint(baseUrl);
    }

    @Test
    void covidStatsForNation() throws InterruptedException {
        List<MetricsEnum> requestStructures = requestStructuresBuilder();

        mockBackEnd.enqueue(new MockResponse()
                .setBody(metricsResponseBuilder())
                .addHeader("Content-Type", "application/json"));

        Flux<List<Metrics>> testFlux = covidApiEndPoint.covidStatsForNation(Area.SCOTLAND, AreaType.NATION, requestStructures);

        StepVerifier.create(testFlux)
                .expectNextMatches(metric -> metric.get(0).getAreaName().equals("Scotland"))
                .verifyComplete();

        RecordedRequest recordedRequest = mockBackEnd.takeRequest();

        assertEquals("GET", recordedRequest.getMethod());
        assertEquals("/employee/100", recordedRequest.getPath());
    }

    private List<MetricsEnum> requestStructuresBuilder(){
        //String requestStructures= "structure={\"date\":\"date\",\"areaName\":\"areaName\",\"areaCode\":\"areaCode\",\"newCasesByPublishDate\":\"newCasesByPublishDate\",\"cumCasesByPublishDate\":\"cumCasesByPublishDate\",\"newDeaths28DaysByPublishDate\":\"newDeaths28DaysByPublishDate\"}";
        List<MetricsEnum> requestStructures = new ArrayList<>();
        requestStructures.add(MetricsEnum.DATE);
        requestStructures.add(MetricsEnum.AREA_NAME);
        requestStructures.add(MetricsEnum.AREA_CODE);
        requestStructures.add(MetricsEnum.NEW_CASES_BY_PUBLISH_DATE);
        requestStructures.add(MetricsEnum.CUM_CASES_BY_PUBLISH_DATE);
        requestStructures.add(MetricsEnum.NEW_DEATHS_28_DAYS_BY_PUBLISH_DATE);
        requestStructures.add(MetricsEnum.CUM_DEATHS_28_DAYS_BY_PUBLISH_DATE);
        requestStructures.add(MetricsEnum.CUM_CASES_BY_PUBLISH_DATE);
        return requestStructures;
    }

    private String metricsResponseBuilder(){
        //Response example
        //[Metrics(date=2021-12-15, areaName=Scotland, areaCode=S92000003, newCasesByPublishDate=5155, cumCasesByPublishDate=777885, newDeaths28DaysByPublishDate=22)
        // Metrics(date=2021-12-14, areaName=Scotland, areaCode=S92000003, newCasesByPublishDate=3117, cumCasesByPublishDate=772738, newDeaths28DaysByPublishDate=6)
        // Metrics(date=2021-12-13, areaName=Scotland, areaCode=S92000003, newCasesByPublishDate=3756, cumCasesByPublishDate=769642, newDeaths28DaysByPublishDate=0)
        // Metrics(date=2021-12-12, areaName=Scotland, areaCode=S92000003, newCasesByPublishDate=4002, cumCasesByPublishDate=765889, newDeaths28DaysByPublishDate=0)
        // Metrics(date=2021-12-11, areaName=Scotland, areaCode=S92000003, newCasesByPublishDate=4087, cumCasesByPublishDate=761889, newDeaths28DaysByPublishDate=12)]

        Metrics m1 = new Metrics();
        Metrics m2 = new Metrics();
        Metrics m3 = new Metrics();
        Metrics m4 = new Metrics();
        Metrics m5 = new Metrics();

        m1.setDate("2021-12-15");
        m1.setAreaName("Scotland");
        m1.setAreaCode("S92000003");
        m1.setNewCasesByPublishDate("5155");
        m1.setCumCasesByPublishDate("777885");
        m1.setNewDeaths28DaysByPublishDate("22");

        m2.setDate("2021-12-14");
        m2.setAreaName("Scotland");
        m2.setAreaCode("S92000003");
        m2.setNewCasesByPublishDate("3117");
        m2.setCumCasesByPublishDate("772738");
        m2.setNewDeaths28DaysByPublishDate("6");

        m3.setDate("2021-12-13");
        m3.setAreaName("Scotland");
        m3.setAreaCode("S92000003");
        m3.setNewCasesByPublishDate("3756");
        m3.setCumCasesByPublishDate("777885");
        m3.setNewDeaths28DaysByPublishDate("0");

        m4.setDate("2021-12-12");
        m4.setAreaName("Scotland");
        m4.setAreaCode("S92000003");
        m4.setNewCasesByPublishDate("4002");
        m4.setCumCasesByPublishDate("769642");
        m4.setNewDeaths28DaysByPublishDate("0");

        m5.setDate("2021-12-11");
        m5.setAreaName("Scotland");
        m5.setAreaCode("S92000003");
        m5.setNewCasesByPublishDate("4087");
        m5.setCumCasesByPublishDate("765889");
        m5.setNewDeaths28DaysByPublishDate("12");

        List<Metrics> mockResponse = new ArrayList<>();
        mockResponse.add(m1);
        mockResponse.add(m2);
        mockResponse.add(m3);
        mockResponse.add(m4);
        mockResponse.add(m5);
        return mockResponse.toString();
    }



}