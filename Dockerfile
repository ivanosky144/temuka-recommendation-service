FROM openjdk:17-jdk-slim

WORKDIR /app

COPY pom.xml ./
COPY src ./src

RUN apt-get update && apt-get install -y maven && mvn clean package -DskipTests

COPY target/recommendation-service.jar ./recommendation-service.jar

EXPOSE 8080

CMD ["java", "-jar", "./recommendation-service.jar"]
