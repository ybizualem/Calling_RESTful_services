FROM openjdk:17-oracle
WORKDIR /app
EXPOSE 8080
COPY build/libs/ConsumingRest-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
