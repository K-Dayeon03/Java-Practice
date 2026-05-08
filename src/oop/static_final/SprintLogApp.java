package oop.static_final;

import java.util.Spliterator;

public class SprintLogApp {
    public static void main(String[] args) {
        LearningLog javaLog = new LearningLog("Java 시작",40); //생성자임
        LearningLog gitLog = new LearningLog("Git 복습",30,false); //생성자임
        LearningLog encapLog = new LearningLog("캡슐화 연습", 90);

        LearningLog [] logs = {javaLog, gitLog, encapLog};
        for(LearningLog log : logs){
            log.printSummary();
        }

        System.out.println("=======================================");


    }
}
