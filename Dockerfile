FROM maven:latest
LABEL authors='Mehiis'

WORKDIR /app
COPY pom.xml /app
COPY . /app
RUN mvn package
CMD ["java", "-jar", "target/Calculator.jar"]