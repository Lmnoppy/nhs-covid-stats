package com.lmnoppy.api.covid.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MetricsData implements Serializable {

    private static final long serialVersionUID = 991286172506130502L;

    private String date;

    private String areaName;
    private String areaCode;

    private String newCasesByPublishDate;
    private String cumCasesByPublishDate;
    private String cumDeaths28DaysByPublishDate;
    private String newDeaths28DaysByPublishDate;
    private String cumDeaths28DaysByPublishDateRate;
    private String covidOccupiedMVBeds;
    private String cumAdmissions;
    private String cumCasesPCROnlyBySpecimenDate;
    private String cumDailyNsoDeathsByDeathDate;
    private String cumDeaths28DaysByDeathDate;
    private String cumDeaths28DaysByDeathDateRate;
    private String cumDeaths60DaysByDeathDate;
    private String cumDeaths60DaysByDeathDateRate;
    private String cumDeaths60DaysByPublishDate;
    private String cumDeaths60DaysByPublishDateRate;
    private String cumDeathsByDeathDate;
    private String cumDeathsByDeathDateRate;
    private String cumDeathsByPublishDate;
    private String cumDeathsByPublishDateRate;
    private String cumFirstEpisodesBySpecimenDate;
    private String cumFirstEpisodesBySpecimenDateRate;
    private String cumLFDTestsBySpecimenDate;
    private String cumOnsDeathsByRegistrationDate;
    private String cumOnsDeathsByRegistrationDateRate;
    private String cumPCRTestsByPublishDate;
    private String cumPCRTestsBySpecimenDate;
    private String cumPeopleVaccinatedBoosterDoseByPublishDate;
    private String cumPeopleVaccinatedCompleteByPublishDate;
    private String cumPeopleVaccinatedCompleteByVaccinationDate;
    private String cumPeopleVaccinatedFirstDoseByPublishDate;
    private String cumPeopleVaccinatedFirstDoseByVaccinationDate;
    private String cumPeopleVaccinatedSecondDoseByPublishDate;
    private String cumPeopleVaccinatedSecondDoseByVaccinationDate;
    private String cumPeopleVaccinatedThirdDoseByPublishDate;
    private String cumPeopleVaccinatedThirdInjectionByPublishDate;
    private String cumPeopleVaccinatedThirdInjectionByVaccinationDate;
    private String cumReinfectionsBySpecimenDate;
    private String cumReinfectionsBySpecimenDateRate;
    private String cumTestsByPublishDate;
    private String cumVaccinationBoosterDoseUptakeByPublishDatePercentage;
    private String cumVaccinationCompleteCoverageByPublishDatePercentage;
    private String cumVaccinationCompleteCoverageByVaccinationDatePercentage;
    private String cumVaccinationFirstDoseUptakeByPublishDatePercentage;
    private String cumVaccinationFirstDoseUptakeByVaccinationDatePercentage;
    private String cumVaccinationSecondDoseUptakeByPublishDatePercentage;
    private String cumVaccinationSecondDoseUptakeByVaccinationDatePercentage;
    private String cumVaccinationThirdInjectionUptakeByPublishDatePercentage;
    private String cumVaccinationThirdInjectionUptakeByVaccinationDatePercentage;
    private String cumVaccinesGivenByPublishDate;
    private String cumVirusTestsByPublishDate;
    private String cumVirusTestsBySpecimenDate;
    private String cumWeeklyNsoDeathsByRegDate;
    private String cumWeeklyNsoDeathsByRegDateRate;
    private String femaleCases;
    private String femaleDeaths28Days;
    private String hospitalCases;
    private String maleCases;
    private String maleDeaths28Days;
    private String newAdmissions;
    private String newAdmissionsChange;
}
