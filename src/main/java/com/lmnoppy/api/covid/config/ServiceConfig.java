package com.lmnoppy.api.covid.config;

import com.lmnoppy.api.covid.endpoints.EndpointRegistry;
import com.lmnoppy.api.covid.endpoints.EndpointRegistry.EndpointRegistryBuilder;
import com.lmnoppy.api.covid.endpoints.NHSCovidEndPoint;
import com.lmnoppy.api.covid.service.CovidService;
import org.springframework.context.annotation.Bean;

public class ServiceConfig {

    public @Bean CovidService covidService(NHSCovidEndPoint nhsCovidEndPoint){
        EndpointRegistry endpointRegistry = new EndpointRegistryBuilder().nhsCovidEndPoint(nhsCovidEndPoint).build();
        return new CovidService(endpointRegistry);
    }

}
