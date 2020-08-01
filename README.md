# Quarkus Sample App
This application is meant as a reproducer for bugs within the Quarkus releases.

## Verifying Released Versions of Quarkus
* In the [gradle.properties](gradle.properties) file, set the Quarkus version to the appropriate release value, e.g.,
 `1.4.1.Final`

## Verifying Locally Built Quarkus Binaries
* Ensure that you have built Quarkus locally - `mvn clean install`
* In the [gradle.properties](gradle.properties) file, set the Quarkus version to `999-SNAPSHOT`
* Execute the local gradle build `./gradlew --no-daemon clean build`. Running it with the `--no-daemon` flag will ensure
  that you are seeing the right value for someone using it for the first time.
