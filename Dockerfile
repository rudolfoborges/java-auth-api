FROM java:8

EXPOSE 8080

WORKDIR /opt

ADD build/libs/java-auth-api-0.0.1.jar java-auth-api.jar

RUN sh -c 'touch /opt/java-auth-api.jar'

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/opt/java-auth-api.jar"]