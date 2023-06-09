package dev.toscanonatale;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

public class RucksackPrioTest {
    @Test
    public void testExample() {
        File f = new File("src/test/assets/test.txt");

        assertTrue(RucksackPrio.solve(f.getAbsoluteFile()) == 70);
    }
}
