# Collection

- [컬렉션 프레임워크](#컬렉션-프레임워크)
- [List 계열](#list-계열)
- [Set 계열](#set-계열)
- [Map](#map)
- [Properties](#properties)

<br>

---

### 컬렉션 프레임워크

> 컬렉션 프레임워크는 데이터를 효율적으로 저장, 검색, 삭제, 정렬할 수 있는 자료구조 API 집합이다. `java.util` 패키지에 있고 List, Set, Map 자료구조를 제공한다. 변수 타입을 인터페이스(`List`, `Set`, `Map`)로 선언하면 구현 클래스를 바꿔도 같은 메서드로 쓸 수 있다.

<br>

---

### List 계열

> List는 순서가 있고 중복을 허용하는 컬렉션이며 인덱스로 요소에 접근한다.

<br>

| 클래스 | 내부 구조 | 특징 |
|---|---|---|
| `ArrayList` | 배열 | 조회가 빠르고 중간 삽입과 삭제는 느림 |
| `LinkedList` | 연결 리스트 | 중간 삽입과 삭제가 빠르고 조회는 느림 |
| `Vector` | 배열 | 동기화되어 멀티스레드에 안전하지만 조금 느림 |
| `Stack` | Vector 기반 | LIFO(후입선출). `push`로 쌓고 `pop`으로 꺼냄 |

<br>

```java
List<String> list = new ArrayList<>();
list.add("JAVA");                   // 추가
list.get(0);                        // 인덱스로 조회
list.indexOf("JAVA");               // 값으로 위치 조회(없으면 -1)
list.remove(0);                     // 인덱스로 삭제
list.remove("JAVA");                // 값으로 삭제
list.forEach(System.out::println);  // 전체 출력(메서드 참조)
list.clear();                       // 전체 삭제
```

<br>

> ArrayList는 중간에 넣거나 빼면 뒤의 요소를 한 칸씩 밀어야 해 느리지만 인덱스로 바로 찾아 조회가 빠르다. LinkedList는 앞뒤 연결만 바꾸면 되어 삽입과 삭제가 빠르고, 첫 칸부터 차례로 찾아가 조회가 느리다. Stack은 웹 브라우저의 뒤로 가기, 실행 취소(Ctrl+Z), 메서드 호출 스택에 쓰인다.

<br>

- 예제 코드: [ArrayList](../JAVA03/src/Ch04Collection/C01ListArrayList.java)
- 예제 코드: [LinkedList](../JAVA03/src/Ch04Collection/C02ListLinkedList.java)

---

### Set 계열

> Set은 순서가 없고 중복을 허용하지 않는 컬렉션이다. 인덱스가 없어 `for` 문으로 접근할 수 없고 Iterator나 향상된 `for` 문으로 순회한다.

<br>

| 클래스 | 순서 | 특징 |
|---|---|---|
| `HashSet` | 없음 | 추가, 삭제, 중복 확인이 가장 빠름 |
| `LinkedHashSet` | 입력 순서 유지 | HashSet에 연결 정보를 추가해 약간 느림 |
| `TreeSet` | 자동 정렬 | 이진 탐색 트리 기반. 넣을 때마다 정렬 위치를 찾아 가장 느림 |

<br>

```java
Set<String> set = new HashSet<>();
set.add("JAVA");
set.add("JAVA");        // 중복이라 저장되지 않음
for (String el : set) System.out.println(el);
```

<br>

> Iterator는 컬렉션의 요소를 차례로 꺼내는 반복자이다. `hasNext()`로 꺼낼 요소가 남았는지 확인하고 `next()`로 꺼내 다음 위치로 이동한다.

<br>

> 객체를 Set에 넣을 때 필드 값이 같은 객체를 중복으로 보려면 `hashCode`와 `equals`를 재정의해야 한다. 로또 번호는 Set의 크기가 6이 될 때까지 난수를 추가하면 중복 없이 뽑을 수 있다.

<br>

- 예제 코드: [HashSet](../JAVA03/src/Ch04Collection/C03SetHashSet.java)
- 예제 코드: [로또 번호 문제](../JAVA03/src/Ch04Collection/C04LottoSet.java)
- 예제 코드: [객체를 담는 Set](../JAVA03/src/Ch04Collection/C05SetObject.java)

---

### Map

> Map은 키(Key)와 값(Value)을 한 쌍으로 저장하는 컬렉션이다. 키는 중복될 수 없고 같은 키로 `put`하면 값이 덮어써진다. `keySet()`으로 모든 키를 얻어 `get(키)`로 값을 꺼낸다.

<br>

```java
Map<String, Integer> map = new HashMap<>();
map.put("aaa", 1111);
map.get("aaa");
map.remove("aaa");
for (String key : map.keySet()) System.out.println(key + map.get(key));
```

<br>

> 값의 자료형을 `Object`로 두면 문자열, 숫자, 배열, 리스트를 한 Map에 담아 주고받을 수 있다. 꺼낸 값은 `instanceof`로 실제 자료형을 확인해 나눠 처리한다.

<br>

- 예제 코드: [HashMap](../JAVA03/src/Ch04Collection/C06MapHashMap.java)
- 예제 코드: [Map으로 값 주고받기](../JAVA03/src/Ch04Collection/C07MapParams.java)

---

### Properties

> Properties는 `키=값` 형태의 설정 파일을 읽고 쓰는 Map 계열 클래스이다. `load()`로 파일을 읽고 `getProperty(키)`로 값을 꺼낸다. DB 접속 정보처럼 코드에 직접 쓰기 어려운 값을 파일로 분리할 때 쓰며, 스프링의 `application.properties`와 같은 방식이다.

<br>

<span style="color:brown">`application.properties`의 `password`는 본인 값으로 바꿔서 사용한다. 실제 비밀번호는 저장소에 올리지 않는다.</span>

<br>

- 예제 코드: [Properties](../JAVA03/src/Ch04Collection/C08Properties.java)
- 예제 코드: [설정 파일](../JAVA03/src/Ch04Collection/application.properties)

---

### Link
[Java Collections](https://docs.oracle.com/javase/tutorial/collections/index.html)
