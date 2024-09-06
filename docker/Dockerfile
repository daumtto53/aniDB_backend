# Use a base image with Gradle and Java
FROM gradle:8.2.0-jdk17

# Set the working directory
WORKDIR /app

# Clone the repository
RUN git clone https://oauth2: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@github.com/daumtto53/aniDB_backend.git .

# Copy configuration files
COPY application.properties /app/src/main/resources/application.properties
COPY oauth2-test_docker.properties /app/src/main/resources/oauth2-test_docker.properties

# Build the project
RUN gradle build --no-daemon -x test

# Run the application
ENTRYPOINT ["java", "-jar", "/app/build/libs/aniDB_backend-0.0.1-SNAPSHOT.jar"]

# Expose the port
EXPOSE 8080
EXPOSE 3306