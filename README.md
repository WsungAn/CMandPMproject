# 🛒 C&PM Project - Customer & Product Management Admin Dashboard

<div align="center">

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.0-brightgreen)
![Java](https://img.shields.io/badge/Java-17-orange)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue)

**관리자 중심의 고객, 상품, 주문 통합 관리 시스템**

[프로젝트 소개](#프로젝트-소개) • [주요-기능](#주요-기능) • [기술-스택](#기술-스택) • [프로젝트-구조](#프로젝트-구조) • [실행-방법](#실행-방법)

</div>

---

## 📋 프로젝트 소개

C&PM(Customer & Product Management)은 **전자상거래 사업을 위한 관리자 대시보드 시스템**입니다. 
관리자는 고객, 상품, 주문 정보를 한곳에서 통합적으로 관리할 수 있으며, 
체계적인 권한 관리와 승인 프로세스를 통해 안정적인 운영을 지원합니다.

**핵심 목표**
- 🔐 관리자 계정 기반의 권한 관리 및 승인 체계
- 📦 고객, 상품, 주문 정보의 통합 관리
- 🔄 RESTful API를 통한 효율적인 데이터 관리
- ✅ 입력값 검증 및 데이터 무결성 보장
- 🔒 보안 강화된 비밀번호 관리

---

## 🎯 주요 기능

### 1️⃣ 관리자 관리 (Admin Management)

관리자 계정과 권한을 효율적으로 관리합니다.

**회원 관리**
- 관리자 회원가입 (SignUp)
- 회원 목록 조회 (페이지네이션 지원)
- 회원 상세 정보 조회

**정보 관리**
- 관리자 기본 정보 수정 (이름, 이메일, 전화번호)
- 내 프로필 조회 및 수정
- 비밀번호 변경 (기존 비밀번호 검증)

**권한 관리**
- 관리자 역할 변경 (Role: 시스템 관리자, 마케팅 관리자, 고객 관리자 등)
- 관리자 상태 변경 (활성/비활성)
- 새 관리자 승인/거부 프로세스

**보안 기능**
- Bcrypt를 통한 비밀번호 암호화
- 비밀번호 변경 시 기존 비밀번호 검증

### 2️⃣ 고객 관리 (Customer Management)

고객 정보를 효율적으로 관리합니다.

- 고객 정보 조회
- 고객 기본정보 수정 (이름, 이메일, 전화번호 등)
- 고객 상태 관리

### 3️⃣ 상품 관리 (Product Management)

전자상거래 상품을 관리합니다.

- 상품 등록
- 상품 조회
- 상품 정보 수정
- 상품 상태 관리 (판매중/품절/중단 등)

### 4️⃣ 주문 관리 (Order Management)

고객 주문을 추적하고 관리합니다.

- ✅ 주문 생성 (Create)
- ✅ 주문 조회 (조건 검색 포함)
  - 고객별 주문 검색
  - 상태별 주문 필터링
  - 기간별 주문 검색
  - 정렬 기능 (생성일, 수정일 등)
- ✅ 주문 상세 조회
- 🔄 주문 상태 변경 (대기중/진행중/완료/취소) [개발 진행 중]
- 🔄 주문 취소 기능 [개발 진행 중]

---

## 🛠 기술 스택

### Backend
```yaml
Framework: Spring Boot 4.1.0
Language: Java 17
ORM: Spring Data JPA (Hibernate)
Database: MySQL 8.0
Validation: Spring Validation
Security: Bcrypt 0.10.2
Build Tool: Gradle
```

### 주요 의존성
```gradle
- spring-boot-starter-data-jpa
- spring-boot-starter-validation
- spring-boot-starter-webmvc
- spring-boot-starter-web
- mysql-connector-j
- lombok
- bcrypt
- JUnit 5 (Testing)
```

### 개발 환경
```
IDE: IntelliJ IDEA
Version Control: Git & GitHub
Package Manager: Gradle
```

---

## 📁 프로젝트 구조

```
CmandPmproject/
├── src/main/java/com/example/cmandpmproject/
│   ├── CMandPMprojectApplication.java          # 메인 애플리케이션
│   │
│   ├── admin/                                   # 관리자 모듈
│   │   ├── controller/
│   │   │   ├── AdminController.java             # 관리자 관리 API
│   │   │   └── AuthController.java              # 인증 API
│   │   ├── service/
│   │   │   ├── AdminService.java                # 관리자 비즈니스 로직
│   │   │   └── AuthService.java                 # 인증 서비스
│   │   ├── repository/
│   │   │   └── AdminRepository.java             # 관리자 데이터 접근
│   │   ├── entity/
│   │   │   ├── Admin.java                       # 관리자 엔티티
│   │   │   ├── AdminRole.java                   # 역할 Enum
│   │   │   └── AdminStatus.java                 # 상태 Enum
│   │   ├── dto/
│   │   │   ├── SignupRequest/Response.java      # 가입 DTO
│   │   │   ├── LoginRequest/Response.java       # 로그인 DTO
│   │   │   ├── AdminResponse.java               # 관리자 응답 DTO
│   │   │   ├── UpdateAdmin(Request).java        # 정보 수정 DTO
│   │   │   └── ChangePasswordRequest.java       # 비밀번호 변경 DTO
│   │   └── Config/
│   │       └── PasswordEncoder.java             # 비밀번호 암호화 설정
│   │
│   ├── customer/                                # 고객 모듈
│   │   ├── controller/
│   │   │   └── CustomerController.java
│   │   ├── service/
│   │   │   ├── CustomerService.java
│   │   │   └── CustomerServiceImpl.java
│   │   ├── repository/
│   │   │   └── CustomerRepository.java
│   │   ├── entity/
│   │   │   └── Customer.java
│   │   └── dto/
│   │       ├── CustomerResponse.java
│   │       ├── CustomerUpdateRequest.java
│   │       └── CustomerUpdateResponse.java
│   │
│   ├── product/                                 # 상품 모듈
│   │   ├── controller/
│   │   │   └── ProductController.java
│   │   ├── service/
│   │   │   └── ProductService.java
│   │   ├── repository/
│   │   │   └── ProductRepository.java
│   │   ├── entity/
│   │   │   ├── Product.java
│   │   │   └── ProductStatus.java
│   │   └── dto/
│   │       ├── ProductCreateRequest.java
│   │       └── ProductResponse.java
│   │
│   ├── order/                                   # 주문 모듈
│   │   ├── controller/
│   │   │   └── OrderController.java
│   │   ├── service/
│   │   │   └── OrderService.java
│   │   ├── repository/
│   │   │   └── OrderRepository.java
│   │   ├── entity/
│   │   │   ├── Order.java
│   │   │   └── OrderStatus.java
│   │   └── dto/
│   │       ├── CreateOrderRequest/Response.java
│   │       ├── GetOrderResponse.java
│   │       ├── GetAllOrderResponse.java
│   │       ├── UpdateOrderRequest/Response.java
│   │       ├── DeleteOrderRequest.java
│   │       ├── OrderSearchCondition.java
│   │       ├── SortBy.java
│   │       └── SortOrder.java
│   │
│   └── common/                                  # 공통 모듈
│       └── BaseEntity.java                      # 공통 필드 (생성일, 수정일)
│
├── src/main/resources/
│   └── application.properties                   # 애플리케이션 설정
│
├── src/test/java/                              # 테스트 코드
│
├── build.gradle                                 # 그래들 빌드 설정
├── gradlew & gradlew.bat                       # 그래들 래퍼
└── README.md                                    # 이 파일
```

---

## 🏗 계층형 아키텍처 (Layered Architecture)

```
┌─────────────────────────────────────┐
│         Controller Layer             │ HTTP 요청 처리
│  (AdminController, etc.)             │
└──────────────┬──────────────────────┘
               │
┌──────────────▼──────────────────────┐
│          Service Layer              │ 비즈니스 로직 구현
│  (AdminService, etc.)               │
└──────────────┬──────────────────────┘
               │
┌──────────────▼──────────────────────┐
│        Repository Layer             │ 데이터 접근
│  (AdminRepository, etc.)            │
└──────────────┬──────────────────────┘
               │
┌──────────────▼──────────────────────┐
│         Database Layer              │ MySQL
│       (Spring Data JPA)             │
└─────────────────────────────────────┘
```

**각 계층의 역할**
- Controller: HTTP 요청 수신 및 응답 처리
- Service: 비즈니스 로직 구현 및 트랜잭션 관리
- Repository: JPA를 통한 데이터 퍼시스턴스
- Entity: 데이터베이스 테이블 매핑

---

## 💡 기술적 의사결정

### 1. Spring Boot 4.1.0 + Java 17
**왜?** 최신 LTS 버전의 안정성과 성능
- Java 17: 최신 LTS 버전의 성능과 기능
- Spring Boot 4.1: 최신 프레임워크 기능 활용
- 현대적인 개발 패턴 학습 기회

### 2. JPA/Hibernate ORM
**왜?** 객체-관계형 매핑의 편의성
- SQL 직접 작성 없이도 복잡한 쿼리 처리 가능
- 데이터베이스 변경에 유연한 구조
- N+1 문제, 캐싱 등 성능 최적화 옵션 제공

### 3. DTO 패턴
**왜?** 계층간 명확한 계약 정의
- Entity와 View의 직접 노출 방지
- 요청/응답 데이터의 명시적 정의
- API 변경에 따른 Entity 수정 최소화

### 4. Lombok 라이브러리
**왜?** 보일러플레이트 코드 최소화
- Getter, Setter, Constructor 자동 생성
- 코드 가독성 및 유지보수성 향상
- @RequiredArgsConstructor로 의존성 주입 간편화

### 5. Bcrypt 암호화
**왜?** 보안 강화된 비밀번호 관리
- 단방향 암호화로 저장된 비밀번호 보호
- Salt 기반 해싱으로 레인보우 테이블 공격 방지
- Spring Security와 통합 용이

### 6. 입력값 검증 (Validation)
**왜?** 데이터 무결성 보장
- @Valid 및 @Validated로 자동 검증
- 요청 시점에 유효성 검사로 불필요한 처리 방지
- 사용자에게 명확한 에러 메시지 제공

---

## 🚀 실행 방법

### 사전 요구사항

```
✅ Java 17 이상
✅ MySQL 8.0 이상
✅ Gradle (또는 gradlew 사용)
```

### 1. 데이터베이스 설정

**MySQL 데이터베이스 생성**
```sql
CREATE DATABASE CMnPM CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

### 2. 환경 설정

`application.properties` 파일에서 데이터베이스 연결 정보를 수정하세요.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/CMnPM
spring.datasource.username=root
spring.datasource.password=12345678
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA 설정
spring.jpa.hibernate.ddl-auto=create  # 시작 시 테이블 자동 생성
spring.jpa.show-sql=true              # SQL 쿼리 콘솔 출력
spring.jpa.properties.hibernate.format_sql=true  # SQL 포맷팅
```

### 3. 빌드 및 실행

**방법 1: Gradle 래퍼 사용 (권장)**
```bash
# 의존성 설정
./gradlew clean build

# 애플리케이션 실행
./gradlew bootRun
```

**방법 2: IDE에서 직접 실행**
```
CMandPMprojectApplication.java를 우클릭
→ Run 'CMandPMprojectApplication'
```

### 4. 애플리케이션 확인

```
✅ 서버 시작: http://localhost:8080
✅ 상태 확인: http://localhost:8080/
```

---

## 📡 API 엔드포인트

### 관리자 API

```http
# 회원가입
POST   /api/users/signup
Body: {
  "username": "admin@example.com",
  "password": "Password123!",
  "name": "관리자명",
  "email": "admin@example.com",
  "phonenumber": "010-1234-5678"
}

# 관리자 목록 조회 (페이지네이션)
GET    /api/users?page=1&limit=10

# 관리자 상세 조회
GET    /api/users/{id}

# 관리자 정보 수정
PUT    /api/users/{id}
Body: {
  "name": "수정된 이름",
  "email": "new@example.com",
  "phonenumber": "010-9876-5432"
}

# 관리자 역할 변경
PATCH  /api/users/{id}/role?newRole=ROLE_ADMIN

# 관리자 상태 변경
PATCH  /api/users/{id}/status?newStatus=ACTIVE

# 관리자 승인
PATCH  /api/users/{id}/approval

# 관리자 거부
PATCH  /api/users/{id}/reject?reason=부적절한%20신청

# 내 프로필 조회
GET    /api/users/me?userId={id}

# 내 프로필 수정
PUT    /api/users/me
Body: {
  "userId": {id},
  "name": "새로운 이름",
  "email": "newemail@example.com",
  "phonenumber": "010-1111-2222"
}

# 비밀번호 변경
PUT    /api/users/auth/password
Body: {
  "userId": {id},
  "oldPassword": "기존비밀번호",
  "newPassword": "새로운비밀번호"
}

# 관리자 삭제
DELETE /api/users/{id}
```

### 주문 API

```http
# 주문 생성
POST   /api/orders
Body: {
  "customerId": 1,
  "productId": 1,
  "quantity": 5,
  "totalPrice": 50000.00
}

# 주문 목록 조회 (검색 조건 포함)
GET    /api/orders?customerId=1&status=PENDING&sort=createdAt&order=DESC

# 주문 상세 조회
GET    /api/orders/{orderId}
```

### 고객 API

```http
# 고객 정보 조회
GET    /api/customers/{customerId}

# 고객 정보 수정
PUT    /api/customers/{customerId}
Body: {
  "name": "변경된 이름",
  "email": "customer@example.com",
  "phonenumber": "010-1234-5678"
}
```

### 상품 API

```http
# 상품 등록
POST   /api/products
Body: {
  "name": "상품명",
  "description": "상품 설명",
  "price": 10000.00,
  "quantity": 100
}

# 상품 조회
GET    /api/products/{productId}
```

---

## ✅ 기능 완성도

| 모듈 | 기능 | 상태 | 비고 |
|------|------|------|------|
| Admin | 회원가입/로그인 | ✅ 완료 | |
| Admin | 목록 조회 (페이지네이션) | ✅ 완료 | |
| Admin | 정보 수정 | ✅ 완료 | |
| Admin | 역할/상태 변경 | ✅ 완료 | |
| Admin | 승인/거부 | ✅ 완료 | |
| Admin | 비밀번호 관리 | ✅ 완료 | |
| Customer | 정보 조회/수정 | ✅ 완료 | |
| Product | 상품 관리 | ✅ 완료 | |
| Order | 주문 생성 | ✅ 완료 | |
| Order | 주문 조회 (동적 검색) | ✅ 완료 | Sort, Filter 지원 |
| Order | 주문 상태 변경 | 🔄 진행중 | UpdateOrderService 구현 필요 |
| Order | 주문 취소 | 🔄 진행중 | DeleteOrderService 구현 필요 |

---

## 🎓 이 프로젝트를 통해 배운 기술

✅ **Spring Boot 프레임워크**
- Dependency Injection과 IoC 컨테이너 이해
- Spring MVC의 요청-응답 처리
- 자동 설정(Auto Configuration) 원리

✅ **데이터베이스 설계 및 ORM**
- JPA/Hibernate를 통한 객체-관계형 매핑
- 엔티티 관계 설정 (@OneToMany, @ManyToOne 등)
- 데이터베이스 정규화

✅ **RESTful API 설계**
- HTTP 메서드의 올바른 사용 (GET, POST, PUT, PATCH, DELETE)
- 상태 코드의 의미 있는 활용
- 요청/응답 DTO 설계

✅ **계층형 아키텍처**
- Controller, Service, Repository 계층 분리
- 관심사의 분리(Separation of Concerns)
- 각 계층의 책임과 역할

✅ **보안**
- Bcrypt를 통한 비밀번호 암호화
- 패스워드 변경 시 기존 비밀번호 검증
- 권한 기반 접근 제어(RBAC) 기초

✅ **입력값 검증**
- @Valid와 @Validated 어노테이션 활용
- 커스텀 검증 로직 구현
- 사용자 친화적 에러 메시지

✅ **협업 개발**
- Git을 통한 버전 관리
- 기능별 브랜치 운영
- Pull Request와 코드 리뷰

---

## 🔄 향후 개선 사항

### 기능 완성
- [ ] Order 상태 변경 API 완성
- [ ] Order 취소 기능 구현
- [ ] Product 삭제 기능
- [ ] Customer 삭제 기능
- [ ] 대량 작업 (Batch) 지원

### 성능 최적화
- [ ] 페이지네이션 개선 (Offset 기반 → Cursor 기반)
- [ ] 데이터베이스 인덱싱 최적화
- [ ] 캐싱 도입 (Redis)
- [ ] 쿼리 성능 프로파일링 및 최적화

### 보안 강화
- [ ] JWT 토큰 기반 인증 도입
- [ ] 접근 제어(Authorization) 세분화
- [ ] Rate Limiting 구현
- [ ] SQL Injection 방지 검증

### 테스트 확대
- [ ] Unit Test 커버리지 증대
- [ ] Integration Test 작성
- [ ] API 문서화 (Swagger/OpenAPI)

### 배포 및 운영
- [ ] Docker 컨테이너화
- [ ] CI/CD 파이프라인 구축
- [ ] 에러 로깅 및 모니터링 (Sentry, ELK)
- [ ] 애플리케이션 성능 모니터링 (APM)

---

## 📝 개발 노트

### 현재 작업 상황

**완료된 기능**
- Admin 모듈의 전체 CRUD 및 권한 관리
- Customer 모듈의 기본 관리 기능
- Product 모듈의 상품 관리
- Order 모듈의 주문 생성 및 조회 (동적 검색 포함)

**진행 중인 기능**
- Order 상태 변경 (UpdateOrderRequest와 Service 구현 필요)
- Order 취소 기능 (DeleteOrderRequest와 Service 구현 필요)
- 컨트롤러의 TODO 주석 참고

### 코드 컨벤션
- 클래스명: PascalCase (e.g., AdminController)
- 메서드명: camelCase (e.g., getAdminDetail)
- 상수명: UPPER_SNAKE_CASE
- 패키지명: 도메인 기반 구조 (admin, customer, product, order)

---

## 📞 문의 및 피드백

이 프로젝트에 대한 질문이나 개선 사항이 있다면 Issue를 등록해주세요.

---

<div align="center">

**Made by Sparta Bootcamp Student** 🚀

진정성 있는 개발로 좋은 서비스를 만들어가겠습니다.

</div>
