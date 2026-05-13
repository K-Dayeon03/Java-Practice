package oop.stream;


import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.Comparator.reverseOrder;
import static oop.stream.Menu.MENU_LIST;

public class Sorting {
    public static void main(String[] args) {
        //육류 요리 중 칼로리가 낮은 순으로 정렬하기
        List<Dish> meatAsc =  MENU_LIST.stream()
                .filter(dish-> dish.getType() == Dish.Type.MEAT)
                .sorted(comparing(Dish::getCalories))
                .toList();

        meatAsc.forEach(System.out::println);

        System.out.println("==============");
        //전체 메뉴들을 이름 내림차로 정렬(zxy)

        List<Dish> meatDesc =  MENU_LIST.stream()
                .sorted(comparing(Dish::getName).reversed())
                .toList();

        meatDesc.forEach(System.out::println);

        System.out.println("==============");

        //300칼로리 이상인 요리 중 칼로리가 낮은 탑 3 요리를 필터링
        List<Dish> meatLimit = MENU_LIST.stream()
                .filter(dish-> dish.getCalories()>=300)
                //칼로리 오름차순, 칼로리가 같다면 이름 내림차순
                .sorted(comparing(Dish::getCalories).thenComparing(Dish::getName, reverseOrder()))
                .limit(3)
                .toList();
        meatLimit.forEach(System.out::println);



    }
}
