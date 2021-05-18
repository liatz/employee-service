FROM openjdk:16
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8000

ENTRYPOINT ["java","-jar","/app.jar"]


## select image
#FROM maven:3.5-jdk-8
#
## copy the project files
#COPY ./pom.xml ./pom.xml
#
## build all dependencies for offline use
#RUN mvn dependency:go-offline -B
#
## copy your other files
#COPY ./src ./src
#
## build for release
#RUN mvn package
#
## set the startup command to run your binary
#CMD ["java", "-jar", "./target/employee-service.jar"]
