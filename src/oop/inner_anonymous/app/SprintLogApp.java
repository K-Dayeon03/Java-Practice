package oop.inner_anonymous.app;

import oop.inner_anonymous.domain.*;
import oop.inner_anonymous.exception.InvalidActivityException;
import oop.inner_anonymous.printer.ActivityPrinter;
import oop.inner_anonymous.printer.ConsoleActivityPrinter;
import oop.inner_anonymous.service.ActivityDashboard;


public class SprintLogApp {
    public static void main(String[] args) {
        // ── 1. 기본 활동 목록 ──────────────────────────────────────────
        // boolean 대신 Visibility enum으로 공개 상태를 표현한다.
        LearningActivity[] activities = {
                new LectureLog("Java enum 기초", 50, Visibility.PUBLIC, "박코치"),
                new LectureLog("Java 내부 클래스", 70, Visibility.PUBLIC, "김선생"),
                new PracticeLog("예외 처리 실습", 80, Visibility.PUBLIC, 90),
                new PracticeLog("인터페이스 실습", 100, Visibility.PUBLIC, 85),
                new ReadingLog("객체지향의 사실과 오해", 35, Visibility.PRIVATE, "조영호")
        };
        //2. 정적 중첩 클래스 시연: Summary

        //Summary는 ActivityD    ashboard 객체 없이도 생성이 가능하지만, Summary가 의미있는 활성 객체 수를 가지게 하기 위해
        //dashboard.summarize()를 호출해서 리턴받음.
        ActivityDashboard dashboard = new ActivityDashboard(activities);
        ActivityDashboard.Summary summary = dashboard.summarize();

        System.out.println("=== 학습 요약 (정적 중첩 클래스: Summary) ===");
        System.out.println("총 활동 수  : " + summary.getTotalCount());
        System.out.println("강의        : " + summary.getLectureCount());
        System.out.println("실습        : " + summary.getPracticeCount());
        System.out.println("독서        : " + summary.getReadingCount());

        // ── 3. 멤버 내부 클래스 시연: ReportBuilder ──────────────────────
        // dashboard.new ReportBuilder(...) — 외부 인스턴스에 묶여서 생성된다.
        System.out.println();
        System.out.println("=== 기본 보고서 (멤버 내부 클래스: ReportBuilder) ===");
        ActivityPrinter consolePrinter = new ConsoleActivityPrinter();
        dashboard.new ReportBuilder(consolePrinter).print();


        // 4. 익명 클래스 시연 :ActivityPrinter 구현체 즉석 구현
        System.out.println();
        System.out.println("=== 간단 보고서 (익명 클래스: ActivityPrinter 구현체 즉석 구현) ===");
        ActivityPrinter compactPrinter = new ActivityPrinter() {
            @Override
            public void print(LearningActivity activity) {
                // 익명 클래스 안에서 activity의 public API를 자유롭게 사용한다.
                System.out.printf("  [%s] %s — %d분%n",
                        activity.getActivityType(),
                        activity.getTitle(),
                        activity.getMinutes());
            }

        };
        dashboard.new ReportBuilder(compactPrinter).print();
    }
}