<br>

<h1>📅일정 관리 앱 만들기 </h2>

<br>

<h3>1️⃣프로젝트 소개</h3>
Java와 JDBC를 기반으로 일정 정보를 생성, 조회, 수정, 삭제할 수 있는 콘솔 기반 일정 관리 백엔드 프로젝트입니다.  
3 Layer Architecture를 기반으로 관심사를 명확히 분리하고, RESTful한 API 설계를 직접 구현해보며 백엔드 개발의 기본기를 다지기 위해 진행한 프로젝트입니다.

---

<h3>2️⃣기술 스택</h3>

- **언어** : Java 17  
- **IDE** : IntelliJ IDEA  
- **DB** : MySQL  
- **DB 연동** : JDBC  
- **구조** : 3 Layer Architecture (Controller - Service - Repository)

---

<h3>3️⃣프로그램 구조</h3>

-erd, 계층 구조 프로그램 첨부 예정

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

<img src="https://github.com/user-attachments/assets/0640b112-6f95-40fd-8989-eca4ccad0716" width="30%">

- 메인 메뉴 출력


2. mandatory/lv2

<img src="https://github.com/user-attachments/assets/d3a418cd-d31f-434b-9ca2-61b5d394b86b" width="30%">

- 입력값 받기
- 입력값에 따라 다른 결과 출력


3. mandatory/lv3

<img src="https://github.com/user-attachments/assets/e0e7ab4f-d856-4129-bc09-878ea836075e" width="30%">

- Kiosk, MenuItem 클래스 추가
  - Main : MenuItem 객체 생성 및 초기화, Kiosk 실행
  - Kiosk : 키오스크 로직 실행
  - MenuItem : 햄버거 메뉴 관리 (ex) 싸이버거, 불싸이버거


 4. mandatory/lv4 && mandatory/lv5

<img src="https://github.com/user-attachments/assets/633152a8-b0c5-424d-9edb-c13bae46047c" width="30%">

- Menu 클래스 추가
  - Menu : MenuItem을 관리함, (ex) 햄버거, 음료, 사이드
- getter/setter 추가로 캡슐화

1. challenge/lv1

<img src="https://github.com/user-attachments/assets/b8b3a31a-3486-4464-aad1-79bcffbdcfe6" width="30%">

- 패키지 분리 (cart, menu)
- Cart 클래스 추가
  - 장바구니 기능 구현

2. challenge/lv2

<img src="https://github.com/user-attachments/assets/b8b3a31a-3486-4464-aad1-79bcffbdcfe6" width="30%">

- Discount 클래스 추가
  - 할인 기능 구현



---

### 느낀점


