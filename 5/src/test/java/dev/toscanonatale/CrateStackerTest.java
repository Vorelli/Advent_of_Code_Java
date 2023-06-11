package dev.toscanonatale;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

public class CrateStackerTest {
    @Test
    public void exampleTest() {
        File f = new File("src/test/assets/test.txt");
        String result = CrateStacker.solve(f.getAbsoluteFile());
        System.out.println("The result is: " + result);
        assertTrue(result.equals("CMZ"));
    }
}
