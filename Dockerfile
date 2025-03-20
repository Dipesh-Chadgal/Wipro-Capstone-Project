FROM openjdk:21-jdk-slim
EXPOSE 8080
ADD target/wipro-capstone.jar wipro-capstone.jar	
CMD ["java","-jar","wipro-capstone.jar"]

