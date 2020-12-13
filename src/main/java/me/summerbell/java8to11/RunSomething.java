package me.summerbell.java8to11;

public interface RunSomething {

    void doIt();

    static void printName(){
        System.out.println("JaDeN");
    }

    default void defaultMethod(){

    }


}
