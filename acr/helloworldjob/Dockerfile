# -----------------------------------------------------------------------------
#
# Note this Dockerfile is an skeleton that you can use as a starting point for 
# your own Dockerfile. It is NOT intended to be used for production workloads.
#
# -----------------------------------------------------------------------------

#
# Microsoft OpenJDK 11
#
FROM mcr.microsoft.com/openjdk/jdk:17-ubuntu

#
# Create quarkus user
#
RUN groupadd -r helloworldjob && \
    useradd -r -g helloworldjob helloworldjob

#
# Create helloworldjob directory
#
RUN mkdir -p /opt/helloworldjob

#
# Expose port 8080.
#
EXPOSE 8080

#
# Copy the JAR file.
#
COPY target/helloworldjob.jar /opt/helloworldjob/helloworldjob.jar

#
# Set file ownership
#
RUN chown -R helloworldjob /opt/helloworldjob

#
# Change user
#
USER helloworldjob

#
# Startup command.
#
CMD ["java", "-jar", "/opt/helloworldjob/helloworldjob.jar"]
