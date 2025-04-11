FROM openjdk:17-jdk

# Copy the jar file built by Maven
COPY target/demo.jar demo.jar

# Expose port (default 8080)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "demo.jar"]