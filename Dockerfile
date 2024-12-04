
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY build/libs/chatQuery-0.0.1-SNAPSHOT.jar chat-query-service.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "chat-query-service.jar"]

ENV TZ=Asia/Seoul


