package com.lmnoppy.api.covid.model.enums;

import lombok.Getter;

@Getter
public enum Metrics {

    DATE("date", null),
    AREA_NAME("areaName", null),
    AREA_CODE("areaCode", null),
    NEW_CASES_BY_PUBLISH_DATE("newCasesByPublishDate", null),
    CUM_CASES_BY_PUBLISH_DATE("cumCasesByPublishDate", "Cumulative cases by publish date"),
    CUM_CASES_BY_PUBLISH_DATE_RATE("cumCasesByPublishDateRate", "Cumulative cases by publish date rate"),
    NEW_DEATHS_28_DAYS_BY_PUBLISH_DATE("newDeaths28DaysByPublishDate", null),
    CUM_DEATHS_28_DAYS_BY_PUBLISH_DATE("cumDeaths28DaysByPublishDate", null),
    COVID_OCCUPIED_MV_BEDS("covidOccupiedMVBeds", "COVID occupied mechanical ventilator beds"),
    CUM_ADMISSIONS("cumAdmissions", "Cumulative admissions"),
    CUM_ADMISSIONS_BY_AGE("cumAdmissionsByAge", "Cumulative admissions by age"),
    CUM_ANTIBODY_TESTS_BY_PUBLISH_DATE("cumAntibodyTestsByPublishDate", "Cumulative antibody tests by publish date"),
    cumCasesLFDConfirmedPCRBySpecimenDate("cumCasesLFDConfirmedPCRBySpecimenDate", "Cumulative cases LFD confirmed by PCR by specimen date"),
    cumCasesLFDOnlyBySpecimenDate("cumCasesLFDOnlyBySpecimenDate", "Cumulative cases LFD-only by specimen date"),
    cumCasesPCROnlyBySpecimenDate("cumCasesPCROnlyBySpecimenDate", "Cumulative cases PCR only by specimen date"),
    cumDailyNsoDeathsByDeathDate("cumDailyNsoDeathsByDeathDate", "Cumulative daily national statistics office deaths by death date"),
    cumDeaths28DaysByDeathDate("cumDeaths28DaysByDeathDate", "Cumulative deaths within 28 days of a positive test by death date"),
    cumDeaths28DaysByDeathDateRate("cumDeaths28DaysByDeathDateRate", "Cumulative deaths within 28 days of a positive test rate by death date"),

    cumDeaths28DaysByPublishDate("", "Cumulative deaths within 28 days of a positive test by publish date"),

    cumDeaths28DaysByPublishDateRate("", "Cumulative deaths within 28 days of a positive test rate by publish date"),

    cumDeaths60DaysByDeathDate("", "Cumulative deaths within 60 days of a positive test by death date"),

    cumDeaths60DaysByDeathDateRate("", "Cumulative deaths within 60 days of a positive test rate by death date"),

    cumDeaths60DaysByPublishDate("", "Cumulative deaths within 60 days of a positive test by publish date"),

    cumDeaths60DaysByPublishDateRate("", "Cumulative deaths within 60 days of a positive test rate by publish date"),

    cumDeathsByDeathDate("", "Cumulative deaths by death date"),

    cumDeathsByDeathDateRate("", "Cumulative deaths by death date rate"),

    cumDeathsByPublishDate("", "Cumulative deaths by publish date"),

    cumDeathsByPublishDateRate("", "Cumulative deaths by publish date rate"),

    cumFirstEpisodesBySpecimenDate("", "Cumulative first infection episodes by specimen date"),

    cumFirstEpisodesBySpecimenDateRate("", "Cumulative first infection episodes rate by specimen date"),

    cumLFDTestsBySpecimenDate("", "Cumulative LFD tests"),

    cumOnsDeathsByRegistrationDate("", "Cumulative Office for National Statistics deaths by registration date"),

    cumOnsDeathsByRegistrationDateRate("", "Cumulative ONS deaths by registration date rate"),

    cumPCRTestsByPublishDate("", "Cumulative PCR tests by publish date"),

    cumPCRTestsBySpecimenDate("", "Total PCR tests by specimen date"),

    cumPeopleVaccinatedBoosterDoseByPublishDate("", "Cumulative people vaccinated booster dose by publish date"),

    cumPeopleVaccinatedCompleteByPublishDate("", "Cumulative people vaccinated complete by publish date"),

    cumPeopleVaccinatedCompleteByVaccinationDate("", "Cumulative people fully vaccinated by vaccination date"),

    cumPeopleVaccinatedFirstDoseByPublishDate("", "Cumulative people vaccinated 1st dose by publish date"),

    cumPeopleVaccinatedFirstDoseByVaccinationDate("", "Cumulative people vaccinated 1st dose by vaccination date"),

    cumPeopleVaccinatedSecondDoseByPublishDate("", "Cumulative people vaccinated 2nd dose by publish date"),

    cumPeopleVaccinatedSecondDoseByVaccinationDate("", "Cumulative people vaccinated 2nd dose by vaccination date"),

    cumPeopleVaccinatedThirdDoseByPublishDate("", "Cumulative people vaccinated 3rd dose by publish date"),

    cumPeopleVaccinatedThirdInjectionByPublishDate("", "Cumulative people vaccinated with a booster dose plus new people vaccinated with a third dose by publish date"),

    cumPeopleVaccinatedThirdInjectionByVaccinationDate("", "Cumulative people vaccinated booster or third dose by vaccination date"),

    cumPillarFourTestsByPublishDate("", "Cumulative pillar 4 tests by publish date"),

    cumPillarOneTestsByPublishDate("", "Cumulative pillar 1 tests by publish date"),

    cumPillarOneTwoTestsByPublishDate("", "Cumulative pillars 1 and 2 tests by publish date"),

    cumPillarThreeTestsByPublishDate("", "Cumulative pillar 3 tests by publish date"),

    cumPillarTwoTestsByPublishDate("", "Cumulative pillar 2 tests by publish date"),

    cumReinfectionsBySpecimenDate("", "Cumulative reinfections by specimen date"),

    cumReinfectionsBySpecimenDateRate("", "Cumulative reinfections rate by specimen date"),

    cumTestsByPublishDate("", "Cumulative tests by publish date"),

    cumVaccinationBoosterDoseUptakeByPublishDatePercentage("", "Cumulative percentage of people vaccinated with a booster dose by publish date"),

    cumVaccinationCompleteCoverageByPublishDatePercentage("", "Cumulative vaccination complete coverage by publish date percentage"),

    cumVaccinationCompleteCoverageByVaccinationDatePercentage("", "Cumulative percentage of people fully vaccinated by vaccination date"),

    cumVaccinationFirstDoseUptakeByPublishDatePercentage("", "Cumulative vaccination 1st dose uptake by publish date percentage"),

    cumVaccinationFirstDoseUptakeByVaccinationDatePercentage("", "Cumulative percentage of people vaccinated with a first dose by vaccination date"),

    cumVaccinationSecondDoseUptakeByPublishDatePercentage("", "Cumulative vaccination 2nd dose uptake by publish date percentage"),

    cumVaccinationSecondDoseUptakeByVaccinationDatePercentage("", "Cumulative percentage of second dose vaccination uptake by vaccination date"),

    cumVaccinationThirdInjectionUptakeByPublishDatePercentage("", "Cumulative percentage of people vaccinated with a booster dose plus people vaccinated with third dose by publish date"),

    cumVaccinationThirdInjectionUptakeByVaccinationDatePercentage("", "Cumulative percentage of people vaccinated with a booster or third dose by vaccination date"),

    cumVaccinesGivenByPublishDate("", "Cumulative vaccines given by publish date"),

    cumVirusTestsByPublishDate("", "Cumulative virus tests"),

    cumVirusTestsBySpecimenDate("", "Total virus tests by specimen date"),

    cumWeeklyNsoDeathsByRegDate("", "Cumulative weekly national statistics office deaths by registration date"),

    cumWeeklyNsoDeathsByRegDateRate("","Cumulative weekly national statistics office deaths by registration date rate"),

    femaleCases("","Female cases"),

    femaleDeaths28Days("","Female deaths within 28 days of a positive test"),

    hospitalCases("","Patients in hospital"),

    maleCases("","Male cases"),

    maleDeaths28Days("","Male deaths within 28 days of a positive test"),

    newAdmissions("","New admissions"),

    newAdmissionsChange("","New admissions change"),

    newAdmissionsChangePercentage("","New admissions change percentage"),

    newAdmissionsDirection("","New admissions direction"),

    newAdmissionsRollingRate("","New admissions rolling rate"),

    newAdmissionsRollingSum("","New admissions rolling sum"),

    newAntibodyTestsByPublishDate("","New antibody tests by publish date"),

    newCasesByPublishDate("","New cases by publish date"),

    newCasesByPublishDateChange("","New cases by publish date change"),

    newCasesByPublishDateChangePercentage("","New cases percentage change by publish date"),

    newCasesByPublishDateDirection("","New cases by publish date direction"),

    newCasesByPublishDateRollingSum("","New cases by publish date rolling sum"),

    newCasesBySpecimenDate("","New cases by specimen date"),

    newCasesBySpecimenDateAgeDemographics("","New cases by specimen date age demographics"),

    newCasesBySpecimenDateChange("","New cases by specimen date change"),

    newCasesBySpecimenDateChangePercentage("","New cases percentage change by specimen date"),

    newCasesBySpecimenDateDirection("","New cases by specimen date direction"),

    newCasesBySpecimenDateRollingRate("","New cases rolling rate by specimen date"),

    newCasesBySpecimenDateRollingSum("","New cases by specimen date rolling sum"),

    newCasesLFDConfirmedPCRBySpecimenDate("","New cases LFD confirmed by PCR by specimen date"),

    newCasesLFDConfirmedPCRBySpecimenDateRollingRate("","New cases LFD confirmed by PCR rolling rate by specimen date"),

    newCasesLFDConfirmedPCRBySpecimenDateRollingSum("","New cases LFD confirmed by PCR rolling sum by specimen date"),

    newCasesLFDOnlyBySpecimenDate("","New cases LFD only by specimen date"),

    newCasesLFDOnlyBySpecimenDateRollingRate("","New cases LFD only rolling rate by specimen date"),

    newCasesLFDOnlyBySpecimenDateRollingSum("","New cases LFD only rolling sum by specimen date"),

    newCasesPCROnlyBySpecimenDate("","New cases PCR only by specimen date"),

    newCasesPCROnlyBySpecimenDateRollingRate("","New cases PCR only by specimen date rolling rate"),

    newCasesPCROnlyBySpecimenDateRollingSum("","New cases PCR only by specimen date rolling sum"),

    newDailyNsoDeathsByDeathDate("","New daily national statistics office deaths by death date"),

    newDeaths28DaysByDeathDate("","New deaths within 28 days of a positive test by death date"),

    newDeaths28DaysByDeathDateAgeDemographics("","New deaths 28 days by death date age demographics"),

    newDeaths28DaysByDeathDateChangePercentage("","New deaths within 28 days of a positive test change percentage by death date"),

    newDeaths28DaysByDeathDateDirection("","New deaths within 28 days of a positive test direction by death date"),

    newDeaths28DaysByDeathDateRate("","New deaths within 28 days of a positive test rate by death date"),

    newDeaths28DaysByDeathDateRollingRate("","New deaths within 28 days of a positive test rolling rate by death date"),

    newDeaths28DaysByDeathDateRollingSum("","New deaths within 28 days of a positive test rolling sum test by death date"),

    newDeaths28DaysByPublishDate("","New deaths 28 days of a positive test by publish date"),

    newDeaths28DaysByPublishDateChange("","New deaths within 28 days of a positive test by publish date change"),

    newDeaths28DaysByPublishDateChangePercentage("","New deaths within 28 days of a positive test change percentage by publish date"),

    newDeaths28DaysByPublishDateDirection("","New deaths within 28 days of a positive test direction by publish date"),

    newDeaths28DaysByPublishDateRollingSum("","New deaths within 28 days of a positive test rolling sum by publish date"),

    newDeaths60DaysByDeathDate("","New deaths within 60 days of a positive test by death date"),

    newDeaths60DaysByDeathDateRate("","New deaths within 60 days of a positive test rate by death date"),

    newDeaths60DaysByDeathDateRollingRate("","New deaths within 60 days of a positive test rolling rate by death date"),

    newDeaths60DaysByDeathDateRollingSum("","New deaths within 60 days of a positive test rolling sum by death date"),

    newDeaths60DaysByPublishDate("","New deaths within 60 days of a positive test by publish date"),

    newDeathsByDeathDate("","New deaths by death date"),

    newDeathsByDeathDateRate("","New deaths by death date rate"),

    newDeathsByDeathDateRollingRate("","New deaths by death date rolling rate"),

    newDeathsByDeathDateRollingSum("","New deaths by death date rolling sum"),

    newDeathsByPublishDate("","New deaths by publish date"),

    newFirstEpisodesBySpecimenDate("","New first episodes by specimen date"),

    newFirstEpisodesBySpecimenDateChange("","New first episodes by specimen date change"),

    newFirstEpisodesBySpecimenDateChangePercentage("","New first episodes change percentage by specimen date"),

    newFirstEpisodesBySpecimenDateDirection("","New first episodes direction by specimen date"),

    newFirstEpisodesBySpecimenDateRollingRate("","New first episodes rolling rate by specimen date"),

    newFirstEpisodesBySpecimenDateRollingSum("","New first infection episodes rolling sum by specimen date"),

    newLFDTestsBySpecimenDate("","New LFD tests"),

    newOnsDeathsByRegistrationDate("","New Office for National Statistics deaths by registration date"),

    newPCRTestsByPublishDate("","New PCR tests by publish date"),

    newPCRTestsByPublishDateChange("","New PCR tests by publish date change"),

    newPCRTestsByPublishDateChangePercentage("","New PCR tests by publish date change percentage"),

    newPCRTestsByPublishDateDirection("","New PCR tests by publish date direction"),

    newPCRTestsByPublishDateRollingSum("","New PCR tests by publish date rolling sum"),

    newPCRTestsBySpecimenDate("","New PCR tests by specimen date"),

    newPeopleReceivingFirstDose("","New people receiving 1st dose"),

    newPeopleReceivingSecondDose("","New people receiving 2nd dose"),

    newPeopleVaccinatedBoosterDoseByPublishDate("","New people vaccinated with a booster dose by publish date"),

    newPeopleVaccinatedCompleteByPublishDate("","New people vaccinated complete by publish date"),

    newPeopleVaccinatedCompleteByVaccinationDate("","New people fully vaccinated by vaccination date"),

    newPeopleVaccinatedFirstDoseByPublishDate("","New people vaccinated 1st dose by publish date"),

    newPeopleVaccinatedFirstDoseByVaccinationDate("","New people vaccinated with a first dose by vaccination date"),

    newPeopleVaccinatedSecondDoseByPublishDate("","New people vaccinated 2nd dose by publish date"),

    newPeopleVaccinatedSecondDoseByVaccinationDate("","New people vaccinated with a second dose by vaccination date"),

    newPeopleVaccinatedThirdDoseByPublishDate("","New people vaccinated with a third dose by publish date"),

    newPeopleVaccinatedThirdInjectionByPublishDate("","New people vaccinated with a booster dose plus new people vaccinated with a third dose by publish date"),

    newPeopleVaccinatedThirdInjectionByVaccinationDate("","New people vaccinated with a booster or third dose by vaccination date"),

    newPillarFourTestsByPublishDate("","New pillar 4 tests by publish date"),

    newPillarOneTestsByPublishDate("","New pillar 1 tests by publish date"),

    newPillarOneTwoTestsByPublishDate("","New pillars 1 and 2 tests by publish date"),

    newPillarThreeTestsByPublishDate("","New pillar 3 tests by publish date"),

    newPillarTwoTestsByPublishDate("","New pillar 2 tests by publish date"),

    newReinfectionsBySpecimenDate("","New reinfections by specimen date"),

    newReinfectionsBySpecimenDateChange("","New reinfections by specimen date change"),

    newReinfectionsBySpecimenDateChangePercentage("","New reinfections change percentage by specimen date"),

    newReinfectionsBySpecimenDateDirection("","New reinfections by specimen date direction"),

    newReinfectionsBySpecimenDateRollingRate("","New reinfections rolling rate by specimen date"),

    newReinfectionsBySpecimenDateRollingSum("","New reinfections rolling sum by specimen date"),

    newTestsByPublishDate("","New tests by publish date"),

    newVaccinesGivenByPublishDate("","New vaccines given by publish date"),

    newVirusTestsByPublishDate("","New virus tests"),

    newVirusTestsByPublishDateChange("","New virus tests by publish date change"),

    newVirusTestsByPublishDateChangePercentage("","New virus tests by publish date change percentage"),

    newVirusTestsByPublishDateDirection("","New virus tests by publish date direction"),

    newVirusTestsByPublishDateRollingSum("","New virus tests by publish date rolling sum"),

    newVirusTestsBySpecimenDate("","New virus tests by specimen date"),

    newVirusTestsChange("","New virus tests change"),

    newVirusTestsChangePercentage("","New virus tests change percentage"),

    newVirusTestsDirection("","New virus tests direction"),

    newVirusTestsRollingSum("","New virus tests rolling sum"),

    newWeeklyNsoDeathsByRegDate("","New weekly national statistics office deaths by registration date"),

    plannedAntibodyCapacityByPublishDate("","Planned antibody capacity by publish date"),

    plannedCapacityByPublishDate("","Planned capacity by publish date"),

    plannedPCRCapacityByPublishDate("","Planned PCR capacity by publish date"),

    previouslyReportedNewCasesBySpecimenDate("","Previously reported new cases by specimen date"),

    transmissionRateGrowthRateMax("","Maximum transmission growth rate"),

    transmissionRateGrowthRateMin("","Transmission rate growth rate min"),

    transmissionRateMax("","Maximum transmission rate (R)"),

    transmissionRateMin("","Minimum transmission rate (R)"),

    uniqueCasePositivityBySpecimenDateRollingSum("","Unique case positivity by specimen date rolling sum"),

    uniquePeopleTestedBySpecimenDateRollingSum("","Unique people tested by specimen date rolling sum"),

    vaccinationsAgeDemographics("","Vaccinations age demographics breakdown"),

    VaccineRegisterPopulationByVaccinationDate("","Vaccination register (NIMS) population by vaccination date"),

    weeklyPeopleVaccinatedFirstDoseByVaccinationDate("","Weekly people vaccinated 1st dose by vaccination date"),

    weeklyPeopleVaccinatedSecondDoseByVaccinationDate("","Weekly people vaccinated 2nd dose by vaccination date");

    private final String metricNameValue;
    private final String metricDescription;

    Metrics(String metricNameValue, String metricDescription) {
        this.metricNameValue = metricNameValue;
        this.metricDescription = metricDescription;
    }
}
