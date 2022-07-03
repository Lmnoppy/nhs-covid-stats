package com.lmnoppy.api.covid.cucumber;

import com.lmnoppy.api.covid.ICovid;
import com.lmnoppy.api.covid.model.enums.Area;
import com.lmnoppy.api.covid.model.enums.AreaType;
import com.lmnoppy.api.covid.model.enums.Metrics;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Slf4j
@CucumberContextConfiguration
@SpringBootTest(classes = CucumberConfig.class)
@ActiveProfiles("test")
@TestPropertySource("classpath:application.properties")
public class NHSSteps {

    protected ICovid iCovid;

    public NHSSteps(ICovid iCovid) {
        this.iCovid = iCovid;
    }

    @Given("^The ICovid interface is setUp$")
    public void theFetchNHSCovidStatsForInICovidIsCalled() {
        Assertions.assertNotNull(iCovid);
    }

    @Given("^fetchNHSCovidStatsFor is called with$")
    public void fetchNHSCovidStatsForIsCalledWith(DataTable dataTable) {
        var rows = dataTable.asLists();
        for (List<String> row : rows) {
            var jsonNodeFlux = iCovid.fetchNHSCovidStatsFor(Area.valueOf(row.get(1)), AreaType.valueOf(row.get(0)),
                    Arrays.stream(row.get(2).split(",")).map(Metrics::valueOf).collect(Collectors.toList()));
            StepVerifier.create(jsonNodeFlux)
                    .expectNextMatches(metric -> {
                                Assertions.assertNotNull(metric);
                                Assertions.assertEquals(Area.valueOf(
                                                metric.get("areaName").asText().equalsIgnoreCase("NORTHERN IRELAND") ? "NORTHERN_IRELAND" : metric.get("areaName").asText().toUpperCase(Locale.ROOT)),
                                        Area.valueOf(row.get(1)));
                                return true;
                            }
                    )
                    .thenConsumeWhile(x -> true)
                    .verifyComplete();
        }
    }

    @Given("^fetchAllSupportedNationDataForScotland is called$")
    public void fetchAllSupportedNationDataForScotlandIsCalled() {
        var jsonNodeFlux = iCovid.fetchAllSupportedNationDataForScotland();
        StepVerifier.create(jsonNodeFlux)
                .expectNextMatches(metric -> {
                            Assertions.assertNotNull(metric);
                            Assertions.assertEquals(Area.SCOTLAND, Area.valueOf(metric.get("areaName").asText().toUpperCase(Locale.ROOT)));
                            return true;
                        }
                )
                .thenConsumeWhile(x -> true)
                .verifyComplete();
    }

    @Given("^fetchAllSupportedNationDataForWales is called$")
    public void fetchAllSupportedNationDataForWales() {
        var jsonNodeFlux = iCovid.fetchAllSupportedNationDataForWales();
        StepVerifier.create(jsonNodeFlux)
                .expectNextMatches(metric -> {
                            Assertions.assertNotNull(metric);
                            Assertions.assertEquals(Area.WALES, Area.valueOf(metric.get("areaName").asText().toUpperCase(Locale.ROOT)));
                            return true;
                        }
                )
                .thenConsumeWhile(x -> true)
                .verifyComplete();
    }

    @Given("^fetchAllSupportedNationDataForEngland is called$")
    public void fetchAllSupportedNationDataForEngland() {
        var jsonNodeFlux = iCovid.fetchAllSupportedNationDataForEngland();
        StepVerifier.create(jsonNodeFlux)
                .expectNextMatches(metric -> {
                            Assertions.assertNotNull(metric);
                            Assertions.assertEquals(Area.ENGLAND, Area.valueOf(metric.get("areaName").asText().toUpperCase(Locale.ROOT)));
                            return true;
                        }
                )
                .thenConsumeWhile(x -> true)
                .verifyComplete();
    }

    @Given("^fetchAllSupportedNationDataForNorthernIreland is called$")
    public void fetchAllSupportedNationDataForNorthernIreland() {
        var jsonNodeFlux = iCovid.fetchAllSupportedNationDataForNorthernIreland();
        StepVerifier.create(jsonNodeFlux)
                .expectNextMatches(metric -> {
                            Assertions.assertNotNull(metric);
                            Assertions.assertEquals(
                                    Area.NORTHERN_IRELAND,
                                    Area.valueOf(metric.get("areaName").asText().equalsIgnoreCase("NORTHERN IRELAND") ? "NORTHERN_IRELAND" : metric.get("areaName").asText().toUpperCase(Locale.ROOT)));
                            return true;
                        }
                )
                .thenConsumeWhile(x -> true)
                .verifyComplete();
    }
}
