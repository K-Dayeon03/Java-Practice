package oop.enum_exception.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatchExample2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] arr = new int[5];
        try {
            System.out.printf("정수: ");
            sc.nextInt();
            int n = sc.nextInt();
            int result = 100 / n;

            System.out.println(arr[result]);
            String s = null;
            s.equals("메롱");
        } catch (InputMismatchException e) {
            System.out.println("정수를 입력하세요!");
        } catch (ArithmeticException e) {
            System.out.println("0으로 나누시면 안돼요!");
        } catch (NullPointerException e) {
            System.out.println("객체의 주소 대신에 null을 참조하면 안됩니다!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("인덱스 범위를 벗어났어요!");
        } catch (Exception e) {
            System.out.println("예상치 못한 예외 발생!");
        } finally {
            sc.close();
        }
    }
}
