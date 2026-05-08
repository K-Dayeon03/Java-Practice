package oop.access_modifier;

public class SprintLogApp {
    public static void main(String[] args) {
        LearningLog javaLog = new LearningLog("Java 시작",40); //생성자임
        LearningLog gitLog = new LearningLog("Git 복습",30,false); //생성자임

//        javaLog.title = "야호;";
//        javaLog.minutes = 84;
//        javaLog.publicLog = false; 모든 필드가 private 접근 제한자로 지정되서 오류남

        javaLog.extendStudy(200);
        javaLog.changeTitle("Java 객체지향과 캡슐화");
        javaLog.hideFromPublic();


        gitLog.extendStudy(45);
        gitLog.openToPublic();

        javaLog.printSummary();
        gitLog.printSummary();

    }
}
