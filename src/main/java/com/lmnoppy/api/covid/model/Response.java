package com.lmnoppy.api.covid.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response implements Serializable {

    @Serial
    private static final long serialVersionUID = -1496910593772770020L;

    //Example response
    //{"areaType":"nation","areaCode":"S92000003","areaName":"Scotland","date":"2021-12-01","newCasesByPublishDate":2796}
    //{"length":685,"maxPageLimit":2500,"totalRecords":685,"data":[{"newCasesByPublishDate":68868},{"newCasesByPublishDate":53093},{"newCasesByPublishDate":44931},{"newCasesByPublishDate":40713},{"newCasesByPublishDate":48540},{"newCasesByPublishDate":48908},{"newCasesByPublishDate":43550},{"newCasesByPublishDate":44019},{"newCasesByPublishDate":38866},{"newCasesByPublishDate":41525},{"newCasesByPublishDate":37396},{"newCasesByPublishDate":39949},{"newCasesByPublishDate":43888},{"newCasesByPublishDate":45880},{"newCasesByPublishDate":41519},{"newCasesByPublishDate":33590},{"newCasesByPublishDate":34906},{"newCasesByPublishDate":32136},{"newCasesByPublishDate":35798},{"newCasesByPublishDate":42272},{"newCasesByPublishDate":40382},{"newCasesByPublishDate":36511},{"newCasesByPublishDate":36550},{"newCasesByPublishDate":36478},{"newCasesByPublishDate":33513},{"newCasesByPublishDate":36339},{"newCasesByPublishDate":37006},{"newCasesByPublishDate":39315},{"newCasesByPublishDate":30638},{"newCasesByPublishDate":30853},{"newCasesByPubl

    private String length;
    private String maxPageLimit;
    private String totalRecords;
    private List<Metrics> data;

    private String areaType;
    private String areaCode;
    private String areaName;
    private LocalDate date;
    private int newCasesByPublishDate;
}
