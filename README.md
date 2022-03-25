# WORK IN PROGRESS


# Covid Stats Lib
A library that fetches the latest Covid-19 stats from a source (currently only the NHS UK API).

## Build Status 
![Build status](https://github.com/Lmnoppy/covid-stats/actions/workflows/main-build.yml/badge.svg?branch=main) ![Latest release branch status](https://github.com/Lmnoppy/covid-stats/actions/workflows/release-build-publish.yml/badge.svg?branch=release/v1)   ![Last security scan status](https://github.com/Lmnoppy/covid-stats/actions/workflows/codeql-analysis.yml/badge.svg?branch=main) [![Total alerts](https://img.shields.io/lgtm/alerts/g/Lmnoppy/covid-stats.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/Lmnoppy/covid-stats/alerts/)

## TODO:
* Add LTLA, UTLA and NHSREGION to the NHSCovidEndpoint
* Add additional sources for more regions such as EMEA, APAC, NA
* Add integration testing (Cucumber)
* Add validations
* ~~Add Github build and scan actions~~
* ~~Add Github deployment action to Github Packages~~

## Requirements
Covid-Stats uses the following plugins and tools

### Java
* Java 11 - https://www.microsoft.com/openjdk

## API details

#### fetchNHSCovidStatsFor
Currently, supports getting COVID-19 stats for a given nation in the UK from the NHS API. Support for Region and NHS Region will
be added at a later date.
nhsFetchCovidStatsFor(Area area, AreaType areaType, List<Metrics> metrics)

#### fetchAllSupportedNationDataForScotland
Uses the fetchNHSCovidStatsFor API to get all supported metrics and all dates for Scotland

#### fetchAllSupportedNationDataForEngland
Uses the fetchNHSCovidStatsFor API to get all supported metrics and all dates for England

#### fetchAllSupportedNationDataForNorthernIreland
Uses the fetchNHSCovidStatsFor API to get all supported metrics and all dates NorthernIreland

#### fetchAllSupportedNationDataForWales
Uses the fetchNHSCovidStatsFor API to get all supported metrics and all dates for Wales

## Resources
The following links are the guides I used to make this project.

### Guides
TODO: describe the data model

#### NHS API
https://coronavirus.data.gov.uk/ 
