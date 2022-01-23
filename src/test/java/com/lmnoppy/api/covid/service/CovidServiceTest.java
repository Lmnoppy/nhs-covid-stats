package com.lmnoppy.api.covid.service;

import com.lmnoppy.api.covid.TestHelper;
import com.lmnoppy.api.covid.endpoints.EndpointRegistry;
import com.lmnoppy.api.covid.endpoints.NHSCovidEndPoint;
import com.lmnoppy.api.covid.model.MetricsData;
import com.lmnoppy.api.covid.model.enums.Area;
import com.lmnoppy.api.covid.model.enums.AreaType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;

class CovidServiceTest {

    @InjectMocks private CovidService covidService;
    @Mock private NHSCovidEndPoint nhsCovidEndPoint;
    @Mock private EndpointRegistry endpointRegistry;

    private TestHelper testHelper;

    @BeforeEach
    void setUp(){
        testHelper = new TestHelper();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void nhsFetchCovidStatsFor() {
        Mockito.when(endpointRegistry.getNHSCovidEndPoint()).thenReturn(nhsCovidEndPoint);
        Mockito.when(nhsCovidEndPoint.covidStatsFor(any(Area.class), any(AreaType.class), anyList())).thenReturn(Mono.just(testHelper.mockedData(Area.SCOTLAND)));

        Mono<List<MetricsData>> listMono = covidService.nhsFetchCovidStatsFor(Area.SCOTLAND, AreaType.NATION, testHelper.requestStructure());

        assertNotNull(listMono);
        assertEquals(Area.SCOTLAND.getNation().getName(), Objects.requireNonNull(listMono.block()).get(0).getAreaName());

        Mockito.verify(endpointRegistry, Mockito.times(1)).getNHSCovidEndPoint();
        Mockito.verify(nhsCovidEndPoint, Mockito.times(1)).covidStatsFor(any(Area.class), any(AreaType.class), anyList());
        Mockito.verifyNoMoreInteractions(endpointRegistry);
        Mockito.verifyNoMoreInteractions(nhsCovidEndPoint);
    }
}