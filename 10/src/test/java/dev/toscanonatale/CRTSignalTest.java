package dev.toscanonatale;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

public class CRTSignalTest {
    private static File f = new File("src/test/resources/example.txt").getAbsoluteFile();

    @Test
    public void exampleTest() {
        assertTrue(CRTSignal.solvePartOne(f) == 13140);
    }
}
