# -----------------------------------------------------------------------------
#
# Note this Dockerfile is an skeleton that you can use as a starting point for 
# your own Dockerfile. It is NOT intended to be used for production workloads.
#
# -----------------------------------------------------------------------------

FROM mcr.microsoft.com/openjdk/jdk:11-ubuntu
RUN groupadd -r dropwizard && \
    useradd -r -g dropwizard dropwizard
RUN mkdir -p /opt/dropwizard
EXPOSE 8080
COPY target/dropwizard.jar /opt/dropwizard/dropwizard.jar
RUN chown -R dropwizard /opt/dropwizard
USER dropwizard
CMD ["java", "-jar", "/opt/dropwizard/dropwizard.jar", "server"]
