package com.lmnoppy.api.covid.endpoints;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
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
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import reactor.core.publisher.Flux;
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

    @Test()
    @DisplayName("Covid Stats for different nations from the NHS Endpoint")
    void covidStatsForNation() throws InterruptedException, JsonProcessingException {
        List<Metrics> requestStructures = testHelper.requestStructure();
        Area area = Area.SCOTLAND;
        mockBackEnd.enqueue(new MockResponse()
                .setBody(metricsResponseBuilder(area))
                .addHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_NDJSON_VALUE));

        Flux<JsonNode> testMono = NHSCovidEndPoint.fetchCovidStatsFor(area, AreaType.NATION, requestStructures);

        StepVerifier.create(testMono)
                .expectNextMatches(metric ->
                        metric.get("areaName").asText().equals(area.getNation().getName())
                )
                .thenConsumeWhile(a -> true)
                .verifyComplete();

        RecordedRequest recordedRequest = mockBackEnd.takeRequest();

        assertEquals("GET", recordedRequest.getMethod());
        assertEquals("/?filters=areaName="+ area.getNation().getName().replace(" ", "%20") + ";areaType=nation&&structure=%7B"
                + "%22date%22:%22date%22,%22areaName%22:%22areaName%22,%22areaCode%22:%22areaCode%22,"
                + "%22newCasesByPublishDate%22:%22newCasesByPublishDate%22,%22cumCasesByPublishDate%22:%22cumCasesByPublishDate%22,"
                + "%22newDeaths28DaysByPublishDate%22:%22newDeaths28DaysByPublishDate%22,%22cumDeaths28DaysByPublishDate%22:%22cumDeaths28DaysByPublishDate%22,"
                + "%22cumCasesByPublishDate%22:%22cumCasesByPublishDate%22%7D", recordedRequest.getPath());
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