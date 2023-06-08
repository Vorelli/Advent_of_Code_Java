package dev.toscanonatale;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.nio.file.Path;

import org.junit.Test;

public class CalorieCountTest {
    @Test
    public void test1() {
        Path p = Path.of("src/test/assets/test1.txt");
        File f = new File(p.toString());

        int[] max = CalorieCounter.countFile(f.getAbsolutePath());
        int sum = 0;
        for (int num : max) {
            sum += num;
        }
        assertTrue(sum == 45000);
    }

    @Test
    public void test2() {
        Path p = Path.of("src/test/assets/test2.txt");
        File f = new File(p.toString());
        int[] max = CalorieCounter.countFile(f.getAbsolutePath());
        int sum = 0;
        for (int num : max) {
            sum += num;
        }
        assertTrue(sum == 199357);
    }
}
