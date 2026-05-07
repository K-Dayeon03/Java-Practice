package oop.intro;

//객체 생성을 위한 설계도 클래스에는 메인 메서드를 작성하지 않는다.
public class LearningLog {
    //객체의 속성을 필드라고 합니다. 또는 멤버변수라고도 한다.
    String title;
    int minutes;
    boolean publicLog;

    //간단하게 요약
    void printSummary(){
        System.out.println(title + "-" + minutes + "분");
    }

    //60분 미만이냐 아니냐
    boolean needsReview(){
        return minutes < 60;
    }
}