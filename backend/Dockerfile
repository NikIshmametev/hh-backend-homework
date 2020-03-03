FROM adoptopenjdk/openjdk11
COPY ./src/etc /etc
ADD target/backend-1.0-SNAPSHOT.jar .
ENTRYPOINT [ "java", "-DsettingsDir=/etc/hh-backend-homework", "-jar", "backend-1.0-SNAPSHOT.jar"]