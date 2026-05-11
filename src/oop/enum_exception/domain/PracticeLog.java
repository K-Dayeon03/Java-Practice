package oop.enum_exception.domain;

import oop.enum_exception.policy.Reviewable;
import oop.enum_exception.policy.Shareable;

//학습기록
public class PracticeLog extends LearningActivity implements Reviewable, Shareable {
    private int completionRate; //practiceLog만 가지는 고유한 필드
    public PracticeLog(String title, int minutes, Visibility visibility, int completionRate) {
        super(title, minutes, Visibility.PUBLIC, ActivityCategory.PRACTICE);
        this.completionRate = normalizeCompletionRate(completionRate);
    }


    @Override
    public boolean needsReview() {
        return  getCategory().isShortStudy( getMinutes(  )) || completionRate < 70;
    }

    @Override
    public void printReviewTarget() {
        System.out.println("[복습 권장]" + getTitle() + "(완료율:"+completionRate+"%)");
    }

    public int getCompletionRate() {
        return completionRate;
    }

    private int normalizeCompletionRate(int completionRate){
        if(completionRate < 0 ){
            return 0;
        }
        if(completionRate > 100){
            return 100;
        }
        return completionRate;
    }

    @Override
    public boolean canShare() {
        return ispublicActivity();
    }

    @Override
    public String getShareTitle() {
        return getTitle();
    }

    @Override
    public String getActivityType() {
        return "실습";
    }

    @Override
    public String getDetailText() {
        return "완료율 : "+" "+completionRate+"%";
    }
}
