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
# Install Tomcat.
#
RUN export TOMCAT_VERSION=9.0.37 && \
    mkdir -p /opt && \
    cd /opt && \
    curl -O https://archive.apache.org/dist/tomcat/tomcat-9/v$TOMCAT_VERSION/bin/apache-tomcat-$TOMCAT_VERSION.tar.gz && \
    tar xf apache-tomcat-$TOMCAT_VERSION.tar.gz && \
    mv /opt/apache-tomcat-$TOMCAT_VERSION /opt/tomcat && \
    rm -rf /opt/tomcat/webapps/* && \
    rm apache-tomcat-$TOMCAT_VERSION.tar.gz

#
# Expose port 8080.
#
EXPOSE 8080

#
# Copy the WAR file.
#
COPY target/ROOT.war /opt/tomcat/webapps/ROOT.war

#
# Startup command.
#
CMD ["/opt/tomcat/bin/catalina.sh", "run"]
