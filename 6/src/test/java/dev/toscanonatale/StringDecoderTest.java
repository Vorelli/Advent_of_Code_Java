package dev.toscanonatale;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

public class StringDecoderTest {
    public void testFile(String path, int expected) {
        File f = new File(path);
        int result = StringDecoder.solve(f.getAbsoluteFile());
        System.out.println("Got result of " + result);
        assertTrue(result == (expected));
    }

    @Test
    public void testExample1() {
        testFile("src/test/assets/test.txt", 19);
    }

    @Test
    public void testExample2() {
        testFile("src/test/assets/test2.txt", 23);
    }

    @Test
    public void testExample3() {
        testFile("src/test/assets/test3.txt", 23);
    }

    @Test
    public void testExample4() {
        testFile("src/test/assets/test4.txt", 29);
    }

    @Test
    public void testExample5() {
        testFile("src/test/assets/test5.txt", 26);
    }
}
