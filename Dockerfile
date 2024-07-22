FROM maven:3.9.8-sapmachine-17 AS build

WORKDIR /app

COPY . .

RUN mvn -Dmaven.test.skip=true package

FROM amazoncorretto:17-alpine-jdk

COPY --from=build /app/target/*.jar app.jar

EXPOSE  8080

ENTRYPOINT ["sh", "-c", "db_url=${db_url} db_username=${db_username} db_password=${db_password} token_signing_key=${token_signing_key} java -jar app.jar"]