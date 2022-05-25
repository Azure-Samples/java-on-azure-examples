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
# Create quarkus user
#
RUN groupadd -r quarkus && \
    useradd -r -g quarkus quarkus

#
# Create quarkus lib directory
#
RUN mkdir -p /opt/quarkus/lib

#
# Expose port 8080.
#
EXPOSE 8080

#
# Copy the JAR file.
#
COPY target/acr-quarkus-runner.jar /opt/quarkus/acr-quarkus.jar

#
# Copy the lib directory
#
COPY target/lib/* /opt/quarkus/lib/

#
# Set file ownership
#
RUN chown -R quarkus /opt/quarkus

#
# Change user
#
USER quarkus

#
# Startup command.
#
CMD ["java", "-jar", "/opt/quarkus/acr-quarkus.jar"]
