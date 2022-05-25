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
# Create tomcat user
#
RUN groupadd -r tomcat && \
    useradd -r -g tomcat tomcat

#
# Install Tomcat.
#
RUN export TOMCAT_VERSION=9.0.37 && \
    mkdir -p /opt && \
    cd /opt && \
    curl -O https://archive.apache.org/dist/tomcat/tomcat-9/v$TOMCAT_VERSION/bin/apache-tomcat-$TOMCAT_VERSION.tar.gz && \
    tar xf apache-tomcat-$TOMCAT_VERSION.tar.gz && \
    mv /opt/apache-tomcat-$TOMCAT_VERSION /opt/tomcat && \
    rm -rf /opt/tomcat/webapps/* && \
    rm apache-tomcat-$TOMCAT_VERSION.tar.gz && \
    chown -R tomcat /opt/tomcat

#
# Expose port 8080.
#
EXPOSE 8080

#
# Copy the WAR file.
#
COPY target/ROOT.war /opt/tomcat/webapps/ROOT.war
RUN chown tomcat /opt/tomcat/webapps/ROOT.war

#
# Change user
#
USER tomcat

#
# Startup command.
#
CMD ["/opt/tomcat/bin/catalina.sh", "run"]
