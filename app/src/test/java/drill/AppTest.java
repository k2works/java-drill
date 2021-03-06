/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package drill;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    void 何か便利なもの() {
        assertEquals(true, true);
    }

    @Test
    void 簡単な挨拶を返す() {
        assertEquals("Hello from Java", Program.helloWorld());
    }

    @Test
    void 指定された名前で挨拶を返す() {
        assertEquals("Hello from VSCode", Program.helloWorld("VSCode"));
    }
}

class Program {
    static String helloWorld(String name) {
        return String.format("Hello from %s", name);
    }

    public static Object helloWorld() {
        return "Hello from Java";
    }
}
