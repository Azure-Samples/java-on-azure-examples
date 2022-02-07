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
# Install curl.
#
RUN apt-get update && \
    apt-get install -y curl unzip

#
# Install Glassfish
#
RUN export GLASSFISH_VERSION=6.2.3 && \
    cd /opt && \
    curl -L -o glassfish.zip https://www.eclipse.org/downloads/download.php?file=/ee4j/glassfish/glassfish-${GLASSFISH_VERSION}.zip && \
    unzip glassfish.zip && \
    rm glassfish.zip && \
    mv glassfish6 glassfish

#
# Expose port 8080.
#
EXPOSE 8080

#
# Copy the WAR file.
#
COPY target/ROOT.war /opt/glassfish/glassfish/domains/domain1/autodeploy/ROOT.war

#
# Startup command.
#
CMD ["/opt/glassfish/glassfish/bin/asadmin", "start-domain", "-v"]
