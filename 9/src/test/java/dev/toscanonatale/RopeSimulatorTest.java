package dev.toscanonatale;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

public class RopeSimulatorTest {
    @Test
    public void exampleTestPartOne() {
        assertTrue(RopeSimulator.solvePartOne(new File("src/test/resources/example.txt").getAbsoluteFile()) == 13);
    }
}
