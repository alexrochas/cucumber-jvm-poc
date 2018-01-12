# Cucumber JVM POC
> POC to show 3 different ways to integration test API's

This POC contains 4 API's.

## Canned

A simple canned project to serve static responses.

## Wiremock

A wiremock to intercept and respond programaticly.

## External project

Another project with real endpoints.

## Main project

Project that has all the cucumber features and steps.

## How-to-run

You can allways start the docker containers one-by-one but the main project *docker-compose.yml*
extends all the other projects and run a gradle task called "cucumber" to run the tests.
