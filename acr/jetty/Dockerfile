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
    apt-get install -y curl

#
# Install Jetty.
#
RUN export JETTY_VERSION=11.0.15 && \
    mkdir -p /opt/jetty && \
    cd /opt/jetty && \
    curl -O https://repo1.maven.org/maven2/org/eclipse/jetty/jetty-home/${JETTY_VERSION}/jetty-home-${JETTY_VERSION}.tar.gz && \
    tar xfv jetty-home-${JETTY_VERSION}.tar.gz && \
    mv /opt/jetty/jetty-home-${JETTY_VERSION} /opt/jetty/server && \
    rm jetty-home-${JETTY_VERSION}.tar.gz && \
    cd /opt/jetty/server && \
    java -jar start.jar jetty.base=/opt/jetty/base --add-module=server,http,deploy,jsp,jstl,ext,resources,websocket

#
# Set JETTY_BASE
#
ENV JETTY_BASE /opt/jetty/base

#
# Expose port 8080.
#
EXPOSE 8080

#
# Copy the WAR file.
#
COPY target/ROOT.war /opt/jetty/base/webapps/ROOT.war

#
# Work directory
#
WORKDIR /opt/jetty/base

#
# Startup command.
#
CMD ["java", "-jar", "/opt/jetty/server/start.jar"]
