## Use a base image with Gradle and Java
#FROM gradle:8.2.0-jdk17
#
## Set the working directory
#WORKDIR /app
#
## Clone the backend repository
#RUN git clone https://oauth2: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@github.com/daumtto53/aniDB_backend.git .
#
## Copy configuration files
#COPY application.properties /app/src/main/resources/application.properties
#COPY oauth2-aws-docker-remote.properties /app/src/main/resources/oauth2-aws-docker-remote.properties
#
## Build the project
#RUN gradle build --no-daemon -x test
#
## Run the application
#ENTRYPOINT ["java", "-jar", "/app/build/libs/aniDB_backend-0.0.1-SNAPSHOT.jar"]
#
## Expose the port
#EXPOSE 8080
#EXPOSE 3306
#



# ONLY ONE CONTAINER CONTAINING (FRONT + BACK)
# Use gradle:8.2.0-jdk17 as the base image
FROM gradle:8.2.0-jdk17

# Install curl
RUN apt-get update && apt-get install -y curl

# Add NodeSource repository for Node.js
RUN curl -fsSL https://deb.nodesource.com/setup_18.x | bash - && \
    apt-get install -y nodejs

# Set the working directory
WORKDIR /app

# Clone the backend repository
RUN git clone https://oauth2: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@github.com/daumtto53/aniDB_backend.git backend

# Clone the frontend repository
RUN git clone https://oauth2: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@github.com/daumtto53/aniDB_frontend.git frontend

# Build the backend
WORKDIR /app/backend
COPY application.properties src/main/resources/application.properties
COPY oauth2-aws-docker-remote.properties src/main/resources/oauth2-aws-docker-remote.properties
RUN gradle build --no-daemon -x test

# Build the frontend
WORKDIR /app/frontend/aniDB
COPY .env ./
RUN npm install
RUN npm run build

# Set up the runtime environment
WORKDIR /app

# Copy the built backend JAR
RUN cp backend/build/libs/aniDB_backend-0.0.1-SNAPSHOT.jar .

# Copy the built frontend files
RUN cp -r frontend/aniDB/dist ./frontend-dist

# Install a simple HTTP server for serving frontend files
RUN npm install -g http-server

# Expose ports
EXPOSE 8080 5173 3306

# Start both backend and frontend
#CMD ["sh", "-c", "java -jar aniDB_backend-0.0.1-SNAPSHOT.jar & http-server frontend-dist -p 5173 --cors"]
CMD ["sh", "-c", "java -jar aniDB_backend-0.0.1-SNAPSHOT.jar & npm --prefix './frontend/aniDB/' run dev -- --host"]

# Keep the container alive with an infinite loop