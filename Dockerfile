# Stage 1: Build the application using Gradle
FROM gradle:7.5.1-jdk17 as build
WORKDIR /home/gradle/src
COPY --chown=gradle:gradle . /home/gradle/src
RUN ./gradlew clean build --no-daemon

# Stage 2: Setup the runtime environment
FROM openjdk:17-oracle
WORKDIR /app
COPY --from=build /home/gradle/src/build/libs/.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
