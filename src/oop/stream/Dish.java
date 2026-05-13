package oop.stream;

public class Dish {
    //final이 있어서 setter은 필요없다.
    private final String name; // 요리이름
    private final boolean vegetarian; // 채식음식 여부
    private final int calories; // 칼로리
    private final Type type;

    //enum 다른 클래스 외부에서도 사용 안하면 한 클래스 내에 작성해도 된다.
    public enum Type {
        MEAT("육류"), FISH("어류"), OTHER("기타");

        private final String desc;

        Type(String desc) {
            this.desc = desc;
        }

        public String getDesc() {
            return desc;
        }
    }

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", vegetarian=" + vegetarian +
                ", calories=" + calories +
                ", type=" + type +
                '}';
    }
}
