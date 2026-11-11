# JDBC CRUD

- [요구사항](#요구사항)
- [Book (VO)](#book-vo)
- [DBUtil](#dbutil)
- [BookDAO](#bookdao)
- [화면 연동](#화면-연동)

<br>

---

### 요구사항

> 제공된 스키마의 `Book_tbl`에 대한 등록(C), 조회(R), 수정(U), 삭제(D)를 JDBC와 Swing으로 구현한다. `Book`(VO), `DBUtil`(Connection 도우미), `BookDAO`(CRUD) 세 파일을 구현하고, SQL 인젝션을 막기 위해 `PreparedStatement`를 쓴다.

<br>

| 체크리스트 | 구현 위치 |
|---|---|
| Book VO 캡슐화 (private 필드와 getter, setter) | `Book` |
| Driver 로드와 Connection 획득 | `DBUtil` |
| JDBC 4단계 | `DBUtil`(① 드라이버 로드 ② 연결), `BookDAO`(③ SQL 실행 ④ 결과 처리와 반환) |
| PreparedStatement | `BookDAO` 의 모든 쿼리 |
| UI와 JDBC 연동 | 제공된 화면이 `BookDAO` 를 호출 |

<br>

---

### Book (VO)

> VO(Value Object)는 값을 담아 옮기는 객체이다. `Book_tbl`의 컬럼 6개(`bookCode`, `classificationId`, `author`, `name`, `publisher`, `isReserve`)를 `private` 필드로 두고 생성자, getter, setter 12개, `toString()`을 만든다. 분류 번호는 NULL일 수 있어 `Integer`를 쓴다. 화면이 호출하는 시그니처는 바꾸지 않는다.

<br>

<aside>

이클립스에서 `Alt+Shift+S` 를 누르면 Generate Constructor using Fields, Generate Getters and Setters, Generate toString() 으로 한 번에 만들 수 있다.

</aside>

<br>

- 예제 코드: [Book](../EXAM/src/book/Book.java)

---

### DBUtil

> `getConnection()`은 `Properties`로 `config/db.properties`를 읽어 드라이버, URL, 계정, 비밀번호를 꺼낸 뒤, `Class.forName`으로 드라이버를 적재하고(JDBC 4단계 ①) `DriverManager.getConnection`으로 연결을 얻는다(②). `close(AutoCloseable...)`는 여러 자원을 `null` 확인 후 차례로 닫고 닫는 중 오류가 나도 나머지를 계속 닫는다.

<br>

- 예제 코드: [DBUtil](../EXAM/src/book/DBUtil.java)

---

### BookDAO

> DAO(Data Access Object)는 DB 접근을 전담하는 클래스이다. 네 메서드 모두 `Connection`을 얻어 `prepareStatement`로 `?`에 값을 채워 실행하고(③), `finally`에서 `DBUtil.close`로 반환한다(④).

<br>

| 메서드 | SQL | 반환 |
|---|---|---|
| `insert(Book)` | `INSERT INTO Book_tbl ...` | 변경된 행 수 |
| `selectAll()` | `SELECT ... ORDER BY Book_code` | `List<Book>` |
| `update(Book)` | `UPDATE Book_tbl SET ... WHERE Book_code = ?` | 변경된 행 수 |
| `delete(String)` | `DELETE FROM Book_tbl WHERE Book_code = ?` | 변경된 행 수 |

<br>

> NULL을 다루는 부분이 핵심이다. 저장할 때 분류 번호가 `null`이면 `setNull(index, Types.INTEGER)`를 쓰고, 읽을 때 `getInt`는 NULL을 0으로 돌려주므로 `wasNull()`로 확인해 `null`로 되돌린다.

<br>

```java
Integer classificationId = rs.getInt("Classification_Id");
if (rs.wasNull()) classificationId = null;
```

<br>

- 예제 코드: [BookDAO](../EXAM/src/book/BookDAO.java)

---

### 화면 연동

> 도서 관리 화면(`BookManagementUI`)은 제공된 파일이며 버튼 이벤트에서 `BookDAO`의 `insert`, `update`, `delete`, `selectAll`을 호출한다. `Book`과 `BookDAO`의 시그니처가 같으면 화면은 수정 없이 동작한다.

<br>

- 예제 코드: [도서 관리 화면 (제공)](../EXAM/provided/book/BookManagementUI.java)

---

### Link
[JDBC](https://docs.oracle.com/javase/tutorial/jdbc/basics/index.html)
