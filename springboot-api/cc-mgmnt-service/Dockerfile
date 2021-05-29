FROM adoptopenjdk/openjdk11:alpine-jre
ADD target/ccms-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8083
ENTRYPOINT ["java","-jar","app.jar"]