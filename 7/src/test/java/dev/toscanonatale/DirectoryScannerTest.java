package dev.toscanonatale;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

public class DirectoryScannerTest {
    @Test
    public void exampleTest() {
        File f = new File("src/test/assets/test.txt");
        assertTrue(DirectoryScanner.solve(f.getAbsoluteFile()) == 24933642);
    }
}
