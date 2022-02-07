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
RUN export JETTY_VERSION=9.4.31.v20200723 && \
    mkdir -p /opt && \
    cd /opt && \
    curl -O https://repo1.maven.org/maven2/org/eclipse/jetty/jetty-distribution/${JETTY_VERSION}/jetty-distribution-${JETTY_VERSION}.tar.gz && \
    tar xfv jetty-distribution-${JETTY_VERSION}.tar.gz && \
    mv /opt/jetty-distribution-${JETTY_VERSION} /opt/jetty && \
    rm jetty-distribution-${JETTY_VERSION}.tar.gz

#
# Expose port 8080.
#
EXPOSE 8080

#
# Copy the WAR file.
#
COPY target/ROOT.war /opt/jetty/webapps/ROOT.war

#
# Startup command.
#
CMD ["/opt/jetty/bin/jetty.sh", "run"]
