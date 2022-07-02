Feature: Request Covid 19 stats from the NHS API service

  Background:
    Given The ICovid interface is setUp

    Scenario: When the method fetchNHSCovidStatsFor is called in ICovid interface it should return the requested metrics data for the given area.
      Given fetchNHSCovidStatsFor is called with
      #areaType #area     #metrics
      |NATION   |SCOTLAND|DATE,AREA_NAME,NEW_CASES_BY_PUBLISH_DATE,CUM_CASES_BY_PUBLISH_DATE,CUM_DEATHS_BY_PUBLISH_DATE,CUM_ANTIBODY_TESTS_BY_PUBLISH_DATE|
      #Works for all, but dont want to spam their endpoints for my integration testing.
      #|NATION   |ENGLAND|DATE,AREA_NAME,NEW_CASES_BY_PUBLISH_DATE,CUM_CASES_BY_PUBLISH_DATE,CUM_DEATHS_BY_PUBLISH_DATE,CUM_ANTIBODY_TESTS_BY_PUBLISH_DATE|
      #|NATION   |WALES|DATE,AREA_NAME,NEW_CASES_BY_PUBLISH_DATE,CUM_CASES_BY_PUBLISH_DATE,CUM_DEATHS_BY_PUBLISH_DATE,CUM_ANTIBODY_TESTS_BY_PUBLISH_DATE|
      #|NATION   |NORTHERN_IRELAND|DATE,AREA_NAME,NEW_CASES_BY_PUBLISH_DATE,CUM_CASES_BY_PUBLISH_DATE,CUM_DEATHS_BY_PUBLISH_DATE,CUM_ANTIBODY_TESTS_BY_PUBLISH_DATE|

  #TODO: Can make these into one Scenario that takes in the correct method.

  Scenario: When the method fetchAllSupportedNationDataForScotland is called in ICovid interface it should return all active metrics data for Scotland.
    Given fetchAllSupportedNationDataForScotland is called

  Scenario: When the method fetchAllSupportedNationDataForEngland is called in ICovid interface it should return all active metrics data for Scotland.
    Given fetchAllSupportedNationDataForEngland is called

  Scenario: When the method fetchAllSupportedNationDataForWales is called in ICovid interface it should return all active metrics data for Scotland.
    Given fetchAllSupportedNationDataForWales is called

  Scenario: When the method fetchAllSupportedNationDataForNorthernIreland is called in ICovid interface it should return all active metrics data for Scotland.
    Given fetchAllSupportedNationDataForNorthernIreland is called