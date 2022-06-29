# -----------------------------------------------------------------------------
#
# Note this Dockerfile is an skeleton that you can use as a starting point for 
# your own Dockerfile. It is NOT intended to be used for production workloads.
#
# -----------------------------------------------------------------------------

#
# Microsoft OpenJDK 11
#
FROM mcr.microsoft.com/openjdk/jdk:11-ubuntu

#
# Create micronaut user
#
RUN groupadd -r micronaut && \
    useradd -r -g micronaut micronaut

#
# Create micronaut directory
#
RUN mkdir -p /opt/micronaut

#
# Expose port 8080.
#
EXPOSE 8080

#
# Copy the JAR file.
#
COPY target/acr-micronaut.jar /opt/micronaut/acr-micronaut.jar

#
# Set file ownership
#
RUN chown -R micronaut /opt/micronaut

#
# Change user
#
USER micronaut

#
# Startup command.
#
CMD ["java", "-jar", "/opt/micronaut/acr-micronaut.jar"]
