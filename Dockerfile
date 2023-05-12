FROM amazoncorretto:17-alpine-jdk

COPY target/argprogram-0.0.1-SNAPSHOT.jar argprogram.jar

<<<<<<< HEAD
EXPOSE 8082
=======
EXPOSE 8081
>>>>>>> 4b2aa0e8663290988052b720cde20aa75e2e3cd2

ENTRYPOINT ["java","-jar","/argprogram.jar"]
