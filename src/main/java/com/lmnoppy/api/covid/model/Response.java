package com.lmnoppy.api.covid.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response implements Serializable {

    private static final long serialVersionUID = -1496910593772770020L;

    private String length;
    private String maxPageLimit;
    private String totalRecords;

    private List<MetricsData> data;
}
