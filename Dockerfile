FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project files
COPY pom.xml ./
COPY src ./src

# Use Maven to build the JAR file
RUN apt-get update && apt-get install -y maven && \
    mvn clean package -DskipTests && \
    mv target/*.jar application.jar

# Set the entrypoint to run the application
ENTRYPOINT ["java", "-jar", "/app/application.jar"]