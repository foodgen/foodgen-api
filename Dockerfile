FROM maven:3.9.8-sapmachine-17 AS build

WORKDIR /app

COPY . .

RUN mvn -Dmaven.test.skip=true package

FROM amazoncorretto:17-alpine-jdk

COPY --from=build /app/target/*.jar app.jar

EXPOSE  8080

ENTRYPOINT ["java", "-jar", "app.jar", "-Dspring.datasource.url=${db_url}", "-Dspring.datasource.password=${db_password}", "-Dspring.datasource.username=${db_username}", "-Dtoken.signing.key=${token_signing_key}"]