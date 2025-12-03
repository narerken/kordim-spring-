FROM eclipse-temurin:21-jdk
LABEL maintainer="Era"
COPY kordim.jar kordim-backend-spring-project.jar
ENTRYPOINT ["java", "-jar", "kordim-backend-spring-project.jar"]
