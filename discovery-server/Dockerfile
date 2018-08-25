FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8761
ADD target/discovery-server-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]