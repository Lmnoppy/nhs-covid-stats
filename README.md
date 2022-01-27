# WORK IN PROGRESS
## Covid Stats endpoints
A library that fetches the latest Covid-19 stats from a source (currently only the NHS UK API).

### Build Status 
![Build status](https://github.com/Lmnoppy/covid-stats/actions/workflows/main-build.yml/badge.svg?branch=main) ![Latest release branch status](https://github.com/Lmnoppy/covid-stats/actions/workflows/release-build-publish.yml/badge.svg?branch=release/v1)   ![Last security scan status](https://github.com/Lmnoppy/covid-stats/actions/workflows/codeql-analysis.yml/badge.svg?branch=main)

### Library API

#### fetchNHSCovidStatsFor
Currently, supports getting COVID-19 stats for a given nation in the UK from the NHS API. Support for Region and NHS Region will 
be added at a later date. 
nhsFetchCovidStatsFor(Area area, AreaType areaType, List<Metrics> metrics)

### Resources

#### Versions

##### Java 11 
https://www.microsoft.com/openjdk 

#### Guides
