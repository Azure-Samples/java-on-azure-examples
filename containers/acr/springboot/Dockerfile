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
RUN groupadd -r springboot && \
    useradd -r -g springboot springboot

#
# Create springboot directory
#
RUN mkdir -p /opt/springboot

#
# Expose port 8080.
#
EXPOSE 8080

#
# Copy the JAR file.
#
COPY target/acr-springboot.jar /opt/springboot/acr-springboot.jar

#
# Set file ownership
#
RUN chown -R springboot /opt/springboot

#
# Change user
#
USER springboot

#
# Startup command.
#
CMD ["java", "-jar", "/opt/springboot/acr-springboot.jar"]
