FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/gabjustino_funcionario_at-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8042

ENTRYPOINT ["java", "-jar","app.jar"]


