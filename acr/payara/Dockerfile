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
# Install bsdtar and unzip.
#
RUN apt-get update && \
    apt-get install -y curl unzip

#
# Install Payara
#
RUN export PAYARA_VERSION=6.2023.9 && \
    cd /opt && \
    curl -L -o payara.zip https://repo1.maven.org/maven2/fish/payara/distributions/payara/${PAYARA_VERSION}/payara-${PAYARA_VERSION}.zip && \
    unzip payara.zip && \
    rm payara.zip && \
    mv payara6 payara

#
# Expose port 8080.
#
EXPOSE 8080

#
# Copy the WAR file.
#
COPY target/ROOT.war /opt/payara/glassfish/domains/domain1/autodeploy/ROOT.war

#
# Startup command.
#
CMD ["/opt/payara/glassfish/bin/asadmin", "start-domain", "-v"]
