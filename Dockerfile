FROM nginx:latest AS build

RUN wget -O - https://apt.corretto.aws/corretto.key | gpg --dearmor -o /usr/share/keyrings/corretto-keyring.gpg && \
    echo "deb [signed-by=/usr/share/keyrings/corretto-keyring.gpg] https://apt.corretto.aws stable main" | tee /etc/apt/sources.list.d/corretto.list

RUN apt update && apt install -y java-17-amazon-corretto-jdk maven

WORKDIR /app

COPY . .

RUN mvn package -DskipTests

FROM amazoncorretto:17-alpine-jdk

COPY --from=build /app/target/*.jar app.jar

EXPOSE  8080

ENTRYPOINT ["java", "-jar", "app.jar", "-Ddb_url=${db_url}", "-Ddb_password=${db_password}", "-Ddb_username=${db_username}"]
