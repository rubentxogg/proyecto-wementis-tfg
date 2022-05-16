FROM openjdk:19-jdk-alpine

LABEL maintainer="rubentxogg@hotmail.com"

RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

ARG JAR_FILE=./*.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]