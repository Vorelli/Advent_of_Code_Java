package dev.toscanonatale;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

public class TreetopCopterTest {
    @Test
    public void exampleTest() {
        assertTrue(TreetopCopter.solvePartOne(new File("src/test/resources/example.txt").getAbsoluteFile()) == 21);
    }

    @Test
    public void exampleTestPartTwo() {
        assertTrue(TreetopCopter.solvePartTwo(new File("src/test/resources/example.txt").getAbsoluteFile()) == 8);
    }
}
