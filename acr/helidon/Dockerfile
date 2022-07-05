# -----------------------------------------------------------------------------
#
# Note this Dockerfile is an skeleton that you can use as a starting point for 
# your own Dockerfile. It is NOT intended to be used for production workloads.
#
# -----------------------------------------------------------------------------

FROM mcr.microsoft.com/openjdk/jdk:11-ubuntu
COPY target/acr-helidon.jar /opt/helidon/acr-helidon.jar
COPY target/libs/* /opt/helidon/libs/
RUN groupadd -r helidon && \
    useradd -r -g helidon helidon && \
    mkdir -p /opt/helidon/libs && \
    chown -R helidon /opt/helidon
EXPOSE 8080
USER helidon
CMD ["java", "-jar", "/opt/helidon/acr-helidon.jar"]
