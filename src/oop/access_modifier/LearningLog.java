package oop.access_modifier;

import java.text.Normalizer;

public class LearningLog {

    //접근 제한자를 활용한 정보 은닉과 캡슐화 (information hiding, encapsulation)
    //1. 필드에 private 접근 제한을 붙여 외부에서의 직접적인 접근을 허용하지 않게 막습니다.
    private String title;
    private int minutes;
    private boolean publicLog;


    LearningLog(){
        System.out.println("기본 생성자 호출!");
    }

    LearningLog(String title, int minutes){
        this(title, minutes, true);
    }

    LearningLog(String title, int minutes, boolean publicLog){
        this.title = normalizeTitle(title); //method 재활용
        this.minutes = minutes;
        this.publicLog = publicLog;
    }

    //private 접근 제한을 지정하니까, 제대로된값도 수정이 불가능한 것을 확인
    //필드 값을 대신 받아서 할당하고, 값을 돌려줄 수 있는 메서드를 활용해서 값을 보호
    //이때 사용하는 메서드의 이름을 getter,setter라고 한다.
    //set + 필드 이름으로 짓는 것이 관례
    //값을 셋팅한다라는 의미로 값을 전달하는 메서드
    
    public void extendStudy(int minutes){
        if(minutes <= 0){
            System.out.println("잘못된 공부 시간입니다.");
            return; //void 메서드에서 return은 메서드를 강제 종료합니다.
        }
        this.minutes += minutes;
    }
    
    public void changeTitle(String newTitle){
        this.title = normalizeTitle(newTitle);
    }
    //외부에 굳이 노출할 필요없어서 메소드로 접근제한을 걸어버린다.
    //내부의 로직을 숨기는 것
    //이 클래스 안에서만 사용할 수 있도록 범위를 지정
    private String normalizeTitle(String newTitle) {
        if(newTitle == null || newTitle.isBlank()){
            return "제목 없음";
        }
        return newTitle;
    }

    public void openToPublic(){
        this.publicLog = true;
    }

    public void hideFromPublic(){
        this.publicLog = false;
    }

    void printSummary(){
        //삼항연산식 조건식의 결과에 따라 변수에 대이할 값을 다르게 할 수 있는 문법
        //논리형 조건식 ? 좌항 : 우항
        //논리형 조건식이 true라면 좌항의 값이 false라면 우항의 값이 도출된다.
        String visibility = publicLog ? "공개" : "비공개";
        System.out.println(title + "-" + minutes + "분");
    }

    boolean needsReview(){
        return minutes < 60;
    }


    //값을 얻게하자
    //외부로 필드값을 돌려주는 getter메서드
    //get+필드 이름으로 지어주는 것이 관례. boolean 타입의 값을 돌려주는 getter는 is로 시작하도록 이름을 짓는다.

    public String getTitle() {
        return title;
    }

    public int getMinutes() {
        return minutes;
    }
    //boolean getPublicLog() {
    //    return publicLog;
    //} 불린타임은 get으로 시작이 아니라, is로 시작한다.
    public boolean isPublicLog() {
        return publicLog;
    }
}
