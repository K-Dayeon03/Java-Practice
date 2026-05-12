package oop.collection.service;

import oop.collection.domain.ActivityCategory;
import oop.collection.domain.LearningActivity;
import oop.collection.printer.ActivityPrinter;

import java.util.*;

public class ActivityDashboard {

    private final List<LearningActivity> activities;

    public ActivityDashboard(List<LearningActivity> activities) {
        if (activities == null) {
            throw new IllegalArgumentException("학습 활동 목록은 null일 수 없습니다.");
        }
        this.activities = activities;
    }

    /**
     * 카테고리별 활동 수를 세어 Summary를 만들자.
     */
    public Summary summarize() {

        // 로컬 클래스 선언: summarize() 밖에서는 사용할 수 없다.
        class Counter {
            private int totalCount;
            private int lectureCount;
            private int practiceCount;
            private int readingCount;

            void add(LearningActivity activity) {
                totalCount++;
                // getCategory()는 LearningActivity의 public API
                switch (activity.getCategory()) {
                    case LECTURE  -> lectureCount++;
                    case PRACTICE -> practiceCount++;
                    case READING  -> readingCount++;
                }
            }

            Summary toSummary() {
                return new Summary(totalCount, lectureCount, practiceCount, readingCount);
            }
        } // end Counter class

        Counter counter = new Counter();
        for (LearningActivity activity : activities) {
            counter.add(activity);
        }
        return counter.toSummary();

    } // end summarize()

    // 내부 클래스에 static을 붙이는 이유는 메모리 누수를 방지하고 독립성을 가지기 위해서 입니다.
    public static class Summary {

        private final int totalCount;
        private final int lectureCount;
        private final int practiceCount;
        private final int readingCount;

        public Summary(int totalCount, int lectureCount, int practiceCount, int readingCount) {
            this.totalCount = totalCount;
            this.lectureCount = lectureCount;
            this.practiceCount = practiceCount;
            this.readingCount = readingCount;
        }

        public int getTotalCount() {
            return totalCount;
        }

        public int getLectureCount() {
            return lectureCount;
        }

        public int getPracticeCount() {
            return practiceCount;
        }

        public int getReadingCount() {
            return readingCount;
        }
    }

    /**
     * 보고서 출력기
     * 외부 클래스(ActivityDashboard)가 가지고 있는 activities 배열에 접근해야 하기 때문에
     * static을 붙이지 않은 멤버 내부 클래스로 선언.
     */
    public class ReportBuilder {

        private final ActivityPrinter printer;

        public ReportBuilder(ActivityPrinter printer) {
            if (printer == null) {
                throw new IllegalArgumentException("출력 도구는 null일 수 없습니다.");
            }
            this.printer = printer;
        }

        public void print() {
            Summary summary = summarize();  // 외부 클래스의 summarize() 호출
            System.out.println("── 활동 수: 총 " + summary.getTotalCount()
                    + "개 (강의 " + summary.getLectureCount()
                    + " / 실습 " + summary.getPracticeCount()
                    + " / 독서 " + summary.getReadingCount() + ")");

            for (LearningActivity activity : activities) {  // 외부 클래스의 activities 접근
                printer.print(activity);
            }
        }
    }

    // 카테고리별 그룹화 -------------------------------------------------
    // 카테고리별로 활동(Log)을 그룹화해서 Map으로 반환한다.
    public Map<ActivityCategory, List<LearningActivity>> groupByCategory() {
        Map<ActivityCategory, List<LearningActivity>> result = new HashMap<>();
        for (LearningActivity activity : activities) {
            ActivityCategory cat = activity.getCategory();

            // 해당 카테고리가 Map에 없으면 빈 List를 먼저 만들어서 put한다.
            if (!result.containsKey(cat)) {
                result.put(cat, new ArrayList<>());
            }

            // 카테고리별 리스트를 얻어온 후 리스트에 활동 객체를 add 하자.
            List<LearningActivity> list = result.get(cat);
            list.add(activity);
        }
        return result;
    }


    // 태그 필터링-------------------------------------------------------

    public List<LearningActivity> filterByTag(String tag) {
        List<LearningActivity> result = new ArrayList<>();
        for (LearningActivity activity : activities) {
            if (activity.hasTag(tag)) {
                result.add(activity);
            }
        }
        return Collections.unmodifiableList(result);
    }

}
