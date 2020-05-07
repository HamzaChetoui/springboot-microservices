FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/*.jar compute-0.0.1-SNAPSHOT.jar
EXPOSE 8008
ENTRYPOINT ["java","-jar","compute-0.0.1-SNAPSHOT.jar"]
