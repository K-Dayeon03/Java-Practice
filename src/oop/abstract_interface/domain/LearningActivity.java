package oop.abstract_interface.domain;
public abstract class LearningActivity {

    private  static int totalCreateCount = 0;

    private final long id;
    private String title;
    private int minutes;
    private boolean publicActivity;

    LearningActivity(String title, int minutes){
        this(title, minutes, true);
    }

    LearningActivity(String title, int minutes, boolean publicActivity){
        totalCreateCount++;
        this.id = totalCreateCount;
        this.title = normalizeTitle(title); //method 재활용
        this.minutes = minutes;
        this.publicActivity = publicActivity;
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
        this.publicActivity = true;
    }

    public void hideFromPublic(){
        this.publicActivity = false;
    }

    //추상메서드는 메서드 바디가 없는 메서드의 틀 역할을 합니다.
    //특정 메서드는 부모가 대충 정해버리는 것보다, 바식이 반드시 자식 방식대로
    //추상메서드는 자식
    public abstract void printSummary();

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
        return publicActivity;
    }
}
