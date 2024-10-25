FROM openjdk:17-jdk-slim-buster
WORKDIR /app
COPY /target/dumplings-cloud-0.0.1-SNAPSHOT.jar /app/dumplings-cloud.jar
ENTRYPOINT ["java", "-jar", "dumplings-cloud.jar"]
