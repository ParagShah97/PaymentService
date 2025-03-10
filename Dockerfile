FROM openjdk:21

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} paymentservice.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "/paymentservice.jar"]

