package oop.enum_exception.domain;

import oop.enum_exception.Visibility;

public abstract class LearningActivity {

    private  static int totalCreateCount = 0;

    private final long id;
    private String title;
    private int minutes;
    private Visibility visibility;

    LearningActivity(String title, int minutes){
        this(title, minutes, Visibility.PUBLIC);
    }

    LearningActivity(String title, int minutes, Visibility visibility){
        totalCreateCount++;
        this.id = totalCreateCount;
        this.title = normalizeTitle(title); //method 재활용
        this.minutes = minutes;
        this.visibility = visibility;
    }

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
    private String normalizeTitle(String newTitle) {
        if(newTitle == null || newTitle.isBlank()){
            return "제목 없음";
        }
        return newTitle;
    }

    public void openToPublic(){
        this.visibility = Visibility.PUBLIC;
    }

    public void hideFromPublic(){
        this.visibility = Visibility.PRIVATE;
    }

    public abstract String getActivityType(); //강의, 실습, 독서

    public abstract String getDetailText(); //유형별 세부 정공


    public static int getTotalCreateCount() {
        return totalCreateCount;
    }

    public String getTitle() {
        return title;
    }

    public long getId() {
        return id;
    }
    public int getMinutes() {
        return minutes;
    }

    public boolean ispublicActivity() {
        return visibility == Visibility.PUBLIC;
    }


    public String getVisibilityText() {
        return this.visibility.getLabel();
    }

    public boolean isPublicActivity(){
        return visibility == Visibility.PUBLIC;
    }
}
