package drill;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Chap01Test {
    @Test
    void 三つの整数値を読み込んで最大値を求めて表示() {
        assertEquals(3, Chap01.max3(3, 2, 1));
        assertEquals(6, Chap01.max3(4, 5, 6));
    }

    @ParameterizedTest(name = "Run {index}: i={0} j={1} k={2}")
    @MethodSource("provideArgsForMax3")
    void 三つの整数値を読み込んで最大値を求めて表示_パラメータテスト(int i, int j, int k, int expected) {
        assertEquals(expected, Chap01.max3(i, j, k));
    }

    private static Stream<Arguments> provideArgsForMax3() {
        return Stream.of(Arguments.of(3, 2, 1, 3), Arguments.of(3, 2, 2, 3), Arguments.of(3, 1, 2, 3),
                Arguments.of(3, 2, 3, 3), Arguments.of(2, 1, 3, 3), Arguments.of(3, 3, 2, 3), Arguments.of(3, 3, 3, 3),
                Arguments.of(2, 2, 3, 3), Arguments.of(2, 3, 1, 3), Arguments.of(2, 3, 2, 3), Arguments.of(1, 3, 2, 3),
                Arguments.of(2, 3, 3, 3), Arguments.of(1, 2, 3, 3));
    }

    @Test
    void 読み込んだ整数値の符号を表示() {
        assertEquals("その値は正です", Chap01.judgeSign(17));
        assertEquals("その値は負です", Chap01.judgeSign(-5));
        assertEquals("その値は0です", Chap01.judgeSign(0));
    }
}

class Chap01 {
    public static Integer max3(int i, int j, int k) {
        int maximum = i;
        if (j > maximum)
            maximum = j;
        if (k > maximum)
            maximum = k;

        return maximum;
    }

    public static Object judgeSign(int i) {
        if (i > 0)
            return "その値は正です";
        if (i < 0) {
            return "その値は負です";
        } else {
            return "その値は0です";
        }
        
    }
}
