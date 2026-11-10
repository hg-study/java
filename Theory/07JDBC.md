# JDBC

- [JDBC](#jdbc)
- [연결](#연결)
- [INSERT, UPDATE, DELETE](#insert-update-delete)
- [SELECT](#select)
- [DTO와 공공데이터 조회](#dto와-공공데이터-조회)
- [트랜잭션](#트랜잭션)

<br>

---

### JDBC

> JDBC는 자바에서 DBMS에 접속해 SQL을 실행하는 표준 API이다. 주요 객체는 `Connection`(DB와의 연결), `PreparedStatement`(SQL 전송), `ResultSet`(SELECT 결과)이다. MySQL 드라이버(mysql-connector-j jar, 내려받는 법은 IO 이론의 라이브러리 표 참고)가 필요하고 MySQL에 `opendatadb` 데이터베이스를 미리 만들어 둔다.

<br>

<span style="color:brown">접속 정보의 비밀번호는 `YOUR_PASSWORD`로 비워 두었다. 본인 환경의 값으로 바꿔서 사용하고 실제 비밀번호는 저장소에 올리지 않는다.</span>

<br>

---

### 연결

> `Class.forName("com.mysql.cj.jdbc.Driver")`로 드라이버 클래스를 메모리에 적재하고, `DriverManager.getConnection(url, 아이디, 비밀번호)`로 DB와 연결된 `Connection`을 얻는다. 작업이 끝나면 `finally`에서 연 순서의 역순으로 자원을 닫는다.

<br>

```java
String url = "jdbc:mysql://localhost:3306/opendatadb";
Class.forName("com.mysql.cj.jdbc.Driver");
Connection conn = DriverManager.getConnection(url, id, pw);
```

<br>

- 예제 코드: [JDBC 연결](../JAVA03/src/Ch08JDBC/C01DbConnect.java)

---

### INSERT, UPDATE, DELETE

> `prepareStatement`는 `?` 자리표시자가 있는 SQL을 준비하고 `setInt`, `setString`으로 값을 채운다. SQL 인젝션을 막을 수 있다. `executeUpdate()`는 변경된 행 수를 돌려주므로 0보다 크면 성공으로 판단한다.

<br>

```java
pstmt = conn.prepareStatement("insert into tbl_a values(?,?)");
pstmt.setInt(1, Integer.parseInt(args[0]));
pstmt.setString(2, args[1]);
int result = pstmt.executeUpdate();
```

<br>

- 예제 코드: [INSERT](../JAVA03/src/Ch08JDBC/C02DbInsert.java)
- 예제 코드: [UPDATE](../JAVA03/src/Ch08JDBC/C03DbUpdate.java)
- 예제 코드: [DELETE](../JAVA03/src/Ch08JDBC/C04DbDelete.java)

---

### SELECT

> `executeQuery()`는 조회 결과인 `ResultSet`을 돌려준다. `rs.next()`는 다음 행으로 이동해 행이 있으면 `true`이고, `getInt`, `getString`으로 컬럼 값을 꺼낸다.

<br>

```java
rs = pstmt.executeQuery();
while (rs.next()) {
    System.out.println(rs.getInt("no") + "." + rs.getString("name"));
}
```

<br>

- 예제 코드: [SELECT](../JAVA03/src/Ch08JDBC/C05DbSelect.java)

---

### DTO와 공공데이터 조회

> DTO(Data Transfer Object)는 테이블 한 행의 데이터를 담아 옮기는 클래스이다. 조회한 행을 DTO 객체에 담아 `List`에 모은다. 공공데이터(전국 도시가스충전소 현황, 대구광역시 북구 불법주정차 위반 정보) CSV를 MySQL에 가져온 뒤 읽는다. DTO 필드 이름은 테이블 컬럼명(한글)과 같게 두었다.

<br>

- 예제 코드: [충전소 DTO](../JAVA03/src/Ch08JDBC/C06ChargeStationDto.java)
- 예제 코드: [충전소 조회](../JAVA03/src/Ch08JDBC/C06ChargeStationSelect.java)
- 예제 코드: [불법 주정차 DTO](../JAVA03/src/Ch08JDBC/C07IllegalParkingDto.java)
- 예제 코드: [불법 주정차 조회](../JAVA03/src/Ch08JDBC/C07IllegalParkingSelect.java)
- 예제 코드: [한국가스안전공사 전국 도시가스충전소 현황 CSV](../JAVA03/src/Ch08JDBC/GasChargeStation_20240926.csv)
- 예제 코드: [대구광역시 북구 불법주정차 위반 정보 CSV](../JAVA03/src/Ch08JDBC/IllegalParking_20250101.csv)

---

### 트랜잭션

> 트랜잭션은 여러 SQL을 하나의 작업 단위로 묶어 모두 성공해야 반영(commit)하고 실패하면 되돌리는(rollback) 기능이다. `setAutoCommit(false)`로 자동 반영을 끄고 `commit()`을 호출할 때 한꺼번에 반영한다. `Savepoint`는 되돌릴 지점을 표시해 `rollback(sp1)`이 그 지점 이후만 취소하게 한다.

<br>

```java
conn.setAutoCommit(false);
Savepoint sp1 = conn.setSavepoint("sp1");
// ... 여러 SQL 실행 ...
conn.commit();
// 실패 시 conn.rollback(sp1) 또는 conn.rollback()
```

<br>

- 예제 코드: [트랜잭션](../JAVA03/src/Ch08JDBC/C08Transaction.java)

---

### Link
[JDBC](https://docs.oracle.com/javase/tutorial/jdbc/basics/index.html)
