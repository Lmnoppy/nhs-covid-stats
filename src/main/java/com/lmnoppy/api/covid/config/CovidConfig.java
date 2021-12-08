package com.lmnoppy.api.covid.config;

import com.lmnoppy.api.covid.endpoints.CovidBulkApiEndPoint;
import com.lmnoppy.api.covid.service.CovidService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CovidConfig {

    public @Bean CovidService covidService(){
        return new CovidService(new CovidBulkApiEndPoint());
    }
}
