package oop.stream;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static oop.stream.Menu.*;

public class Filtering {
    public static void main(String[] args) {
        //요리 메뉴 중 채식주의자가 먹을 수 있는 요리만 필터링
/*
       Stream<Dish> stream = MENU_LIST.stream();
       Stream<Dish> disStream = stream.filter(new Predicate<Dish>() {
           @Override
           public boolean test(Dish dish) {
               return dish.isVegetarian();
           }
       });
       List<Dish> dishList = disStream.toList();
       for(Dish dish : dishList){
           System.out.println(dish);
       }*/
        List<Dish> dishList = MENU_LIST.stream()
                .filter(Dish::isVegetarian)
                .toList();
        dishList.forEach(System.out::println);

        System.out.println("=========================");

        //메뉴목록 중에 육류이면서 6000칼로리 미만인 요리 필터링
        //메서드 체이닝:리턴된 결과물을 변수에 할당 없이 바로 호출하는 문법

        MENU_LIST.stream()
                .filter(dish -> dish.getType() == Dish.Type.MEAT
                        && dish.getCalories()< 600)
                .toList()
                .forEach(System.out::println);

        System.out.println("=========================");

        //메뉴 목록에서 요리 이름이 4글자인것만 필터링
        MENU_LIST.stream()
                .filter(dish -> dish.getName().length() == 4)
                .toList()
                .forEach(System.out::println);
        System.out.println("=========================");
        //칼로리가 300칼로리보다 큰 요리 중에 앞에 3개만
        MENU_LIST.stream()
                .filter(dish->dish.getCalories()>300)
                .limit(3)// 앞에서 3개
                .toList()
                .forEach(System.out::println);
        System.out.println("=========================");
        //칼로리가 300칼로리보다 큰 요리중에 앞에 두개 빼고 추출
        MENU_LIST.stream()
                .filter(dish->dish.getCalories()>300)
                .skip(2)//맨 앞 두개 빼고
                .toList()
                .forEach(System.out::println);
        System.out.println("=========================");
        //리스트에서 짝수만 필터링(중복은 제거해서)
        List<Integer> numbers = List.of(1,2,3,4,3,5,4,6,7,8,9,10);

        numbers.stream()
                .filter(n -> n%2 ==0)
                .distinct()
                .toList()
                .forEach(System.out::println);
    }
}
