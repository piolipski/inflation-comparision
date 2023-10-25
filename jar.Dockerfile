FROM maven:3.9.2-amazoncorretto-20-debian-bullseye

WORKDIR /data
COPY src /data/src
COPY pom.xml /data/pom.xml
RUN [ "mvn", "install", "-Dmaven.test.skip", "-f", "pom.xml" ]
RUN [ "mvn", "package", "-Dmaven.test.skip", "-f", "pom.xml" ]
CMD [ "java", "-jar", "target/server-0.0.1-SNAPSHOT.jar" ]
