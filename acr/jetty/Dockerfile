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
    yum -y install bsdtar unzip which && \
    yum clean all

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
