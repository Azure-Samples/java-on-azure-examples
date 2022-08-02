FROM ghcr.io/graalvm/graalvm-ce:ol8-java11-21.3.3

RUN microdnf update -y
RUN microdnf install wget -y
RUN wget https://downloads.apache.org/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz -P /tmp
RUN tar xf /tmp/apache-maven-3.6.3-bin.tar.gz -C /opt
RUN ln -s /opt/apache-maven-3.6.3 /opt/maven
RUN ln -s /opt/graalvm-ce-java11-21.3.3 /opt/graalvm
RUN gu install native-image

ENV JAVA_HOME=/opt/graalvm
ENV GRAALVM_HOME=/opt/graalvm
ENV M2_HOME=/opt/maven
ENV MAVEN_HOME=/opt/maven
ENV PATH=${M2_HOME}/bin:${PATH}
ENV PATH=${JAVA_HOME}/bin:${PATH}
ENV MAVEN_OPTS='-Xmx6g'
WORKDIR /mnt
