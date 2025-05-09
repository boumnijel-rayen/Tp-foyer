FROM openjdk:8-jdk-alpine
EXPOSE 8089
ADD target/tp-foyer-0.0.1.jar tp-foyer-0.0.1.jar
ENTRYPOINT ["java","-jar","/tp-foyer-0.0.1.jar"]
