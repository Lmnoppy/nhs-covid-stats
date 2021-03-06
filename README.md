# WORK IN PROGRESS


# Covid Stats Lib
A library that fetches the latest Covid-19 stats from a source (currently only the NHS UK API).

## Build Status 
![Build status](https://github.com/Lmnoppy/nhs-covid-stats/actions/workflows/main-build.yml/badge.svg?branch=main) ![Latest release branch status](https://github.com/Lmnoppy/nhs-covid-stats/actions/workflows/release-build-publish.yml/badge.svg?branch=release/v1)   ![Last security scan status](https://github.com/Lmnoppy/nhs-covid-stats/actions/workflows/codeql-analysis.yml/badge.svg?branch=main) [![Total alerts](https://img.shields.io/lgtm/alerts/g/Lmnoppy/nhs-covid-stats.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/Lmnoppy/nhs-covid-stats/alerts/) [![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=Lmnoppy_nhs-covid-stats&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=Lmnoppy_nhs-covid-stats) [![Coverage](https://sonarcloud.io/api/project_badges/measure?project=Lmnoppy_nhs-covid-stats&metric=coverage)](https://sonarcloud.io/summary/new_code?id=Lmnoppy_nhs-covid-stats) [![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=Lmnoppy_nhs-covid-stats&metric=vulnerabilities)](https://sonarcloud.io/summary/new_code?id=Lmnoppy_nhs-covid-stats)

## TODO:
* Add LTLA, UTLA and NHSREGION to the NHSCovidEndpoint
* Add more validations

## Requirements
Covid-Stats uses the following plugins and tools

### Java
* Java 11 - https://www.microsoft.com/openjdk

## Datasources

#### NHS API
https://coronavirus.data.gov.uk/

## API details

### fetchNHSCovidStatsFor
Currently, supports getting COVID-19 stats for a given nation in the UK from the NHS API. Support for Region and NHS Region will
be added at a later date.
nhsFetchCovidStatsFor(Area area, AreaType areaType, List<Metrics> metrics)

### fetchAllSupportedNationDataForScotland
Uses the fetchNHSCovidStatsFor API to get all supported metrics and all dates for Scotland

### fetchAllSupportedNationDataForEngland
Uses the fetchNHSCovidStatsFor API to get all supported metrics and all dates for England

### fetchAllSupportedNationDataForNorthernIreland
Uses the fetchNHSCovidStatsFor API to get all supported metrics and all dates NorthernIreland

### fetchAllSupportedNationDataForWales
Uses the fetchNHSCovidStatsFor API to get all supported metrics and all dates for Wales

## Resources
The following links are the guides I used to make this project.

### Guides
TODO: describe the data model

