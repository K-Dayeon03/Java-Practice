package oop.stream;

import java.util.Arrays;
import java.util.List;

import static oop.stream.Menu.MENU_LIST;

// map : 리스트(collection)에서 원하는 데이터만 추출
// original : [ {}, {}, {}, {}, {} ]
// filter   : [ {}, {}, {} ]
// map      : [ "", "", "", "", "" ]
public class Mapping {
    public static void main(String[] args) {
        // toList(): 자바 16부터 쓸 수 있음. 불변 리스트 -> 수정 안됨!
        // collect(Collectors.toList()): 자바 8부터 존재하던 방식 -> 수정 자유로움
        List<String> nameList = MENU_LIST.stream()
                .map(dish -> dish.getName())
                .toList();

        System.out.println("nameList = "+nameList);

        System.out.println("=========================");


        List<String> browsers =List.of("safari","chrome","ms edge","firefox","opera");

        //문자열 길이만 추출
        List<Integer> list = browsers.stream()
                .map(b->b.length())
                .toList();
        System.out.println("list = "+list);

        //대문자 변환

        List<Integer> list2 = browsers.stream()
                .map(b-> (int) b.toUpperCase().charAt(0))
                .toList();
        System.out.println("list2 = "+list2);

        //메뉴 목록에서 메뉴 이름과 칼로리만 추출해서
        List<SimpleDish> simpleDishes = MENU_LIST.stream()
                .map(dish -> new SimpleDish(dish))
                .toList();
        simpleDishes.forEach(System.out::println);
        System.out.println("=========================");
        /*
            메뉴 목록에서 칼로리가 500칼로리보다 큰
            음식들을 필터링한 다음에 음식의 이름과 타입만
            추출해서 출력해주세요. -> DishDetail이라는 객체로 맵핑
            단, 타입은 MEAT의 경우 육류라고 저장
            FISH는 어류라고 저장, OTHER는 기타라고 저장
         */

        MENU_LIST.stream()
                .filter(dish -> dish.getCalories()>500)
                .map(DishDetail::new)
                .toList()
                .forEach(System.out::println);
        System.out.println("=========================");
        //메뉴 목록에 있는 요리들의 총 칼로리 구하기
        int sum = MENU_LIST.stream()
                .mapToInt(Dish::getCalories)
                .sum();
        System.out.println("sum = "+sum);
        System.out.println("=========================");
        //육류 메뉴의 평균 칼로리 구하기
        double meatAvgCal =  MENU_LIST.stream()
                .filter(dish -> dish.getType() == Dish.Type.MEAT)
                .mapToInt(Dish::getCalories)
                .average().getAsDouble();
        System.out.printf("meatAvgCal = %.2f\n", meatAvgCal);
        System.out.println("=========================");

        // 모든 요리 이름에 포함된 알파벳을 중복 없이 추출.
        // flatMap: map처럼 변환을 하긴 하는데, 그 결과는 반드시 stream 이어야 한다.
        // 여러개의 스트림을 단일 스트림으로 합쳐줍니다.

        List<String> stringList = MENU_LIST.stream()
                .map(dish -> dish.getName().split(""))
                .flatMap(arr -> Arrays.stream(arr)) //각각의 배열 스트림을 하나의 스트림을 통합
                .filter(s->!s.isBlank()) //각각의 단일 문자 중 공백을 제거하는 행위
                .distinct()
                .toList();
        System.out.println("StringList = "+stringList);
        System.out.println("=========================");
    }
}
