package oop.constructor;
public class LearningLog {

    String title;
    int minutes;
    boolean publicLog;

    //생성자 클래스의 이름과 대/소문자까지 완전히 일치해야한다.
    //그리고 메서드와 달리 리턴 타입이 존재하지 않는다.
    LearningLog(){
        System.out.println("기본 생성자 호출!");
    }
    //생성자 오버로딩
    //이름이 동일하기 때문에 전달하는 값의 개수, 순서, 탕입을 다르게 작성해야 중복선언을 인정.
    LearningLog(String title, int minutes){
        //this ()문법으로 자기 자신의 다른 생성자를 호출하는 것이 가능하다.
        this(title, minutes, true);
    }
    //생성자는 메서드처럼 매개값을 전달 받을 수 있다.
    //전달 받은 값을 이용해서 필드를 초기화 할 수 있다.
    LearningLog(String title, int minutes, boolean publicLog){
        //this는 현재 객체 자기 자신을 뜻한다.
        //생성자에서의 this는 곧 지금 생성자에 의해 생성되고 있는 그 객체를 의미
        //필드와 생성자의 매개변수 이름이 동일할 경우 this를 통해 구분을 지어 줘야한다.
        this.title = title;
        this.minutes = minutes;
        this.publicLog = publicLog;
    }


    void printSummary(){
        System.out.println(title + "-" + minutes + "분");
    }

    boolean needsReview(){
        return minutes < 60;
    }
}
