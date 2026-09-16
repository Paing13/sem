FROM eclipse-temurin:25
COPY ./target/setMethods-0.1.0.2.jar /tmp/setMethods-0.1.0.2.jar
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "/tmp/setMethods-0.1.0.2.jar"]