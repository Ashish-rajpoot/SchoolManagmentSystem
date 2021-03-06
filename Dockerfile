FROM openjdk:8-jdk
COPY ./target/schoolmanagmentsystems-0.0.1-SNAPSHOT.jar SchoolManagmentSystems-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","schoolmanagmentsystems-0.0.1-SNAPSHOT.jar"]