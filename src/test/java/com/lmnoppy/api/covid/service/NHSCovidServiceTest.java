package com.lmnoppy.api.covid.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.lmnoppy.api.covid.TestHelper;
import com.lmnoppy.api.covid.endpoints.NHSCovidEndPoint;
import com.lmnoppy.api.covid.model.enums.Area;
import com.lmnoppy.api.covid.model.enums.AreaType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.io.IOException;
import java.util.Locale;
import java.util.stream.StreamSupport;

import static org.mockito.ArgumentMatchers.*;

class NHSCovidServiceTest {

    @InjectMocks private NHSCovidService NHSCovidService;
    @Mock private NHSCovidEndPoint nhsCovidEndPoint;

    private TestHelper testHelper;

    @BeforeEach
    void setUp(){
        testHelper = new TestHelper();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void nhsFetchCovidStatsFor() throws IOException {
        Mockito.when(nhsCovidEndPoint.fetchCovidStatsFor(any(Area.class), any(AreaType.class), anyList())).thenReturn(Flux.just(testHelper.jsonNodeData().get("data")));

        Flux<JsonNode> jsonNodeFlux = NHSCovidService.fetchNHSCovidStatsFor(Area.SCOTLAND, AreaType.NATION, testHelper.requestStructure());
        StepVerifier.create(jsonNodeFlux)
                .thenConsumeWhile(metric -> {
                    Assertions.assertNotNull(metric);
                    Assertions.assertEquals(61, metric.size());
                    Assertions.assertTrue(StreamSupport.stream(metric.spliterator(), true)
                            .filter(j -> j.get("areaName") != null)
                            .allMatch(
                                    j -> Area.valueOf(j.get("areaName").asText().toUpperCase(Locale.ROOT)).equals(Area.SCOTLAND))
                    );
                    return true;
                })
                .verifyComplete();
        Mockito.verify(nhsCovidEndPoint, Mockito.times(1)).fetchCovidStatsFor(any(Area.class), any(AreaType.class), anyList());
        Mockito.verifyNoMoreInteractions(nhsCovidEndPoint);
    }

    @Test
    void fetchAllSupportedNationDataForScotland() throws IOException {
        Mockito.when(nhsCovidEndPoint.fetchCovidStatsFor(eq(Area.SCOTLAND), eq(AreaType.NATION), anyList())).thenReturn(Flux.just(testHelper.jsonNodeData().get("data")));

        Flux<JsonNode> jsonNodeFlux = NHSCovidService.fetchAllSupportedNationDataForScotland();
        StepVerifier.create(jsonNodeFlux)
                .thenConsumeWhile(metric -> {
                    Assertions.assertNotNull(metric);
                    Assertions.assertEquals(61, metric.size());
                    Assertions.assertTrue(StreamSupport.stream(metric.spliterator(), true)
                                .filter(j -> j.get("areaName") != null)
                                .allMatch(
                                        j -> Area.valueOf(j.get("areaName").asText().toUpperCase(Locale.ROOT)).equals(Area.SCOTLAND))
                        );
                    return true;
                })
                .verifyComplete();
        Mockito.verify(nhsCovidEndPoint, Mockito.times(1)).fetchCovidStatsFor(eq(Area.SCOTLAND), eq(AreaType.NATION), anyList());
        Mockito.verifyNoMoreInteractions(nhsCovidEndPoint);
    }

    @Test
    void fetchAllSupportedNationDataForEngland() throws IOException {
        Mockito.when(nhsCovidEndPoint.fetchCovidStatsFor(any(Area.class), any(AreaType.class), anyList())).thenReturn(Flux.just(testHelper.jsonNodeData().get("data")));

        Flux<JsonNode> jsonNodeFlux = NHSCovidService.fetchAllSupportedNationDataForEngland();
        StepVerifier.create(jsonNodeFlux)
                .thenConsumeWhile(metric -> {
                    Assertions.assertNotNull(metric);
                    Assertions.assertEquals(61, metric.size());
                    return true;
                })
                .verifyComplete();
        Mockito.verify(nhsCovidEndPoint, Mockito.times(1)).fetchCovidStatsFor(any(Area.class), any(AreaType.class), anyList());
        Mockito.verifyNoMoreInteractions(nhsCovidEndPoint);
    }

    @Test
    void fetchAllSupportedNationDataForWales() throws IOException {
        Mockito.when(nhsCovidEndPoint.fetchCovidStatsFor(any(Area.class), any(AreaType.class), anyList())).thenReturn(Flux.just(testHelper.jsonNodeData().get("data")));

        Flux<JsonNode> jsonNodeFlux = NHSCovidService.fetchAllSupportedNationDataForWales();
        StepVerifier.create(jsonNodeFlux)
                .thenConsumeWhile(metric -> {
                    Assertions.assertNotNull(metric);
                    Assertions.assertEquals(61, metric.size());
                    return true;
                })
                .verifyComplete();
        Mockito.verify(nhsCovidEndPoint, Mockito.times(1)).fetchCovidStatsFor(any(Area.class), any(AreaType.class), anyList());
        Mockito.verifyNoMoreInteractions(nhsCovidEndPoint);
    }

    @Test
    void fetchAllSupportedNationDataForNorthernIreland() throws IOException {
        Mockito.when(nhsCovidEndPoint.fetchCovidStatsFor(any(Area.class), any(AreaType.class), anyList())).thenReturn(Flux.just(testHelper.jsonNodeData().get("data")));

        Flux<JsonNode> jsonNodeFlux = NHSCovidService.fetchAllSupportedNationDataForNorthernIreland();
        StepVerifier.create(jsonNodeFlux)
                .thenConsumeWhile(metric -> {
                    Assertions.assertNotNull(metric);
                    Assertions.assertEquals(61, metric.size());
                    return true;
                })
                .verifyComplete();
        Mockito.verify(nhsCovidEndPoint, Mockito.times(1)).fetchCovidStatsFor(any(Area.class), any(AreaType.class), anyList());
        Mockito.verifyNoMoreInteractions(nhsCovidEndPoint);
    }
}