package oop.stream;

public class DishDetail {
    private final String dishName;
    private final String Type;


    public DishDetail(Dish dish) {
        this.dishName = dish.getName();
        Type = dish.getType().getDesc();
    }

    @Override
    public String toString() {
        return "DishDetail{" +
                "dishName='" + dishName + '\'' +
                ", Type='" + Type + '\'' +
                '}';
    }
}
