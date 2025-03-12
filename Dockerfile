# Step 1: Use an official OpenJDK image as a base image
FROM eclipse-temurin:17-jdk-alpine

# Step 2: Set the working directory inside the container
WORKDIR /app

# Step 3: Copy the built JAR file into the container
COPY target/demo-kafka-producer-app.jar /app/demo-kafka-producer-app.jar

# Step 4: Expose the application port (Spring Boot default is 8080)
EXPOSE 8080

# Step 5: Set the entrypoint command
ENTRYPOINT ["java", "-jar", "/app/demo-kafka-producer-app.jar"]
