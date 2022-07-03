package com.lmnoppy.api.covid.endpoints;

import com.fasterxml.jackson.databind.JsonNode;
import com.lmnoppy.api.covid.model.exceptions.AreaTypeNotSupportException;
import com.lmnoppy.api.covid.model.MetricsData;
import com.lmnoppy.api.covid.model.Response;
import com.lmnoppy.api.covid.model.enums.Area;
import com.lmnoppy.api.covid.model.enums.AreaType;
import com.lmnoppy.api.covid.model.enums.Metrics;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ClientHttpRequest;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.List;

/*
 I hate JSON in GET requests, just make it a POST!
 */
@Slf4j
public class NHSCovidEndPoint {

    private final WebClient.Builder webClient;
    private final String baseURL;

    private static final String LEFT_BRACE = "{";
    private static final String RIGHT_BRACE = "}";
    private static final String STRUCTURE = "structure=" + LEFT_BRACE;
    private static final String AREA_TYPE_NATION = ";areaType=nation";
    private static final String AREA_NAME = "areaName=";
    private static final String FILTERS = "filters=";
    private static final String AREA_TYPE_REGION = ";areaType=region";

    public NHSCovidEndPoint(final String baseURL) {
        this.webClient = WebClient.builder();
        this.baseURL = baseURL;
    }

    private WebClient generateWebClient (){
        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(baseURL);
        factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.NONE);
        return webClient
                .clientConnector(
                        new ReactorClientHttpConnector(HttpClient.create()
                                .resolver(spec -> spec.queryTimeout(Duration.ofSeconds(10)))
                                .compress(true)))
                .codecs(clientCodecConfigurer -> clientCodecConfigurer.defaultCodecs().maxInMemorySize(5000000))
                .uriBuilderFactory(factory)
                .build();
    }

    //TODO: add error handling and bubble up custom exception based on error.
    public Flux<JsonNode> fetchCovidStatsFor(Area area, AreaType areaType, List<Metrics> metricsList) {
        log.info("Making rest call to NHS end point for {}, {} with metrics: {}", area, areaType, metricsList.toString());
        var request =  generateWebClient().get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam(buildRequestFilters(area, areaType))
                        .queryParam(buildRequestStructures(metricsList))
                        .build())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_NDJSON_VALUE);
        log.info("request URI: {}", request.httpRequest(ClientHttpRequest::getURI));
        return request.retrieve()
                .bodyToFlux(JsonNode.class)
                .flatMapIterable(jsonNode -> jsonNode.get("data"));
    }

    private String buildRequestFilters(Area area, AreaType areaType) throws AreaTypeNotSupportException, IllegalArgumentException {
        StringBuilder s = new StringBuilder(FILTERS);
        switch (areaType) {
            case NATION:
                s.append(AREA_NAME).append(area.getNation().getName().replace(" ", "%20")).append(AREA_TYPE_NATION);
                break;
            case REGION:
                s.append(AREA_NAME).append(area.getRegion()).append(AREA_TYPE_REGION);
                break;
            case LTLA:
            case UTLA:
            case OVERVIEW:
            case NHS_REGION:
                throw new AreaTypeNotSupportException("Valid filter, but currently not supported");
            default:
                throw new IllegalArgumentException("Unrecognized filter");
        }
        return s.append("&").toString();
    }

    private String buildRequestStructures(List<Metrics> structureList) {
        StringBuilder s = new StringBuilder(STRUCTURE);
        structureList.forEach(metric ->
                s.append("\"").append(metric.getMetricNameValue()).append("\"").append(":").append("\"").append(metric.getMetricNameValue()).append("\"").append(",")
        );
        return s.deleteCharAt(s.length() - 1).append("}").toString()
                .replace(LEFT_BRACE, "%7B")
                .replace("\"", "%22")
                .replace(RIGHT_BRACE, "%7D");
    }
}
