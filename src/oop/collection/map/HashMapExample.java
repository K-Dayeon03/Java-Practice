package oop.collection.map;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
                /*
        # Map
        - Key / Value가 한 세트를 이루는 자료구조
        - Key값을 통해 Value를 참조하는 방식 (인덱스 x)
        - Key는 중복 저장을 허용하지 않는다.
         */

        // Map은 Key, Value 쌍을 이루기 때문에 멀티 제네릭을 선언.
        Map<String, String> map = new HashMap<>();

        map.put("멍멍이", "홍길동"); //1
        map.put("야옹이", "김철수"); //2
        map.put("짹짹이", "박영희") ; //3

        //key를 중복 사용해서 put을 호출하면 기존 key에 맵핑된 value가 수정됩니다.
        System.out.println("map = "+ map);
        map.put("멍멍이", "김춘식");
        map.put("어흥이", "홍길동"); //value 중복 -> 영향 x
        System.out.println("map = "+ map);

        //key의 존재 유무를 확인
        //value 얻기 : get(key)
        String nick = "메뚜기";
        if(map.containsKey(nick)){
            System.out.printf("별명이 %s인 학생의 이름은 %s입니다.\n", nick, map.get(nick));
        } else {
            System.out.println("그런 별명은 없다.");
        }

        //Map에서 key들만 추출하는 메서드 keyset()
        //모든 key를 set에 담아서 반환합니다.-> 향상 for문 사용가능
        for(String k : map.keySet()){
            System.out.printf("key: %s, value: %s\n", k, map.get(k));
        }

        System.out.println("=========================");

        //entrySet() 메서드는 key와 value를 하나의 묶음(Map.Entry)으로 취급하고
        //그 묶음들을 set으로 담아서 전달합니다.
        for(Map.Entry<String, String> entry : map.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.printf("key: %s, value: %s\n", key, value);
        }

        System.out.println("=========================");

        //Map의 객체 삭제: remove(key)
        map.remove("야옹이");
        System.out.println("map = "+ map);

        map.clear();
    }
}
