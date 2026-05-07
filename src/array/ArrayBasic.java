package array;


import java.util.Arrays;

public class ArrayBasic {
    public static void main(String[] args) {
        int [] numbers = new int[5]; // members = new int[5];

        //배열 내부 초기화
        numbers[0] = 50;
        numbers[1] = 77;
        numbers[2] = (int) 3.14; //double을 int로 변환해서 값을 할당하면 소수점이 탈락된다.
        numbers[3] = numbers[0]+20;
        numbers[4] = 100;

        //배열의 길이
        System.out.println("배열의 길이: "+ numbers.length);
        //배열의 순회
        for(int i = 0; i<numbers.length; i++){
            System.out.println((i+1)+"번째 값: "+numbers[i]);
        }

        System.out.println("==============================");

        //배열의 순회 forEach(향상된 for)
        //n의 배열의 값들이 하나씩 전달되는 것이다.
        //범위를 조정할 수가 없다.
        //무조건 범위는 배열의 처음부터 끝까지로 설정되고, 중간의 break나 continue는 가능하다.
        for( int n : numbers){
            System.out.println(n);
        }

        System.out.println(numbers);

        //배열 내부를 문자열 형태로 한번에 출력하기
        System.out.println(Arrays.toString(numbers));

        //배열 쉽게 초기화하기
        int [] pointList = {10,20,30,40};
        //위에 처럼 초기화하면 크기가 고정되서 수정이 힘들다.

        //수정하고 싶다하면은 배열을 새로 만들어거 값을 옮겨야한다.
        pointList = new int[]{45,50,55}; //새로운 배열을 하고 추가해줘야함

    }
}
