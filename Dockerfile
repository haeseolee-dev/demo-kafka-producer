# Step 1: Use an official OpenJDK image as a base image
FROM eclipse-temurin:17-jdk-alpine

# Step 2: Set the working directory inside the container
WORKDIR /app

# Step 3: Define the JAR file location (Fix for ARG issue)
ARG JAR_FILE=target/demo-kafka-producer.jar
ENV JAR_FILE=${JAR_FILE}

# Step 4: Copy the built JAR file into the container
COPY ${JAR_FILE} /app/demo-kafka-producer.jar

# Step 5: Expose the application port (Spring Boot default is 8080)
EXPOSE 8080

# Step 6: Start the application
CMD ["java", "-jar", "/app/demo-kafka-producer.jar"]
