# -----------------------------------------------------------------------------
#
# Note this Dockerfile is an skeleton that you can use as a starting point for 
# your own Dockerfile. It is NOT intended to be used for production workloads.
#
# -----------------------------------------------------------------------------

#
# Zulu JDK
#
FROM mcr.microsoft.com/java/jdk:8u242-zulu-centos

#
# Install bsdtar and unzip.
#
RUN yum update -y && \
    yum -y install bsdtar unzip && \
    yum clean all

#
# Install Glassfish
#
RUN export GLASSFISH_VERSION=5.1.0 && \
    cd /opt && \
    curl -L -o glassfish.zip https://www.eclipse.org/downloads/download.php?file=/glassfish/glassfish-${GLASSFISH_VERSION}.zip\&r=1 && \
    unzip glassfish.zip && \
    rm glassfish.zip && \
    mv glassfish5 glassfish

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
