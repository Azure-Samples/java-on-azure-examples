# -----------------------------------------------------------------------------
#
# Note this Dockerfile is a skeleton that you can use as a starting point for 
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
# Install Payara
#
RUN export PAYARA_VERSION=5.2020.3 && \
    cd /opt && \
    curl -L -o payara.zip https://repo1.maven.org/maven2/fish/payara/distributions/payara/${PAYARA_VERSION}/payara-${PAYARA_VERSION}.zip && \
    unzip payara.zip && \
    rm payara.zip && \
    mv payara5 payara

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
