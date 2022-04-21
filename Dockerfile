FROM openjdk:11
MAINTAINER experto.com
VOLUME /tmp
EXPOSE 8080
ADD build/libs/springboot-book-store-0.0.1-SNAPSHOT.jar springboot-book-store-0.0.1-SNAPSHOT-plain.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/springboot-book-store-0.0.1-SNAPSHOT-plain.jar"]