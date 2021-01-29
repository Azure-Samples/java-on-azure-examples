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
    yum clean all && \
    mkdir -p /opt/quarkus/lib

#
# Expose port 8080.
#
EXPOSE 8080

#
# Copy the JAR file.
#
COPY target/acr-quarkus-runner.jar /opt/quarkus/acr-quarkus.jar

#
# Copy the lib directory
#
COPY target/lib/* /opt/quarkus/lib/

#
# Startup command.
#
CMD ["java", "-jar", "/opt/quarkus/acr-quarkus.jar"]
