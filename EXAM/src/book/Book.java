package book;

// =======================================
// Book 클래스 (VO)
// Book_tbl 의 한 행을 나타내는 클래스
// =======================================

// 채점 항목 ------
// 3-1 캡슐화 : 필드를 private 로 숨기고 getter, setter 로만 접근
// VO(Value Object) : 값을 담아 옮기는 객체. BookManagementUI 가 호출하는 시그니처를 그대로 유지함
public class Book {

    // 필드 : 테이블 컬럼과 같은 순서
    private String  bookCode;           // 도서 코드 (PK)
    private Integer classificationId;   // 분류 번호 (FK, null 가능)
    private String  author;
    private String  name;
    private String  publisher;
    private String  isReserve;          // 예약 여부 'Y' 또는 'N'

    // 기본 생성자
    public Book() {}

    // 모든 필드를 받는 생성자
    public Book(String bookCode, Integer classificationId,
                String author, String name, String publisher, String isReserve) {
        this.bookCode = bookCode;
        this.classificationId = classificationId;
        this.author = author;
        this.name = name;
        this.publisher = publisher;
        this.isReserve = isReserve;
    }

    // getter, setter
    public String  getBookCode()                  { return bookCode; }
    public void    setBookCode(String v)          { this.bookCode = v; }
    public Integer getClassificationId()          { return classificationId; }
    public void    setClassificationId(Integer v) { this.classificationId = v; }
    public String  getAuthor()                    { return author; }
    public void    setAuthor(String v)            { this.author = v; }
    public String  getName()                      { return name; }
    public void    setName(String v)              { this.name = v; }
    public String  getPublisher()                 { return publisher; }
    public void    setPublisher(String v)         { this.publisher = v; }
    public String  getIsReserve()                 { return isReserve; }
    public void    setIsReserve(String v)         { this.isReserve = v; }

    @Override
    public String toString() {
        return "Book{bookCode=" + bookCode + ", classificationId=" + classificationId
                + ", author=" + author + ", name=" + name + ", publisher=" + publisher
                + ", isReserve=" + isReserve + "}";
    }
}
