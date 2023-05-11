FROM amazoncorretto:17-alpine-jdk

COPY target/argprogram-0.0.1-SNAPSHOT.jar argprogram.jar

ENTRYPOINT ["java","-jar","/argprogram.jar"]
