FROM --platform=linux/amd64/v3 openjdk:17	
ARG JAR_FILE=./target/common-0.0.1-SNAPSHOT.jar 	
COPY ${JAR_FILE} common-0.0.1-SNAPSHOT.jar	
ENTRYPOINT ["java","-jar","/common-0.0.1-SNAPSHOT.jar"]