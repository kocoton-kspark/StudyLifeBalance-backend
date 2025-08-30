# 📚 StudyLifeBalance API Server

> 대학생의 학습-생활 균형을 분석하고 추천하는 설문조사 API 서버

## 🎯 프로젝트 개요

이 프로젝트는 대학생들의 학습 시간, 생활 패턴, 외부 활동 등을 분석하여 개인 맞춤형 추천을 제공하는 Spring Boot 기반 REST API 서버입니다.

## 🛠️ 기술 스택

- **Backend**: Spring Boot 3.1.0, Java 17
- **Database**: MySQL 8.0
- **ORM**: Spring Data JPA, Hibernate
- **Build Tool**: Gradle
- **API**: REST API

## 📁 프로젝트 구조

```
src/main/java/com/example/demo/
├── controller/          # REST API 컨트롤러
│   ├── QuoteController.java
│   └── SurveyController.java
├── service/            # 비즈니스 로직
│   ├── QuoteService.java
│   └── SurveyService.java
├── repository/         # 데이터 접근 계층
│   └── MentRepository.java
├── model/             # 엔티티 클래스
│   ├── Ment.java
│   ├── Survey.java
│   └── User.java
├── dto/               # 데이터 전송 객체
│   ├── QuoteResponse.java
│   ├── SurveyRequest.java
│   ├── SurveyResultResponse.java
│   ├── RecommendationRequest.java
│   ├── RecommendationResponse.java
│   ├── PercentageRequest.java
│   └── PercentageResponse.java
└── DemoApplication.java
```

## 🚀 API 엔드포인트

### 1. 오늘의 멘트 조회
```http
GET /api/v0/quotes
```
**응답:**
```json
{
  "ment": "오늘도 화이팅! 당신의 노력은 빛날 거예요."
}
```

### 2. 설문조사 결과 제출
```http
POST /api/v0/surveys
Content-Type: application/json
```
**요청:**
```json
{
  "userID": 1,
  "college": "숙명여자대학교",
  "grade": 3,
  "major": "컴퓨터과학",
  "study_time": 6,
  "work_time": 2,
  "sleep_time": 7,
  "major_credit": 15,
  "general_credit": 6,
  "external_activities_time": 3
}
```
**응답:**
```json
{
  "category": "학습 집중형",
  "code": 123,
  "description": "학업에 많은 시간을 투자하며 체계적으로 학습하는 유형입니다.",
  "major_percentage": 71,
  "study_percentage": 50,
  "outdoor_activity_percentage": 25
}
```

### 3. GPT 추천 받기
```http
POST /api/v0/surveys/recommend
Content-Type: application/json
```
**요청:**
```json
{
  "userID": 1,
  "study_time": 6,
  "work_time": 2,
  "sleep_time": 7,
  "external_activities_time": 3
}
```
**응답:**
```json
{
  "recommend": "당신의 시간 배분을 분석한 결과: 학습에 충분한 시간을 투자하고 있습니다. 충분한 수면을 취하고 있어 좋습니다."
}
```

### 4. 전체/학교에서 내 유형 비율
```http
POST /api/v0/surveys/percentage
Content-Type: application/json
```
**요청:**
```json
{
  "userID": 1,
  "college": "숙명여자대학교",
  "code": "123"
}
```
**응답:**
```json
{
  "result": "균형형",
  "percentage": 32
}
```

## 🗄️ 데이터베이스 설정

### MySQL 데이터베이스 생성
```sql
CREATE DATABASE survey_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE survey_db;
```

### 명언 테이블 생성 및 샘플 데이터
```sql
CREATE TABLE ment (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    content TEXT NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO ment (content) VALUES 
('오늘도 화이팅! 당신의 노력은 빛날 거예요.'),
('작은 발걸음도 목표를 향한 소중한 진전입니다.'),
('포기하지 마세요. 성공은 한 걸음 더 앞에 있어요.');
```

## ⚙️ 실행 방법

### 1. 환경 설정
- Java 17 이상 설치
- MySQL 8.0 설치
- 데이터베이스 생성

### 2. 설정 파일 수정
`src/main/resources/application.properties`에서 데이터베이스 정보 수정:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/survey_db
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### 3. 서버 실행
```bash
# Gradle 빌드 및 실행
./gradlew bootRun

# 또는 JAR 파일 생성 후 실행
./gradlew build
java -jar build/libs/demo-0.0.1-SNAPSHOT.jar
```

### 4. API 테스트
```bash
# 오늘의 멘트 조회
curl -X GET http://localhost:8080/api/v0/quotes

# 설문조사 제출 (예시)
curl -X POST http://localhost:8080/api/v0/surveys \
  -H "Content-Type: application/json" \
  -d '{"userID": 1, "college": "숙명여자대학교", "grade": 3, "major": "컴퓨터과학", "study_time": 6, "work_time": 2, "sleep_time": 7, "major_credit": 15, "general_credit": 6, "external_activities_time": 3}'
```

## 🔧 개발 환경

- **IDE**: IntelliJ IDEA / VS Code
- **Java**: OpenJDK 17
- **Gradle**: 7.x
- **Spring Boot**: 3.1.0
- **MySQL**: 8.0

## 👥 팀 정보

- **프로젝트**: 코코톤 해커톤
- **팀**: kspark
- **개발자**: SeoyeonH

## 📄 라이선스

이 프로젝트는 해커톤 목적으로 제작되었습니다.
