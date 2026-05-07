package oop.constructor;

public class SprintLogApp {
    public static void main(String[] args) {
        LearningLog javaLog = new LearningLog("Java 시작",40); //생성자임
        LearningLog gitLog = new LearningLog("Git 복습",30,false); //생성자임
        LearningLog conditionLog = new LearningLog("조건문 학습",75); //생성자임
        LearningLog loopLog = new LearningLog("반복문 학습",120); //생성자임
        LearningLog[] logs = {javaLog, gitLog, conditionLog, loopLog};

        System.out.println("===== 생성자로 만든 학습 기록 =====");
        for(LearningLog log : logs){
            log.printSummary();
        }
    }
}
