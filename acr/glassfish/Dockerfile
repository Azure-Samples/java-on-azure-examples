# -----------------------------------------------------------------------------
#
# Note this Dockerfile is an skeleton that you can use as a starting point for 
# your own Dockerfile. It is NOT intended to be used for production workloads.
#
# -----------------------------------------------------------------------------

FROM mcr.microsoft.com/openjdk/jdk:11-ubuntu
RUN apt-get update && \
    apt-get install -y curl unzip
RUN export GLASSFISH_VERSION=7.0.11 && \
    cd /opt && \
    curl -L -o glassfish.zip https://www.eclipse.org/downloads/download.php?file=/ee4j/glassfish/glassfish-${GLASSFISH_VERSION}.zip && \
    unzip glassfish.zip && \
    rm glassfish.zip && \
    mv glassfish7 glassfish
EXPOSE 8080
COPY target/ROOT.war /opt/glassfish/glassfish/domains/domain1/autodeploy/ROOT.war
CMD ["/opt/glassfish/glassfish/bin/asadmin", "start-domain", "-v"]
