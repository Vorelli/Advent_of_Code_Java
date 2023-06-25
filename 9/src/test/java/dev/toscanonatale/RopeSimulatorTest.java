package dev.toscanonatale;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

public class RopeSimulatorTest {
    private static File f = new File("src/test/resources/example.txt").getAbsoluteFile();

    @Test
    public void exampleTestPartOne() {
        assertTrue(RopeSimulator.solvePartOne(f) == 13);
    }

    @Test
    public void exampleTestPartTwo() {
        assertTrue(RopeSimulator.solvePartTwo(f) == 1);
    }

    @Test
    public void exampleTwoPartTwo() {
        assertTrue(RopeSimulator.solvePartTwo(new File("src/test/resources/example2.txt").getAbsoluteFile()) == 36);
    }
}
