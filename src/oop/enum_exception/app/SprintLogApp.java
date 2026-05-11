package oop.enum_exception.app;

import oop.enum_exception.Visibility;
import oop.enum_exception.domain.LearningActivity;
import oop.enum_exception.domain.LectureLog;
import oop.enum_exception.domain.PracticeLog;
import oop.enum_exception.domain.ReadingLog;
import oop.enum_exception.policy.Reviewable;
import oop.enum_exception.policy.Shareable;
import oop.enum_exception.printer.ActivityPrinter;
import oop.enum_exception.printer.CompactActivityPrinter;

public class SprintLogApp {
    public static void main(String[] args) {
        LectureLog javaLecture = new LectureLog("Java 객체지향", 50, Visibility.PUBLIC, "박코치");
        PracticeLog gitPractice = new PracticeLog("Git 브랜치 실습", 70, Visibility.PUBLIC, 80);
        PracticeLog oopPractice = new PracticeLog("캡슐화 리팩터링", 40, Visibility.PRIVATE, 45);
        ReadingLog oopBook = new ReadingLog("객체지향의 사실과 오해", 35, Visibility.PUBLIC, "객체지향의 사실과 오해");

        //추상 클래스는 스스로의 객체를 생성할 수 없고, 자식에 의해서 생성될 뿐입니다.
        //LearningActivity act = new LearningActivity("test",10);
        LearningActivity[] activities = {javaLecture, gitPractice, oopPractice, oopBook};

        ActivityPrinter printer = new CompactActivityPrinter(); //인터페이스를 적용해서 간단한 출력함
        System.out.println("=== 간단 학 활동 목록 ===");
        for (int i = 0; i < activities.length; i++) {
            printer.print(activities[i]);
        }
        //다형성이란 부모 타입의 변수에 자식 타입의 객체가 들어올 수 있다는 것, 곧 상속 관계 하에서만 발생한다.
        //인터페이스 구현 관계도 다형성 발생이 가능합니다.

        Reviewable[] reviewables = {javaLecture, gitPractice, oopPractice, oopBook};
        System.out.println();
        System.out.println("==== 복습 필요 활동 ====");
        for(Reviewable reviewable : reviewables){
            if(reviewable.needsReview()){
                reviewable.printReviewTarget();
            }
        }
        Shareable[] shareables = {javaLecture, gitPractice, oopPractice, oopBook};
        System.out.println();
        System.out.println("==== 공유 가능한 활동 ====");
        for(Shareable shareable : shareables){
            if(shareable.canShare()){
                System.out.println(shareable.getShareTitle());
            }
        }
    }
}