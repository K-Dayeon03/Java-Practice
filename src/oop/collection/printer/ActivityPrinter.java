package oop.collection.printer;

import oop.collection.domain.LearningActivity;

public interface ActivityPrinter {

    void print(LearningActivity activity); //자식들 모두 전달 받고 싶으면 부모 타입

}
