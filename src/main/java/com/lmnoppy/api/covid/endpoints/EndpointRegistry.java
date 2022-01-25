package com.lmnoppy.api.covid.endpoints;

public class EndpointRegistry {

    private final NHSCovidEndPoint nhsCovidEndPoint;

    public EndpointRegistry(EndpointRegistryBuilder endpointRegistryBuilder) {
        this.nhsCovidEndPoint = endpointRegistryBuilder.nhsCovidEndPoint;
    }

    public NHSCovidEndPoint nhsCovidEndPoint() {
        return nhsCovidEndPoint;
    }

    public static class EndpointRegistryBuilder {

        private NHSCovidEndPoint nhsCovidEndPoint;

        public EndpointRegistryBuilder(){}

        public EndpointRegistryBuilder nhsCovidEndPoint(NHSCovidEndPoint nhsCovidEndPoint){
            this.nhsCovidEndPoint = nhsCovidEndPoint;
            return this;
        }

        public EndpointRegistry build() {
            return new EndpointRegistry(this);
        }
    }
}
