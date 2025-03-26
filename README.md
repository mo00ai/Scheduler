<br>

<h1>📅일정 관리 앱 만들기 </h2>

<br>

<h3>1️⃣프로젝트 소개</h3>
Java와 JDBC를 기반으로 일정 정보를 생성, 조회, 수정, 삭제할 수 있는 일정 관리 백엔드 프로젝트입니다.  
3 Layer Architecture를 기반으로 역할을 명확히 분리하고, RESTful한 API 설계를 직접 구현해보며 백엔드 개발의 기본기를 다지기 위해 진행한 프로젝트입니다.

---

<h3>2️⃣기술 스택</h3>

- **언어** : Java 17  
- **IDE** : IntelliJ IDEA  
- **DB** : MySQL  
- **DB 연동** : JDBC  
- **구조** : 3 Layer Architecture (Controller - Service - Repository)

---

<h3>3️⃣프로그램 구조</h3>

- http api 명세서
  ![image](https://github.com/user-attachments/assets/b4d229e8-9386-4a82-a4ac-cafa300fe5bf)

- postman http api 명세서
  https://documenter.getpostman.com/view/31225592/2sAYkKJxoi

- erd
  ![image](https://github.com/user-attachments/assets/d2b6d65d-a438-4448-b04a-b825eec5678d)

---

<h3>4️⃣ 주요 기능</h3>

**일정 생성**
- 할 일, 작성자명, 비밀번호 입력 후 일정 생성
- 생성 시점의 작성일, 수정일 자동 입력

**일정 조회**
- 전체 일정 조회: 작성자명 또는 수정일 기준 조건 검색 가능
- 선택 일정 조회: ID 기반 단건 조회

**일정 수정**
- 할일 / 작성자명 수정 가능
- 비밀번호 일치 시에만 수정 가능
- 수정 시점의 시간으로 수정일 업데이트

**일정 삭제**
- ID 기반 삭제, 비밀번호 일치 시에만 삭제 가능

---

<h3>5️⃣ HTTP API 명세서</h3>
- 수정해서 업로드 예쩡

---

<h3>6️⃣ 실행 방법</h3>
1. 프로젝트 내 schedule.sql 내 ddl을 실행해 테이블 생성합니다.

2. SchedulerApplicaiton.java 또는 Controller를 실행합니다.

3. Readme.md에 작성된 HTTP API 명세서를 확인한 후, POSTMAN같은 프로그램을 열어 직접 CRUD를 해봅니다.

---

<h3>브랜치 소개</h3>

1. mandatory/lv1
- 일정 생성
- 전체 일정 조회
  - 수정일, 작성자명을 기준(RequestParam)으로 조회

2. mandatory/lv2
- 선택한 일정 수정
- 선택한 일정 삭제
- 모두 입력한 비밀번호가 맞으면 수정/삭제 가능


---

### 느낀점


