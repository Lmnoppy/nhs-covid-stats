package com.lmnoppy.api.covid.endpoints;

import com.lmnoppy.api.covid.model.Response;
import com.lmnoppy.api.covid.model.enums.Area;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.util.Collections;

import static com.lmnoppy.api.covid.model.enums.Metrics.CUM_CASES_BY_PUBLISH_DATE;


@Slf4j
class CovidBulkApiEndPointTest {

    private CovidBulkApiEndPoint covidBulkApiEndPoint;

    @Test
    void getCovidStatsForNationArea(){
        covidBulkApiEndPoint = new CovidBulkApiEndPoint();

        Flux<Response> covidResponseFlux = covidBulkApiEndPoint.covidStatsForNation(Area.SCOTLAND, Collections.singletonList(CUM_CASES_BY_PUBLISH_DATE), LocalDate.of(2021, 12, 2));
        covidResponseFlux.subscribe(covidResponse ->
                System.out.println(covidResponse.toString())
    );

    }

}