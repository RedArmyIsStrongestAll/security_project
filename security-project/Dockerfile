FROM openjdk:11-jdk-slim AS build
COPY . /src
WORKDIR /src
RUN chmod 777 -R /src && ./mvnw clean package -P profile-prod

FROM openjdk:11-jre-slim
RUN apt-get update && apt-get install -y docker.io
COPY --from=build /src/target/security-project-0.0.1-SNAPSHOT.jar /app/security-project.jar
COPY ./applications/prod.application.properties /app/application.properties
WORKDIR /app
RUN chmod 777 ./security-project.jar
CMD ["java", "-jar", "security-project.jar"]