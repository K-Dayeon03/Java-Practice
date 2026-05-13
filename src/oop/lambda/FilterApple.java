package oop.lambda;

import java.util.ArrayList;
import java.util.List;

public class FilterApple {
    public static List<Apple> filterGreenApple(List<Apple> basket){
        List<Apple> greenBasket = new ArrayList<>();
        for(Apple apple : basket){
            if(apple.getColor() == Color.GREEN){
                greenBasket.add(apple);
            }
        }
        return greenBasket;
    }
    /**
     * @ solution - try2: 색상을 파라미터화 하자!
     * @ problem - 만약 필터 기준이 색상이 아니라 무게라면?
     */
    public static List<Apple> filterAppleByColor(List<Apple> basket, Color color){
        List<Apple> filteredBasket = new ArrayList<>();
        for(Apple apple : basket){
            if(apple.getColor() == color){
                filteredBasket.add(apple);
            }
        }
        return filteredBasket;
    }
    /**
     * @solution - try3: 동작을 파라미터화 하면 해결된다!
     *              - 함수를 전달 받을 수 있다면?
     *              - 자바는 함수를 전달할 수 있는가?
     *                  -> 불가능하다. 자바의 함수는 일급 객체가 아닙니다.
     *                  -> 함수 개념이 아니라 객체에 소속된 메서드 개념.
     *              - 그런데 전달되는 함수가 고정되어 있는가?
     *                  -> 필터 조건에 따라 함수 내용이 달라야 한다.
     *                  -> 그러면 어떻게 함수 이름이 통일 되면서
     *                      다른 내용을 전달할 수 있을까?
     *                      -> 오버라이딩 (상속, 인터페이스)
     */

    public static List<Apple> filterApple(List<Apple> basket, ApplePredicate predicate) {
        List<Apple> filteLightBasket = new ArrayList<>();
        for (Apple apple : basket) {
            if (predicate.test(apple)) {
                filteLightBasket.add(apple);
            }

        }
        return filteLightBasket;
    }

    /**
     * problem - 이제는 Apple 리스트만 오는게 아니다!
     *           Integer도 오고, String도 필터링 해달라고 한다....
     *
     * solution - try4: 제네릭 필터 메서드 선언
     *
     * 리턴 타입 앞에 붙는 <T>는 이 메서드가 제네릭을 사용하는 메서드고, 지금부터 T라는 임시 타입을 선언한다.
     * T는 이 메서드가 호출될 때 결정 될거야.
     */

    public static <T> List<T> filter(List<T> basket, GenericPredicate <T> Predicate){

        List<T> filteredBasket = new ArrayList<>();
        for(T t : basket){
            if(Predicate.test(t)){
                filteredBasket.add(t);
            }
        }
        return filteredBasket;
    }


}
