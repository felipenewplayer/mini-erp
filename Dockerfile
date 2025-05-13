# Etapa 1: build
FROM maven:3.9.4-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: imagem de produção
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/target/ERP-0.0.1-SNAPSHOT.jar app.jar

# Porta padrão do Spring Boot
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]

