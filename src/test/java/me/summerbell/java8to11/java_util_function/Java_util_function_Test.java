package me.summerbell.java8to11.java_util_function;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@DisplayName("java.util.function 패키지 ")
public class Java_util_function_Test {

    @Test
    @DisplayName("Function<T,R> 인터페이스 테스트")
    void testFunctionInterface(){
        Function<Integer, Double> func = (i) -> {
            return Double.valueOf(i);
        };

        assertThat(func.apply(10)).isEqualTo(Double.valueOf(10));
    }


}
