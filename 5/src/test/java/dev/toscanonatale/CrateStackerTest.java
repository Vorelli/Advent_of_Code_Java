package dev.toscanonatale;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;

public class CrateStackerTest {
    @Test
    public void testReadingAndFromTop() {
        File f = new File("src/test/assets/test.txt");
        try {
            Scanner s = new Scanner(f);
            ArrayList<StackOfCrates> stacks = CrateStacker.readStacks(s);
            assertTrue(CrateStacker.fromTop(stacks).equals("NDP"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void exampleTest() {
        File f = new File("src/test/assets/test.txt");
        String result = CrateStacker.solve(f.getAbsoluteFile());
        System.out.println("Result is :" + result);
        assertTrue(result.equals("MCD"));
    }
}
