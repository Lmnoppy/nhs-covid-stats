package com.lmnoppy.api.covid.endpoints;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lmnoppy.api.covid.TestHelper;
import com.lmnoppy.api.covid.model.MetricsData;
import com.lmnoppy.api.covid.model.Response;
import com.lmnoppy.api.covid.model.enums.Area;
import com.lmnoppy.api.covid.model.enums.AreaType;
import com.lmnoppy.api.covid.model.enums.Metrics;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NHSCovidEndPointTest {

    private NHSCovidEndPoint NHSCovidEndPoint;
    private static MockWebServer mockBackEnd;
    private ObjectMapper objectMapper;
    private TestHelper testHelper;

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
        testHelper = new TestHelper();
        objectMapper = new ObjectMapper();
        String baseUrl = String.format("http://localhost:%s", mockBackEnd.getPort());
        NHSCovidEndPoint = new NHSCovidEndPoint(baseUrl);
    }

    @ParameterizedTest()
    @EnumSource(Area.class)
    @DisplayName("Covid Stats for different nations from the NHS Endpoint")
    void covidStatsForNation(Area area) throws InterruptedException, JsonProcessingException {
        List<Metrics> requestStructures = testHelper.requestStructure();

        mockBackEnd.enqueue(new MockResponse()
                .setBody(metricsResponseBuilder(area))
                .addHeader("Content-Type", "application/json"));

        Mono<List<MetricsData>> testMono = NHSCovidEndPoint.fetchCovidStatsFor(area, AreaType.NATION, requestStructures);

        StepVerifier.create(testMono)
                .expectNextMatches(metric ->
                        metric.get(0).getAreaName().equals(area.getNation().getName())
                        && metric.get(0).getAreaCode().equals(area.getAreaCode())
                        && metric.get(0).getDate().equals("2021-12-15")
                )
                .verifyComplete();

        RecordedRequest recordedRequest = mockBackEnd.takeRequest();

        assertEquals("GET", recordedRequest.getMethod());
        assertEquals("/?filters%3DareaName%3D"+area.getNation().getName().replace(" ", "%20") + ";areaType%3Dnation%26&structure%3D%257B"
                + "%2522date%2522:%2522date%2522,%2522areaName%2522:%2522areaName%2522,%2522areaCode%2522:%2522areaCode%2522,"
                + "%2522newCasesByPublishDate%2522:%2522newCasesByPublishDate%2522,%2522cumCasesByPublishDate%2522:%2522cumCasesByPublishDate%2522,"
                + "%2522newDeaths28DaysByPublishDate%2522:%2522newDeaths28DaysByPublishDate%2522,%2522cumDeaths28DaysByPublishDate%2522:%2522cumDeaths28DaysByPublishDate%2522,"
                + "%2522cumCasesByPublishDate%2522:%2522cumCasesByPublishDate%2522%257D", recordedRequest.getPath());
    }

    private String metricsResponseBuilder(Area area) throws JsonProcessingException {

        List<MetricsData> mockResponse = testHelper.mockedData(area);

        Response response = new Response();
        response.setLength("5");
        response.setMaxPageLimit("2500");
        response.setData(mockResponse);

        return objectMapper.writeValueAsString(response);
    }

}