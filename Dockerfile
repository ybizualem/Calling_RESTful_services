# Stage 1: Build the application using Gradle
FROM openjdk:17-oracle AS builder
WORKDIR /app
COPY build/libs/consumingrest-0.01-SNAPSHOT.jar app.jar

# Stage 2: Setup the runtime environment

FROM openjdk:17-oracle
WORKDIR /app
COPY --from=build /home/gradle/src/build/libs/.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
