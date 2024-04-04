# -----------------------------------------------------------------------------
#
# Note this Dockerfile is an skeleton that you can use as a starting point for 
# your own Dockerfile. It is NOT intended to be used for production workloads.
#
# -----------------------------------------------------------------------------

#
# Microsoft OpenJDK 17
#
FROM mcr.microsoft.com/openjdk/jdk:17-ubuntu

#
# Create quarkus user
#
RUN groupadd -r quarkus && \
    useradd -r -g quarkus quarkus

#
# Create quarkus lib directory
#
RUN mkdir -p /opt/quarkus

#
# Expose port 8080.
#
EXPOSE 8080

#
# Copy the quarkus-app directory
#
COPY target/quarkus-app/ /opt/quarkus/

#
# Set file ownership
#
RUN chown -R quarkus /opt/quarkus

#
# Change user
#
USER quarkus

#
# Change work directory.
#
WORKDIR /opt/quarkus

#
# Startup command.
#
CMD ["java", "-jar", "/opt/quarkus/quarkus-run.jar"]
