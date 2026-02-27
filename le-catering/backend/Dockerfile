# Étape de build
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY java/pom.xml .
RUN mvn dependency:go-offline
COPY java/src ./java
RUN mvn clean package -DskipTests

# Étape d'exécution
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]