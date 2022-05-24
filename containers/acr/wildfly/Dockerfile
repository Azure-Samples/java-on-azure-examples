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
# Create wildfly user
#
RUN groupadd -r wildfly && \
    useradd -r -g wildfly wildfly

#
# Install WildFly.
#
RUN export WILDFLY_VERSION=18.0.1.Final && \
    cd /opt && \
    curl -O https://download.jboss.org/wildfly/$WILDFLY_VERSION/wildfly-$WILDFLY_VERSION.tar.gz && \
    tar xf wildfly-$WILDFLY_VERSION.tar.gz && \
    mv wildfly-$WILDFLY_VERSION /opt/wildfly && \
    rm wildfly-$WILDFLY_VERSION.tar.gz && \
    chown -R wildfly /opt/wildfly

#
# Expose port 8080.
#
EXPOSE 8080

#
# Copy the WAR file.
#
COPY target/ROOT.war /opt/wildfly/standalone/deployments/ROOT.war
RUN chown wildfly /opt/wildfly/standalone/deployments/ROOT.war

#
# Change user
#
USER wildfly

#
# Needed for graceful termination.
#
ENV LAUNCH_JBOSS_IN_BACKGROUND true

#
# Startup command.
#
CMD ["/opt/wildfly/bin/standalone.sh", "-b", "0.0.0.0"]
