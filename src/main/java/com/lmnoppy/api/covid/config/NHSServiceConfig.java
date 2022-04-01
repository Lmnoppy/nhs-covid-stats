package com.lmnoppy.api.covid.config;

import com.lmnoppy.api.covid.endpoints.EndpointRegistry;
import com.lmnoppy.api.covid.endpoints.NHSCovidEndPoint;
import com.lmnoppy.api.covid.service.NHSCovidService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NHSServiceConfig {

    public @Bean
    NHSCovidEndPoint nhsCovidEndPoint(@Value("${nhs.covid.config.baseURL}") String baseURL) {
        return new NHSCovidEndPoint(baseURL);
    }

    public @Bean
    NHSCovidService nhsCovidService(NHSCovidEndPoint nhsCovidEndPoint) {
        EndpointRegistry endpointRegistry = new EndpointRegistry.EndpointRegistryBuilder().nhsCovidEndPoint(nhsCovidEndPoint).build();
        return new NHSCovidService(endpointRegistry);
    }
}
