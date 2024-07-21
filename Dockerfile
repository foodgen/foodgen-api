FROM 3.9.8-sapmachine-17 AS build

WORKDIR /app

COPY pom.xml src /app/

RUN mvn -Dmaven.test.skip=true package

FROM amazoncorretto:17-alpine-jdk

COPY --from=build /app/target/*.jar app.jar

EXPOSE  8080

ENTRYPOINT ["java", "-jar", "app.jar", "-Ddb_url=${db_url}", "-Ddb_password=${db_password}", "-Ddb_username=${db_username}", "-Dtoken_signing_key=${token_signing_key}"]
