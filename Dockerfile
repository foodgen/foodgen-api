FROM maven:3.9.8-sapmachine-17 AS build

WORKDIR /app

COPY . .

RUN mvn -Dmaven.test.skip=true package

FROM amazoncorretto:17-alpine-jdk

COPY --from=build /app/target/*.jar app.jar

EXPOSE  8080

ENTRYPOINT ["sh", "-c", "spring_datasource_url=${db_url} spring_datasource_username=${db_username} spring_datasource_password=${db_password} token_signing_key=${token_signing_key} java -jar app.jar"]