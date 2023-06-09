package dev.toscanonatale;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

import java.io.File;

public class OverlappingCleaningTest {
    @Test
    public void testExample() {
        File f = new File("src/test/assets/test.txt");
        int numOverlaps = OverlappingCleaning.solve(f.getAbsoluteFile());
        System.out.println("overlapping: " + numOverlaps);
        assertTrue(numOverlaps == 4);
    }
}
