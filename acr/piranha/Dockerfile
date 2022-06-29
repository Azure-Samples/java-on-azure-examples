# -----------------------------------------------------------------------------
#
# Note this Dockerfile is an skeleton that you can use as a starting point for 
# your own Dockerfile. It is NOT intended to be used for production workloads.
#
# -----------------------------------------------------------------------------

# -----------------------------------------------------------------------------
#  Builder image
# -----------------------------------------------------------------------------
#  1. Use Microsoft OpenJDK 17 image
#  2. Get Maven 3.8.4
#  3. Copy the bits to build
#  4. Build the WAR file
#  5. Get the Piranha Micro runtime
#
FROM mcr.microsoft.com/openjdk/jdk:17-ubuntu AS builder
RUN apt update -y && \
    apt-get -y install curl
RUN cd /usr/local && \
    curl -O https://archive.apache.org/dist/maven/maven-3/3.8.4/binaries/apache-maven-3.8.4-bin.tar.gz && \
    tar xfvz apache-maven-3.8.4-bin.tar.gz && \
    rm apache-maven-3.8.4-bin.tar.gz
COPY . /root
RUN export PATH=$PATH:/usr/local/apache-maven-3.8.4/bin && \
    cd /root && \
    mvn --no-transfer-progress clean install
RUN mkdir -p /opt/piranha && \
    cd /opt/piranha && \
    curl -O https://repo1.maven.org/maven2/cloud/piranha/piranha-micro/22.4.0/piranha-micro-22.4.0.jar && \
    mv piranha-micro-22.4.0.jar piranha-micro.jar

# -----------------------------------------------------------------------------
#  Runtime image
# -----------------------------------------------------------------------------
#  1. Use Microsoft OpenJDK 17 image
#  2. Copy the WAR file
#  3. Copy the Piranha Micro runtime
#  4. Create the piranha user and set file ownership
#  5. Expose port 8080
#  6. Set user to piranha
#  7. Set work directory to /opt/piranha
#  8. Run Piranha Micro
#
FROM mcr.microsoft.com/openjdk/jdk:17-ubuntu
COPY --from=builder /root/target/acr-piranha.war /opt/piranha/ROOT.war
COPY --from=builder /opt/piranha/piranha-micro.jar /opt/piranha/piranha-micro.jar
RUN groupadd -r piranha && \
    useradd -r -g piranha piranha && \
    chown -R piranha /opt/piranha
EXPOSE 8080
USER piranha
WORKDIR /opt/piranha
CMD ["java", "-jar", "piranha-micro.jar", "--war-file", "ROOT.war"]
