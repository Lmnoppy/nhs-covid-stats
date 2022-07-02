package com.lmnoppy.api.covid.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.lmnoppy.api.covid.TestHelper;
import com.lmnoppy.api.covid.endpoints.NHSCovidEndPoint;
import com.lmnoppy.api.covid.model.enums.Area;
import com.lmnoppy.api.covid.model.enums.AreaType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Flux;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;

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
        Mockito.when(nhsCovidEndPoint.fetchCovidStatsFor(any(Area.class), any(AreaType.class), anyList())).thenReturn(Flux.just(testHelper.jsonNodeData()));

        Flux<JsonNode> jsonNodeFlux = NHSCovidService.fetchNHSCovidStatsFor(Area.SCOTLAND, AreaType.NATION, testHelper.requestStructure());
        //TODO: add step verifier.
        assertNotNull(jsonNodeFlux);

        Mockito.verify(nhsCovidEndPoint, Mockito.times(1)).fetchCovidStatsFor(any(Area.class), any(AreaType.class), anyList());
        Mockito.verifyNoMoreInteractions(nhsCovidEndPoint);
    }

    @Test
    void fetchAllSupportedNationDataForScotland() throws IOException {
        Mockito.when(nhsCovidEndPoint.fetchCovidStatsFor(any(Area.class), any(AreaType.class), anyList())).thenReturn(Flux.just(testHelper.jsonNodeData()));

        Flux<JsonNode> jsonNodeFlux = NHSCovidService.fetchAllSupportedNationDataForScotland();
        //TODO: add step verifier.
        assertNotNull(jsonNodeFlux);

        Mockito.verify(nhsCovidEndPoint, Mockito.times(1)).fetchCovidStatsFor(any(Area.class), any(AreaType.class), anyList());
        Mockito.verifyNoMoreInteractions(nhsCovidEndPoint);
    }

    @Test
    void fetchAllSupportedNationDataForEngland() throws IOException {
        Mockito.when(nhsCovidEndPoint.fetchCovidStatsFor(any(Area.class), any(AreaType.class), anyList())).thenReturn(Flux.just(testHelper.jsonNodeData()));

        Flux<JsonNode> jsonNodeFlux = NHSCovidService.fetchAllSupportedNationDataForEngland();
        //TODO: add step verifier.
        assertNotNull(jsonNodeFlux);

        Mockito.verify(nhsCovidEndPoint, Mockito.times(1)).fetchCovidStatsFor(any(Area.class), any(AreaType.class), anyList());
        Mockito.verifyNoMoreInteractions(nhsCovidEndPoint);
    }

    @Test
    void fetchAllSupportedNationDataForWales() throws IOException {
        Mockito.when(nhsCovidEndPoint.fetchCovidStatsFor(any(Area.class), any(AreaType.class), anyList())).thenReturn(Flux.just(testHelper.jsonNodeData()));

        Flux<JsonNode> jsonNodeFlux = NHSCovidService.fetchAllSupportedNationDataForWales();
        //TODO: add step verifier.
        assertNotNull(jsonNodeFlux);

        Mockito.verify(nhsCovidEndPoint, Mockito.times(1)).fetchCovidStatsFor(any(Area.class), any(AreaType.class), anyList());
        Mockito.verifyNoMoreInteractions(nhsCovidEndPoint);
    }

    @Test
    void fetchAllSupportedNationDataForNorthernIreland() throws IOException {
        Mockito.when(nhsCovidEndPoint.fetchCovidStatsFor(any(Area.class), any(AreaType.class), anyList())).thenReturn(Flux.just(testHelper.jsonNodeData()));

        Flux<JsonNode> jsonNodeFlux = NHSCovidService.fetchAllSupportedNationDataForNorthernIreland();
        //TODO: add step verifier.
        assertNotNull(jsonNodeFlux);

        Mockito.verify(nhsCovidEndPoint, Mockito.times(1)).fetchCovidStatsFor(any(Area.class), any(AreaType.class), anyList());
        Mockito.verifyNoMoreInteractions(nhsCovidEndPoint);
    }
}