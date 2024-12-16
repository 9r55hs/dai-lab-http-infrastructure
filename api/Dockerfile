# dai-lab-http-infrastructure
# Step 3: HTTP API server
# Authors: Gabriel Barros Fernandez - Dylan Stegmuller
# Date: 16.12.2024

# Getting maven to build application
FROM maven:latest as builder

# Setting working directory
WORKDIR /api

# Copying pom.xml for build and source files
COPY pom.xml .
COPY src ./src

# Builing package with maven
RUN mvn clean package

# Getting openjdk21 to run app
FROM alpine:latest
RUN apk add --no-cache openjdk21

# Setting working directory
WORKDIR /api

# Copying built .jar
COPY --from=builder /api/target/api-1.0-jar-with-dependencies.jar api.jar

# Running .jar
CMD ["java", "-jar", "api.jar"]
