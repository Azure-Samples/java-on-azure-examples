FROM adoptopenjdk:11
RUN mkdir /usr/local/example
COPY target/*.jar /usr/local/example/example.jar
CMD ["java", "-jar", "/usr/local/example/example.jar"]