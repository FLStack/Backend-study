# 1. Java 17/21 버전에 맞게 베이스 이미지 선택 (본인 프로젝트 Java 버전)
FROM openjdk:21-jdk-slim

# 2. 작업 디렉토리 설정
WORKDIR /app

# 3. 빌드에 필요한 파일 복사
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src

# 4. gradlew 실행 권한 부여 및 빌드
RUN chmod +x ./gradlew
RUN ./gradlew build -x test

# 5. 실행할 JAR 파일 복사
RUN cp build/libs/*-SNAPSHOT.jar app.jar

# 6. 포트 설정 및 애플리케이션 실행
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]