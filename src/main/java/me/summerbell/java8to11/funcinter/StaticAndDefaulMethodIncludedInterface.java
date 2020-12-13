package me.summerbell.java8to11.funcinter;

public interface StaticAndDefaulMethodIncludedInterface {

    void doSomething();

    static void printName(){
        System.out.println("JaDeN");
    }

    default void defaultMethod(){};

}
