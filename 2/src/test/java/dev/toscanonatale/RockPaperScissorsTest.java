package dev.toscanonatale;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

public class RockPaperScissorsTest {
    @Test
    public void testExample() {
        File f = new File("src/test/assets/test.txt");
        int result = RockPaperScissors.solve(f.getAbsoluteFile());

        assertTrue(result == 12);
    }

    @Test
    public void testMyExample() {
        File f = new File("src/test/assets/test2.txt");
        int result = RockPaperScissors.solve(f.getAbsoluteFile());
        System.out.println("Got " + result + " from test2.txt");
        assertTrue(result == 17);
    }

    @Test
    public void testMySecondExample() {
        File f = new File("src/test/assets/test3.txt");
        int result = RockPaperScissors.solve(f.getAbsoluteFile());
        assertTrue(result == 45);
    }
}
