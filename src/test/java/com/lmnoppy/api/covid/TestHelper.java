package com.lmnoppy.api.covid;

import com.lmnoppy.api.covid.model.MetricsData;
import com.lmnoppy.api.covid.model.enums.Area;
import com.lmnoppy.api.covid.model.enums.Metrics;

import java.util.ArrayList;
import java.util.List;

public class TestHelper {

    public List<Metrics> requestStructure(){
        List<Metrics> requestStructures = new ArrayList<>();
        requestStructures.add(Metrics.DATE);
        requestStructures.add(Metrics.AREA_NAME);
        requestStructures.add(Metrics.AREA_CODE);
        requestStructures.add(Metrics.NEW_CASES_BY_PUBLISH_DATE);
        requestStructures.add(Metrics.CUM_CASES_BY_PUBLISH_DATE);
        requestStructures.add(Metrics.NEW_DEATHS_28DAYS_BY_PUBLISH_DATE);
        requestStructures.add(Metrics.CUM_DEATHS_28DAYS_BY_PUBLISH_DATE);
        requestStructures.add(Metrics.CUM_CASES_BY_PUBLISH_DATE);
        return requestStructures;
    }

    public List<MetricsData> mockedData(Area area){

        MetricsData m1 = new MetricsData();
        MetricsData m2 = new MetricsData();
        MetricsData m3 = new MetricsData();
        MetricsData m4 = new MetricsData();
        MetricsData m5 = new MetricsData();

        m1.setDate("2021-12-15");
        m1.setAreaName(area.getNation().getName());
        m1.setAreaCode(area.getAreaCode());
        m1.setNewCasesByPublishDate("5155");
        m1.setCumCasesByPublishDate("777885");
        m1.setNewDeaths28DaysByPublishDate("22");

        m2.setDate("2021-12-14");
        m2.setAreaName(area.getNation().getName());
        m2.setAreaCode(area.getAreaCode());
        m2.setNewCasesByPublishDate("3117");
        m2.setCumCasesByPublishDate("772738");
        m2.setNewDeaths28DaysByPublishDate("6");

        m3.setDate("2021-12-13");
        m3.setAreaName(area.getNation().getName());
        m3.setAreaCode(area.getAreaCode());
        m3.setNewCasesByPublishDate("3756");
        m3.setCumCasesByPublishDate("777885");
        m3.setNewDeaths28DaysByPublishDate("0");

        m4.setDate("2021-12-12");
        m4.setAreaName(area.getNation().getName());
        m4.setAreaCode(area.getAreaCode());
        m4.setNewCasesByPublishDate("4002");
        m4.setCumCasesByPublishDate("769642");
        m4.setNewDeaths28DaysByPublishDate("0");

        m5.setDate("2021-12-11");
        m5.setAreaName(area.getNation().getName());
        m5.setAreaCode(area.getAreaCode());
        m5.setNewCasesByPublishDate("4087");
        m5.setCumCasesByPublishDate("765889");
        m5.setNewDeaths28DaysByPublishDate("12");

        List<MetricsData> mockResponse = new ArrayList<>();
        mockResponse.add(m1);
        mockResponse.add(m2);
        mockResponse.add(m3);
        mockResponse.add(m4);
        mockResponse.add(m5);

        return mockResponse;
    }
}
