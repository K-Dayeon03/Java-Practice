package oop.inner_anonymous.domain;
//enum: 정해진 선택지를 코드의 타입으로 만드는 문법
//enum도 하나의 클래스
public enum Visibility {
    //아래 2개가 생성자 호출문
    PUBLIC("공개",true ),
    PRIVATE("비공개", false );

    private final String label;
    private final boolean shareable;

    //private 이런식으로 제한이 있으면, getter로
    Visibility(String label, boolean shareable) {
        this.label = label;
        this.shareable = shareable;
    }

    public String getLabel(){
        return label;
    }
    public boolean isShareable(){
        return shareable;
    }
}


