FROM openjdk:8-jdk
COPY ./target/SchoolManagmentSystems-0.0.1-SNAPSHOT.jar SchoolManagmentSystems-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","SchoolManagmentSystems-0.0.1-SNAPSHOT.jar"]