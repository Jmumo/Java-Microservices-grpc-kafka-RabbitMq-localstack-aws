# Stage 1: Build the application
FROM gradle:8.5-jdk17 AS builder

WORKDIR /app

# Copy build configuration files first (for better caching)
COPY gradle/wrapper gradle/wrapper
COPY gradlew build.gradle settings.gradle ./

# Download dependencies
RUN ./gradlew dependencies --no-daemon

# Copy source files
COPY src ./src

# Build the application
RUN ./gradlew clean build --no-daemon

# Stage 2: Run the application
FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

# Copy the built jar file
COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 9999

ENTRYPOINT ["java", "-jar", "app.jar"]