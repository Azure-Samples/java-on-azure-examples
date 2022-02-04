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
# Install bsdtar and unzip.
#
RUN apt-get update && \
    apt-get install -y curl

#
# Install WildFly.
#
RUN export WILDFLY_VERSION=18.0.1.Final && \
    mkdir -p /opt/jboss && \
    cd /opt/jboss && \
    curl -O https://download.jboss.org/wildfly/$WILDFLY_VERSION/wildfly-$WILDFLY_VERSION.tar.gz && \
    tar xf wildfly-$WILDFLY_VERSION.tar.gz && \
    mv wildfly-$WILDFLY_VERSION /opt/jboss/wildfly && \
    rm wildfly-$WILDFLY_VERSION.tar.gz

#
# Expose port 8080.
#
EXPOSE 8080

#
# Copy the WAR file.
#
COPY target/ROOT.war /opt/jboss/wildfly/standalone/deployments/ROOT.war

#
# Needed for graceful termination.
#
ENV LAUNCH_JBOSS_IN_BACKGROUND true

#
# Startup command.
#
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0"]
