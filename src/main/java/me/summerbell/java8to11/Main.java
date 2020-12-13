package me.summerbell.java8to11;

import java.util.function.Function;

public class Main {


    public static void main(String[] args) {

        Function<Integer, Integer> plus10 = (number) -> number+10;

        Function<Integer, Integer> multiplyBy2 = (i) -> i*2;

        Function<Integer, Integer> multiplyBy2AndPlus10 = plus10.compose(multiplyBy2);

        System.out.println(plus10.apply(10));

        System.out.println(plus10.apply(multiplyBy2.apply(2)));


        System.out.println(plus10.compose(multiplyBy2).apply(2));

        System.out.println(multiplyBy2AndPlus10.apply(2));
    }
}
