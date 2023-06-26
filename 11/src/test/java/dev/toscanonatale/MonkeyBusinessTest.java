package dev.toscanonatale;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

public class MonkeyBusinessTest {
    private File f = new File("src/test/resources/example.txt").getAbsoluteFile();

    @Test
    public void exampleTest() {
        assertTrue(MonkeyBusiness.solve(f, true) == 10605);
    }

    @Test
    public void exmapleTestPartTwo() {
        assertTrue(MonkeyBusiness.solve(f, false) == 2713310158l);
    }
}
