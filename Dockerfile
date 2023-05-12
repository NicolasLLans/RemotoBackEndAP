FROM amazoncorretto:17-alpine-jdk

COPY target/argprogram-0.0.1-SNAPSHOT.jar argprogram.jar

EXPOSE 8082

ENTRYPOINT ["java","-jar","/argprogram.jar"]
