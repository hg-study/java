# Environment

- [문제 개요](#문제-개요)
- [JDK와 JDBC 드라이버](#jdk와-jdbc-드라이버)
- [MySQL 데이터베이스](#mysql-데이터베이스)
- [접속 정보 분리](#접속-정보-분리)
- [빌드와 실행](#빌드와-실행)

<br>

---

### 문제 개요

> NCS 능력단위 `네트워크 프로그래밍 구현`(2수준) 평가 실습 프로젝트이다. 학생은 `src/` 폴더의 파일만 구현하고, Swing UI와 런처는 `provided/` 폴더에 완성된 형태로 제공되어 수정하지 않는다. 문제는 세 가지이다.

<br>

| 문제 | 내용 | 구현 위치 |
|---|---|---|
| 1. 개발환경 구축 | JDK, MySQL, JDBC 드라이버, GitHub 형상관리 | 결과물(스크린샷과 설명) |
| 2. 소켓 채팅 | `ServerSocket`과 `Thread`로 다중 접속 채팅 | `src/chat/` |
| 3. JDBC CRUD | `Book_tbl` 등록, 조회, 수정, 삭제 | `src/book/` |

<br>

> 조 단위 협업으로 진행했다. 조장은 DB와 GitHub 환경, 통합, 시연을 맡고 조원은 채팅 서버와 핸들러, 채팅 클라이언트, `Book`과 `DBUtil`, `BookDAO`를 나눠 구현했다. Git은 브랜치를 나눠 작업하고 PR로 합치는 흐름을 썼다.

<br>

---

### JDK와 JDBC 드라이버

> JDK 17 이상을 설치하고 `java -version`, `javac -version`으로 확인한다. MySQL Connector/J(jar)를 `lib/` 폴더에 넣고 이클립스의 Build Path에 추가한다. 이 저장소에는 사용한 `mysql-connector-j-9.7.0.jar`를 `lib/`에 함께 올려 두었고, `.classpath`가 이 파일을 가리킨다.

<br>

<aside>

드라이버 다운로드 : https://dev.mysql.com/downloads/connector/j/ 에서 Platform Independent ZIP 을 받아 `mysql-connector-j-9.x.x.jar` 를 `lib/` 에 복사한다.

</aside>

<br>

- 예제 코드: [lib 폴더 안내](../EXAM/lib/README.md)
- 예제 코드: [MySQL 드라이버 jar](../EXAM/lib/mysql-connector-j-9.7.0.jar)

---

### MySQL 데이터베이스

> `db/schema.sql`이 `BookDB` 데이터베이스와 `dbconn` 계정, 권한, 테이블 6개(회원, 분류, 도서, 대여, 예약, 부록)와 예제 데이터를 한꺼번에 만든다. 접속 계정의 비밀번호는 `YOUR_PASSWORD`로 비워 두었으니 본인 값으로 바꿔 실행한다.

<br>

```sql
CREATE DATABASE BookDB DEFAULT CHARACTER SET utf8mb4;
CREATE USER 'dbconn'@'%' IDENTIFIED BY 'YOUR_PASSWORD';
GRANT ALL PRIVILEGES ON BookDB.* TO 'dbconn'@'%';
```

<br>

```cmd
mysql -uroot -p < db\schema.sql
```

<br>

- 예제 코드: [스키마 SQL](../EXAM/db/schema.sql)

---

### 접속 정보 분리

> 접속 정보를 코드에 쓰지 않고 `config/db.properties`로 분리한다. `config/db.properties.sample`을 복사해 `db.properties`로 만든 뒤 본인 환경에 맞게 고치고, `db.properties`는 `.gitignore`에 등록해 커밋되지 않게 한다. MySQL 8의 기본 인증 방식이 서버 공개키를 요구하므로 URL에 `allowPublicKeyRetrieval=true`를 붙인다.

<br>

```properties
db.driver=com.mysql.cj.jdbc.Driver
db.url=jdbc:mysql://localhost:3306/BookDB?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Asia/Seoul&characterEncoding=UTF-8
db.user=dbconn
db.password=YOUR_PASSWORD
```

<br>

- 예제 코드: [접속 정보 템플릿](../EXAM/config/db.properties.sample)

---

### 빌드와 실행

> `build.bat`이 `src`와 `provided`의 소스를 컴파일해 `bin/`에 만든다. 이후 배치 파일로 서버, 채팅 클라이언트, 도서 관리 화면, 메뉴(런처)를 실행한다.

<br>

| 파일 | 실행 대상 |
|---|---|
| `build.bat` | 전체 컴파일 |
| `run-server.bat` | 채팅 서버 |
| `run-chat.bat` | 채팅 클라이언트 화면 |
| `run-book.bat` | 도서 관리 화면 |
| `run-menu.bat` | 두 화면을 고르는 메뉴 |

<br>

- 예제 코드: [빌드](../EXAM/build.bat)
- 예제 코드: [서버 실행](../EXAM/run-server.bat)
- 예제 코드: [채팅 클라이언트 실행](../EXAM/run-chat.bat)
- 예제 코드: [도서 관리 실행](../EXAM/run-book.bat)
- 예제 코드: [메뉴 실행](../EXAM/run-menu.bat)
- 예제 코드: [메뉴(런처)](../EXAM/provided/launcher/Main.java)

---

### Link
[MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/)
