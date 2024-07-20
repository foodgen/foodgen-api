FROM ubuntu:latest AS build

RUN apt update && apt install -y openjdk-17-jdk maven

WORKDIR /app

COPY . .

RUN mvn -Dmaven.test.skip=true package

FROM amazoncorretto:17-alpine-jdk

COPY --from=build /app/target/*.jar app.jar

EXPOSE  8080

ENTRYPOINT ["java", "-jar", "app.jar", "-Ddb_url=${db_url}", "-Ddb_password=${db_password}", "-Ddb_username=${db_username}"]
