package week4.day1.mvclab;

import org.junit.jupiter.api.Test;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.*;

class AssertionsDemo {
    @Test
    void testAssertTrue() {
        assertTrue(1 == 1);
        System.out.println("수행될까?-1");
    }

    @Test
    void testAssertFalse() {
        assertFalse(1 != 1);
    }

    @Test
    void testAssertNull() {
        assertNull(null);
    }

    @Test
    void testAssertNotNull() {
        assertNotNull(1);
    }

    @Test
    void testAssertEquals() {
        assertEquals(1, 0 + 1);
    }

    @Test
    void testAssertThrows() {
        assertThrows(ArithmeticException.class, () -> {
            int i = 1 / 0;
        });
    }

    @Test
    void testAssertTimeout() {
        String actualResult = assertTimeout(ofSeconds(1), () -> {
            Thread.sleep(2000);
            return "a result";
        });

        assertEquals("a result", actualResult);
    }

    @Test
    void testAssertTimeoutPreemptively() {
        String actualResult = assertTimeoutPreemptively(ofSeconds(1), () -> {
            Thread.sleep(2000);
            return "a result";
        });

        assertEquals("a result", actualResult);
        System.out.println("수행될까?-2");
    }
}
