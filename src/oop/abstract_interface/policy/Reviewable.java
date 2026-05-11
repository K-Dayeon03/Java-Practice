package oop.abstract_interface.policy;

//인터페이스는 스스로의 객체를 생성할 수 없는 추상적인 의미를 가지고 있다.
// 각걱의 클래스들에게 역할을 부여하는 클래스의 틀 역할을 합니다.
//"이 역할을 가진 객체는 이런 메서드를 제공해야한다."라는 약속
public interface Reviewable {
    //인터페이스에 변수를 선언하면 상수 취급한다. 필드가 아니다.
    boolean needsReview();

    void printReviewTarget();

    //void method1(){} x 인터페이는 메서드를 가질 수 없고, 오직 추상메서드만 가능하다.

}
