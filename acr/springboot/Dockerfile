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
# Create the springboot user
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
COPY target/springboot.jar /opt/springboot/springboot.jar

#
# Set file ownership
#
RUN chown -R springboot /opt/springboot

#
# Change to springboot user
#
USER springboot

#
# Startup command.
#
CMD ["java", "-jar", "/opt/springboot/springboot.jar"]
