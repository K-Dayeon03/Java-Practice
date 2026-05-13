package oop.lambda;

import java.util.List;

import static oop.lambda.Color.*;

public class Main {
    public static void main(String[] args) {
        // 사과 바구니 생성

        // List.of -> 고정형 리스트 생성 (Arrays.asList와 유사)
        List<Apple> appleBasket = List.of(
                new Apple(80, GREEN)
                , new Apple(155, GREEN)
                , new Apple(120, RED)
                , new Apple(97, RED)
                , new Apple(200, GREEN)
                , new Apple(50, RED)
                , new Apple(85, YELLOW)
                , new Apple(75, YELLOW)
        );

        System.out.println("======== 녹색 사과만 필터링 ========");
        List<Apple> greenApples = FilterApple.filterGreenApple(appleBasket);
        for(Apple greenApple : greenApples){
            System.out.println(greenApple);
        }

        System.out.println("======== 원하는 색상의 사과만 필터링 ========");
        List<Apple> redApples = FilterApple.filterAppleByColor(appleBasket, RED);
        for(Apple redApple : redApples){
            System.out.println(redApple);
        }

        System.out.println("======== 원하는 무게의 사과만 필터링 ========");
        List<Apple> lightApples = FilterApple.filterApple(appleBasket, new LightApplePredicate());
        for(Apple apple : lightApples){
            System.out.println(apple);
        }

        //빨강 또는 노랑 사과만 필터링
        //클래스 또 만들긴 귀찮다.
        //메서드 호출할 때, 이름 없는 클래스를 즉석에서 만들면 안되나? -> 익명 클래스
        System.out.println("======== 원하는 다중 색상 사과만 필터링 ========");
        List<Apple> apples =   FilterApple.filterApple(appleBasket, new ApplePredicate() {

            @Override
            public boolean test(Apple apple) {
                return apple.getColor() == RED || apple.getColor() == YELLOW;
            }
        });
        for(Apple apple : apples){
            System.out.println(apple);
        }

        // 녹색이면서 100g 이하인 사과만 필터링
        // 우리는 이제 익명클래스를 통해, 새 클래스 파일 생성 없이 즉석에서 보낼 수 있다!
        // 근데... 어짜피 인터페이스에 추상메서드 하나 아니냐?
        // 그럼 이름을 굳이 언급할 필요 있나? -> 람다식 쓰자!
        // 람다 표현식을 사용하는 방식
        System.out.println("======== 원하는 무게와 사과 색상 사과만 필터링1 ========");
        //자세하게 (Apple apple) -> {return apple.getColor() == GREEN && apple.getWeight() < 100;}
        //람다식은 구현하고자 하는 인터페이스가 추상메서드를 딱 하나만 가질 때만 사용할 수 있음.
        //람다식을 이용해서 메서드를 오버라이딩 할 때, 메서드의 내용이 단 한줄이고, 그 한줄이 return문이라면
        //중괄호(메서드 바디)와 return키워드를 생략할 수 있습니다.
        List<Apple> appleLambdas = FilterApple.filterApple(appleBasket,
                (Apple apple) -> apple.getColor() == GREEN && apple.getWeight() < 100);
        for(Apple apple : appleLambdas){
            System.out.println(apple);
        }
        System.out.println("======== 원하는 무게와 사과 색상 사과만 필터링2 ========");
        //색깔이 빨강 혹은 초록이면서, 무게는 150 미만
        //논리연산에서 and가 or보다 우선입니다.
        List<Apple> appleLambdas2 = FilterApple.filterApple(appleBasket,
                (Apple apple) ->( apple.getColor() == RED
                        || apple.getColor() == GREEN )
                        && apple.getWeight() > 150);
        for(Apple apple : appleLambdas2){
            System.out.println(apple);
        }
        System.out.println("======== 사과가 아닌 여러가지 객체를 필터링 ========");
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
       List<Integer> filters =  FilterApple.filter(numbers,n-> n%2 == 0);
        System.out.println(filters);

        List<String> foods = List.of("짜장면","짬뽕","탕수육","피자","삼겹살","파스타");
        List<String> filters2 = FilterApple.filter(foods,f-> f.length() == 3);
        System.out.println(filters2);

        List<Color> colorList = MappingApple.mappingAppleByColor(appleBasket);
        System.out.println("colorList = "+colorList);

        //그럼 이번엔 사과의 무게만 뽑아봐
        //내가 나중에 사과 리스트 말고 다른 리스트를 줄수도 있어
        List<Integer> map1 = MappingApple.map(appleBasket, new GenericFunction<Apple, Integer>() {
            @Override
            public Integer apply(Apple apple) {
                return apple.getWeight();
            }
        });
        System.out.println("map1 = " + map1);
        System.out.println("============================");
        //숫자 리스트를 주면 제곱된 수를 가져와
        List<Integer> map2 = MappingApple.map(numbers, n -> (int) Math.pow(n,4));
        System.out.println("map2 = "+map2);

        //음식 리스트를 주면 첫글자만
        System.out.println("============================");
        List<Character> map3 = MappingApple.map(foods,  f -> f.charAt(0));
        System.out.println("map3 = "+map3);

    }


}
