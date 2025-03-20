FROM openjdk:21-jdk-slim
EXPOSE 8080
ADD target/spring-docker-demo.jar spring-docker-demo.jar
CMD ["java","-jar","spring-docker-demo.jar"]