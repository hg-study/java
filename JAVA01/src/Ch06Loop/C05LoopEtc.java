package Ch06Loop;

import java.util.ArrayList;
import java.util.List;

// =======================================
// 컬렉션 반복
// List를 기본 for, 향상된 for, 람다식으로 순회
// =======================================

public class C05LoopEtc {
    public static void main(String[] args) {

        // 컬렉션 ------
        // Collection : 여러 데이터를 모아 저장하고 다루는 자료구조(List, Set, Map). 여기서는 순서가 있는 List에 과목을 저장함
        List<String> lists = new ArrayList();

        lists.add("JAVA");              //0
        lists.add("JSP");               //1
        lists.add("SERVLET");           //2
        lists.add("SPRINGBOOT");        //3
        lists.add("NODEJS");            //4
        lists.add("REACT");             //5
        lists.add("DOCKER_COMPOSE");    //6

        // 기본 for ------
        // lists.size() : 들어 있는 요소의 개수를 돌려주는 메서드
        // lists.get(i) : i번째 요소를 꺼내는 메서드
        // for (int i=0; i<lists.size(); i++){
        //     System.out.println(lists.get(i));
        // }

        // 향상된 for ------
        // 향상된 for : 처음부터 끝까지 요소를 하나씩 꺼내 변수에 담아 반복하는 for 문. 인덱스가 필요 없음
        // for(String subject: lists){
        //     System.out.println(subject);
        // }

        // 람다식 ------
        // 람다식 : 메서드를 하나의 식으로 표현한 것. item -> 식 형태로 요소마다 실행할 코드를 전달함
        lists.stream().forEach(item->System.out.println(item));

    }
}
