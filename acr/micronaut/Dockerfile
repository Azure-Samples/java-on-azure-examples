# -----------------------------------------------------------------------------
#
# Note this Dockerfile is an skeleton that you can use as a starting point for 
# your own Dockerfile. It is NOT intended to be used for production workloads.
#
# -----------------------------------------------------------------------------

FROM mcr.microsoft.com/openjdk/jdk:11-ubuntu
COPY target/acr-micronaut.jar /opt/micronaut/acr-micronaut.jar
RUN groupadd -r micronaut && \
    useradd -r -g micronaut micronaut && \
    mkdir -p /opt/micronaut && \
    chown -R micronaut /opt/micronaut
EXPOSE 8080
USER micronaut
CMD ["java", "-jar", "/opt/micronaut/acr-micronaut.jar"]
