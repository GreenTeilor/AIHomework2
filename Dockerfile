FROM maven:3.8.7-eclipse-temurin-19 AS compile
WORKDIR /src/
COPY ./ /src/
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-alpine
WORKDIR /app/
COPY --from=compile /src/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]