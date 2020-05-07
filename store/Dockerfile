FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/*.jar store-0.0.1-SNAPSHOT.jar
EXPOSE 8010
ENTRYPOINT ["java","-jar","store-0.0.1-SNAPSHOT.jar"]
