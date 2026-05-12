package oop.inner_anonymous.printer;

import oop.inner_anonymous.domain.LearningActivity;

public interface ActivityPrinter {

    void print(LearningActivity activity); //자식들 모두 전달 받고 싶으면 부모 타입

}
