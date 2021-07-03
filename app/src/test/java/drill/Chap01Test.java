package drill;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.IntStream;
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

    @Test
    void while文による繰り返し() {
        assertEquals(15, Chap01.sum1ToNwhile(5));
    }

    @Test
    void for文による繰り返し() {
        assertEquals(15, Chap01.sum1ToNfor(5));
    }

    @Test
    void each文による繰り返し() {
        assertEquals(15, Chap01.sum1ToNeach(5));
    }

    @Test
    void streamAPIによる繰り返し() {
        assertEquals(15, Chap01.sum1ToNstream(5));
    }

    @Test
    void ガウスの方法() {
        assertEquals(15, Chap01.sumGuss(5));
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

    public static Integer sum1ToNwhile(int n) {
        int sum = 0;
        int i = 1;
        while (i <= n) {
            sum += i;
            i += 1;
        }
        return sum;
    }

    public static Integer sum1ToNfor(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static Integer sum1ToNeach(int n) {
        int sum = 0;
        for (int i : IntStream.rangeClosed(1, n).toArray()) {
            sum += i;
        }
        return sum;
    }

    public static Integer sum1ToNstream(int n) {
        return IntStream.rangeClosed(1, n).reduce((sum, i) -> sum + i).getAsInt();
    }

    public static Integer sumGuss(int n) {
        int sum = n * (n + 1) / 2;
        return sum;
    }
}
