package com.lmnoppy.api.covid.config;

import com.lmnoppy.api.covid.service.CovidService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

class ServiceConfigTest {

    @InjectMocks private ServiceConfig serviceConfig;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void covidService() {
        CovidService covidService = serviceConfig.covidService(null);
        Assertions.assertNotNull(covidService);
    }
}