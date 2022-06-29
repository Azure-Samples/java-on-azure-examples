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
# Create helidon user
#
RUN groupadd -r helidon && \
    useradd -r -g helidon helidon

#
# Create helidon libs directory
#
RUN mkdir -p /opt/helidon/libs

#
# Expose port 8080.
#
EXPOSE 8080

#
# Copy the JAR file.
#
COPY target/acr-helidon.jar /opt/helidon/acr-helidon.jar

#
# Copy the libs directory
#
COPY target/libs/* /opt/helidon/libs/

#
# Set file ownership
#
RUN chown -R helidon /opt/helidon

#
# Change user
#
USER helidon

#
# Startup command.
#
CMD ["java", "-jar", "/opt/helidon/acr-helidon.jar"]
