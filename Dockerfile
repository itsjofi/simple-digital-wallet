FROM maven:3.9.9-eclipse-temurin-22

WORKDIR /app

COPY pom.xml ./
RUN mvn dependency:go-offline

COPY src ./src

# Expose port 8080 for the application and 5005 for debugging
EXPOSE 8080 5005

# Use ENTRYPOINT to set the base command
ENTRYPOINT ["mvn"]

# Default command (can be overridden in docker-compose.yml)
CMD ["spring-boot:run", "-Dspring-boot.run.jvmArguments=-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005"]