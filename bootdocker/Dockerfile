FROM openjdk:17-alpine
COPY domicilio-0.0.1-SNAPSHOT.jar /usr/src/bootdocker/domicilio-0.0.1-SNAPSHOT.jar
WORKDIR /usr/src/bootdocker
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "/usr/src/bootdocker/domicilio-0.0.1-SNAPSHOT.jar"]