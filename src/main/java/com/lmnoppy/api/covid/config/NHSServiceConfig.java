package com.lmnoppy.api.covid.config;

import com.lmnoppy.api.covid.endpoints.NHSCovidEndPoint;
import com.lmnoppy.api.covid.service.NHSCovidService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application-nhs.properties")
public class NHSServiceConfig {

    @Bean
    public NHSCovidEndPoint nhsCovidEndPoint(@Value("${nhs.covid.config.baseURL}") String baseURL) {
        return new NHSCovidEndPoint(baseURL);
    }

    @Bean
    @DependsOn("nhsCovidEndPoint")
    public NHSCovidService nhsCovidService(NHSCovidEndPoint nhsCovidEndPoint) {
        return new NHSCovidService(nhsCovidEndPoint);
    }
}
