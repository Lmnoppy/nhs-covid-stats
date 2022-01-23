package com.lmnoppy.api.covid.endpoints;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lmnoppy.api.covid.model.MetricsData;
import com.lmnoppy.api.covid.model.Response;
import com.lmnoppy.api.covid.model.enums.Area;
import com.lmnoppy.api.covid.model.enums.AreaType;
import com.lmnoppy.api.covid.model.enums.Metrics;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NHSCovidEndPointTest {

    private NHSCovidEndPoint NHSCovidEndPoint;
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
        NHSCovidEndPoint = new NHSCovidEndPoint(baseUrl);
    }

    @Test
    void covidStatsForNation() throws InterruptedException, JsonProcessingException {
        List<Metrics> requestStructures = requestStructuresBuilder();

        mockBackEnd.enqueue(new MockResponse()
                .setBody(metricsResponseBuilder())
                .addHeader("Content-Type", "application/json"));

        Mono<List<MetricsData>> testMono = NHSCovidEndPoint.covidStatsFor(Area.SCOTLAND, AreaType.NATION, requestStructures);

        StepVerifier.create(testMono)
                .expectNextMatches(metric -> metric.get(0).getAreaName().equals("Scotland") && metric.get(0).getDate().equals("2021-12-15"))
                .verifyComplete();

        RecordedRequest recordedRequest = mockBackEnd.takeRequest();

        assertEquals("GET", recordedRequest.getMethod());
        assertEquals("/?filters%3DareaName%3DScotland;areaType%3Dnation%26&structure%3D%257B"
                + "%2522date%2522:%2522date%2522,%2522areaName%2522:%2522areaName%2522,%2522areaCode%2522:%2522areaCode%2522,"
                + "%2522newCasesByPublishDate%2522:%2522newCasesByPublishDate%2522,%2522cumCasesByPublishDate%2522:%2522cumCasesByPublishDate%2522,"
                + "%2522newDeaths28DaysByPublishDate%2522:%2522newDeaths28DaysByPublishDate%2522,%2522cumDeaths28DaysByPublishDate%2522:%2522cumDeaths28DaysByPublishDate%2522,"
                + "%2522cumCasesByPublishDate%2522:%2522cumCasesByPublishDate%2522%257D", recordedRequest.getPath());
    }

    private List<Metrics> requestStructuresBuilder(){
        //String requestStructures= "structure={\"date\":\"date\",\"areaName\":\"areaName\",\"areaCode\":\"areaCode\",\"newCasesByPublishDate\":\"newCasesByPublishDate\",\"cumCasesByPublishDate\":\"cumCasesByPublishDate\",\"newDeaths28DaysByPublishDate\":\"newDeaths28DaysByPublishDate\"}";
        List<Metrics> requestStructures = new ArrayList<>();
        requestStructures.add(Metrics.DATE);
        requestStructures.add(Metrics.AREA_NAME);
        requestStructures.add(Metrics.AREA_CODE);
        requestStructures.add(Metrics.NEW_CASES_BY_PUBLISH_DATE);
        requestStructures.add(Metrics.CUM_CASES_BY_PUBLISH_DATE);
        requestStructures.add(Metrics.NEW_DEATHS_28_DAYS_BY_PUBLISH_DATE);
        requestStructures.add(Metrics.CUM_DEATHS_28_DAYS_BY_PUBLISH_DATE);
        requestStructures.add(Metrics.CUM_CASES_BY_PUBLISH_DATE);
        return requestStructures;
    }

    private String metricsResponseBuilder() throws JsonProcessingException {
        MetricsData m1 = new MetricsData();
        MetricsData m2 = new MetricsData();
        MetricsData m3 = new MetricsData();
        MetricsData m4 = new MetricsData();
        MetricsData m5 = new MetricsData();

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

        List<MetricsData> mockResponse = new ArrayList<>();
        mockResponse.add(m1);
        mockResponse.add(m2);
        mockResponse.add(m3);
        mockResponse.add(m4);
        mockResponse.add(m5);

        Response response = new Response();
        response.setLength("5");
        response.setMaxPageLimit("2500");
        response.setData(mockResponse);

        return objectMapper.writeValueAsString(response);
    }



}