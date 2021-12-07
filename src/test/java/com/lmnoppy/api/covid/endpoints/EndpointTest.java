package com.lmnoppy.api.covid.endpoints;

import com.lmnoppy.api.covid.model.enums.Area;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

import java.util.List;


@Slf4j
class EndpointTest {

    private Endpoint endpoint;

    @Test
    void getCovidStatsForNationArea(){
        endpoint = new Endpoint();

        Flux<List<Metrics>> covidResponseFlux = endpoint.getCovidStatsForNationArea(Area.ENGLAND);
        covidResponseFlux.subscribe(covidResponse ->
                System.out.println(covidResponse.toString())
    );

    }

}