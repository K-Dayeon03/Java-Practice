package array;

import java.util.Arrays;

public class Array2D {
    public static void main(String[] args) {
        int [][] arr = new int[3][4];
        arr[1][1] = 100;
        //1차원은 arryas.toString()
        //2차원은 Arrays.deepToString()

        //배열은 선언할 때 각 인덱스 자리의 값이 비어 있지 않고
        //각 타입의 기본 값으로 초기화 된다.
        //기본값: 정수 0, 실수 0.0, 논리 false, 문자(공백), 기타 null
        System.out.println(Arrays.deepToString(arr));


        for(int[] a : arr){
            for(int i : a){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
