package com.lmnoppy.api.covid.config;

import com.lmnoppy.api.covid.endpoints.CovidApiEndPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration()
public class ApplicationConfig {

    public @Bean CovidApiEndPoint covidApiEndPoint(){
        //TODO: pass in via config.
        String baseURL = "https://api.coronavirus.data.gov.uk/v1/data?";
        return new CovidApiEndPoint(baseURL);
    }
}
