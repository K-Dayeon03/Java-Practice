package oop.lambda;

@FunctionalInterface
public interface GenericPredicate<T> {
    //만들 때 정해질 거야~
    boolean test(T tj);
}
