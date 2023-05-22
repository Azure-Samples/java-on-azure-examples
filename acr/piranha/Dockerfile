# -----------------------------------------------------------------------------
#
# Note this Dockerfile is an skeleton that you can use as a starting point for 
# your own Dockerfile. It is NOT intended to be used for production workloads.
#
# -----------------------------------------------------------------------------

FROM mcr.microsoft.com/openjdk/jdk:17-ubuntu
COPY target/acr-piranha.war /opt/piranha/ROOT.war
RUN apt update -y && \
    apt-get -y install curl && \
    mkdir -p /opt/piranha && \
    cd /opt/piranha && \
    curl -O https://repo1.maven.org/maven2/cloud/piranha/dist/piranha-dist-webprofile/23.5.0/piranha-dist-webprofile-23.5.0.jar && \
    mv piranha-dist-webprofile-23.5.0.jar piranha-webprofile.jar && \
    groupadd -r piranha && \
    useradd -r -g piranha piranha && \
    chown -R piranha /opt/piranha
EXPOSE 8080
USER piranha
WORKDIR /opt/piranha
CMD ["java", "-jar", "piranha-webprofile.jar", "--war-file", "ROOT.war"]
