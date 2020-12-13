package me.summerbell.java8to11.java_util_function;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.function.*;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("java.util.function 패키지 ")
public class Java_util_function_Test {

    @Nested
    @DisplayName("Function<T,R> 인터페이스")
    class FucntionT{
        @Test
        @DisplayName("Function<T,R> 인터페이스 테스트")
        void testFunctionInterface(){

            // Integer 를 입력값으로 함수를 수행 후 Double return
            Function<Integer, Double> func = (i) -> {
                return Double.valueOf(i);
            };

            assertThat(func.apply(10)).isEqualTo(Double.valueOf(10));
        }

        @Test
        @DisplayName("Function<T,R> 의 apply(), compose(), andThen()")
        void funcIntCompose(){

            Function<Integer, Integer> plus10 = (i) -> i+10;
            Function<Integer, Integer> multiplyBy2 = (i) -> i * 2;

            assertThat(plus10.apply(2)).isEqualTo(12);
            assertThat(multiplyBy2.apply(2)).isEqualTo(4);

            // input 받은 2를 multiplyBy2 의 입력값으로 multiplyBy2 함수를 수행한 후, 그 결과값을 plus10의 입력값으로 하여 함수를 수행
            assertThat(plus10.compose(multiplyBy2).apply(2)).isEqualTo(14);

            // input 받은 2를 수행한 결과값을 multiplyBy2 함수의 input 으로 하여 multiplyBy2 수행
            assertThat(plus10.andThen(multiplyBy2).apply(2)).isEqualTo(24);
        }
    }

    @Nested
    @DisplayName("BiFunction<T, U, R> 인터페이스")
    class BiFunctionT{

        @Test
        @DisplayName("BiFunction<T, U, R> 의 apply()")
        void biFunctionApply(){

            BiFunction<String, String, String> stringConcat = (s1, s2) -> s1+s2;

            assertThat(stringConcat.apply("hello", " world")).isEqualTo("hello world");
        }

        @Test
        @DisplayName("BiFunction<T, U, R> 의 andThen()")
        void biFunctionAndThe(){

            BiFunction<String, String, String> stringConcat = (s1, s2) -> s1+s2;
            Function<String, String> stringConcat2 = (s) -> s + " !!!";

            assertThat(stringConcat.andThen(stringConcat2).apply("hello", " world")).isEqualTo("hello world !!!");
        }
    }

    @Nested
    @DisplayName("Consumer<T> 인터페이스")
    class ConsumerT{
        @Test
        @DisplayName("Consumer<T> 인터페이스 테스트")
        void consumerTest(){

            Consumer<String> HelloToName = (name) -> System.out.println("Hello " + name);

            HelloToName.accept("jaden");

        }

        @Test
        @DisplayName("Consumer<T> 의 andThen()")
        void consumerAndThen() {

            Consumer<String> HelloToName = (name) -> System.out.println("Hello " + name);
            Consumer<String> ByeToName = (name) -> System.out.println("Bye " + name);

            HelloToName.andThen(ByeToName).accept("jaden");
        }

    }

    @Nested
    @DisplayName("Supplier<T> 인터페이스")
    class SupplierT{

        @Test
        @DisplayName("Supplier<T> 의 get()")
        void supplierTest(){

            String expectedToSupplied = "supply this!";

            Supplier<String> supplier = () -> expectedToSupplied;

            assertThat(supplier.get()).isEqualTo(expectedToSupplied);

        }
    }

    @Nested
    @DisplayName("Predicate<T> 인터페이스")
    class PredicateT{

        @Test
        @DisplayName("Predicate<T> 의 test()")
        void predicateGet(){

            Predicate<String> startWithJaden = (s) -> s.startsWith("Jaden");

            assertThat(startWithJaden.test("Jaden")).isTrue();

            assertThat(startWithJaden.test("SomethingElse")).isFalse();
        }

        @Test
        @DisplayName("Predicate<T> 의 or()")
        void predicateOr(){

            Predicate<Integer> isOdd = (i) -> i % 2 == 1;
            Predicate<Integer> isIntegerThree = (i) -> i.equals(Integer.valueOf(3));

            assertThat(isOdd.test(1)).isTrue();
            assertThat(isOdd.test(2)).isFalse();

            assertThat(isIntegerThree.test(3)).isTrue();
            assertThat(isIntegerThree.test(1)).isFalse();

            assertThat(isOdd.or(isIntegerThree).test(1)).isTrue();
            assertThat(isOdd.or(isIntegerThree).test(2)).isFalse();
            assertThat(isOdd.or(isIntegerThree).test(3)).isTrue();
        }

        @Test
        @DisplayName("Predicate<T> 의 negate()")
        void predicateNegate(){

            Predicate<Integer> isIntegerOne = (i) -> i.equals(Integer.valueOf(1));

            assertThat(isIntegerOne.negate().test(1)).isFalse();
        }

        @Test
        @DisplayName("Predicate<T> 의 isEqual()")
        void predicateIsEqual(){

            Predicate<String> predicate = Predicate.isEqual("test1");
            assertThat(predicate.test("test1")).isTrue();
            assertThat(predicate.test("test2")).isFalse();

        }
        @Test
        @DisplayName("Predicate<T> 의 and()")
        void predicateAnd(){

            Predicate<Integer> isOdd = (i) -> i % 2 == 1;
            Predicate<Integer> isIntegerThree = (i) -> i.equals(Integer.valueOf(3));

            assertThat(isOdd.and(isIntegerThree).test(1)).isFalse();
            assertThat(isOdd.and(isIntegerThree).test(2)).isFalse();
            assertThat(isOdd.and(isIntegerThree).test(3)).isTrue();
        }
    }

}
