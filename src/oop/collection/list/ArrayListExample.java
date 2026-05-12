package oop.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        //String [] arr = new String[50]으로 하는 거보다

        //<> -> 제네릭(타입의 형식을 지정하여 타입 안정성을 꾀하기 위한 문법
        //ArrayList이름은 원하는 네임으로 가능
        List<String> nick = new ArrayList<>(); //collection
        //add(객체):리스트에 객체를 추가하는 메서드
        nick.add("멍멍이");
        String str = "야옹이";
        nick.add(str);
        nick.add("짹짹이");
        nick.add("개구리");
        System.out.println("nick = "+ nick);
        //add(인덱스, 객체) : 원한느 위치에 객체 삽입
        //중복 허용(단, 매개변수의 타입, 인수, 이름이 다르던지 하나씩 다르게하면 가능)
        //오버로딩 적용
        nick.add(3,"어흥이");
        System.out.println("nick = "+ nick);

        //get(인덱스) : 리스트 내부의 객체를 참조
        String name = nick.get(3);
        System.out.println("name = "+ name);
        System.out.println("nick.size() = "+ nick.size());

        //set(인덱스, 수정할 객체) : 리스트 내부의 객체를 수정
        nick.set(2,"삐약이");
        System.out.println("nick = "+ nick);

        //특정 위치 선택 가능
        for(int i = 0; i< nick.size(); i++){
            System.out.println(nick.get(i));
        }

        System.out.println("--------");

        //for - each
        //처음부터 끝까지
        for(String n : nick){
            System.out.println(n);
        }

        //contains(객체) : 리스트 내의 객체의 존재 유무를 파악

        System.out.println(nick.contains("메뚜기"));

        //indexOf(객체):특정 객체의 인덱스 탐색, 없다면 -1
        int idx = nick.indexOf("짹짹이");
        System.out.println("idx = "+ idx);
        //remove (객체 or 인덱스) : 리스트 내부 객체 삭제
        nick.remove("삐약이");
        nick.remove(0);

        System.out.println("nick = "+ nick);

        nick.clear();
        System.out.println("nick = "+ nick);


        //isEmpty() : 리스트가 비어있는지의 여부확인
        System.out.println("nick.isEmpty() = "+ nick.isEmpty());

        System.out.println("=========");

        /*
        # 컬렉션 객체들은 Collections의 기능을 사용할 수 있다.
        Conllections 는 컬렉션 객체들의 부가 기능을 제고
        * */

        //객체 타입잉어야한다.
        //기본 데이터 타입은 그냥 못쓰고, 기본 데이터 타입이ㅡ 객체 타임을 명시해야된다
        List <Integer> score = new ArrayList<>();
        score.add(90);

        /*
        Collections.addAll: 이미 만들어진 컬렉션에 여러 요소를 추가하는 메서드

        Arrays.asList: add, remove 불가. set()으로 요소 변경은 가능. null 요소 허용
        List.of: add, remove, set 불가. null 요소 불허. (java 9버전)
         */

        List<Integer> integerList1 = List.of(1,2,3,4,4,55,6,5);
        List<Integer> integerList2 = Arrays.asList(1,2,5,4,6,6,7,7,8);
        Collections.addAll(score, 80, 70, 60,100,47,21,100,99);
        System.out.println("score = "+ score);

        //컬렉션 내의 객체의 개수 구하기
        System.out.println("100점 학생 수: "+ Collections.frequency(score, 100));

        //최댓값, 최솟값
        System.out.println("최댓값: "+ Collections.max(score));
        System.out.println("최솟값: "+ Collections.min(score));

        //정렬(오름차)
        Collections.sort(score);
        System.out.println("score = "+ score);

//        Collections.reverse(score); 단순 역순 배치(정렬은 아니다)
        Collections.sort(score, Collections.reverseOrder()); //내림차 정렬
        System.out.println("score = "+ score);

        //두 요소의 위치를 서로 교체 swap(list, i, j)
        Collections.swap(score, 3, 7);
        System.out.println("score = "+ score);

        //리스트 내의 요소를 무작위로 섞기
        Collections.shuffle(score);
        System.out.println("score = "+ score);

        //원하는 객체로 컬렉션을 전부 초기화
        Collections.fill(score, 100);
        System.out.println("score = "+ score);
    }
}
