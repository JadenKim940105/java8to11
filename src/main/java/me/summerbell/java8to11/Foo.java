package me.summerbell.java8to11;

public class Foo {

    public static void main(String[] args) {

        // 익명 내부 클래스 anonymous inner class
        RunSomething runSomething = new RunSomething() {
            @Override
            public void doIt() {
                System.out.println("do something");
            }
        };

        runSomething.doIt();


        System.out.println(" =========== ");


        // RunSomething interface 는 functional interface 임으로 람다표현식을 활용할 수 있다.
        RunSomething runSomethingWithLamda = () -> System.out.println("do something");

        runSomethingWithLamda.doIt();

    }
}
