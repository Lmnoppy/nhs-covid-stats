package com.lmnoppy.api.covid.service;

import com.lmnoppy.api.covid.endpoints.IEndpoint;

sealed class CovidService implements ICovid {

    private IEndpoint iEndpoint;


    CovidService(IEndpoint iEndpoint) {
        this.iEndpoint = iEndpoint;
    }
}
