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
# Create dropwizard user
#
RUN groupadd -r dropwizard && \
    useradd -r -g dropwizard dropwizard

#
# Create dropwizard directory
#
RUN mkdir -p /opt/dropwizard

#
# Expose port 8080.
#
EXPOSE 8080

#
# Copy the JAR file.
#
COPY target/acr-dropwizard.jar /opt/dropwizard/acr-dropwizard.jar

#
# Set file ownership
#
RUN chown -R dropwizard /opt/dropwizard

#
# Change user
#
USER dropwizard

#
# Startup command.
#
CMD ["java", "-jar", "/opt/dropwizard/acr-dropwizard.jar", "server"]
