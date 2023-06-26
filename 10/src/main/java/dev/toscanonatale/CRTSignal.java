package dev.toscanonatale;

import java.io.File;
import java.util.Scanner;

public class CRTSignal {
    public static void main(String... args) {
        if (args.length <= 1) {
            System.out
                    .println("You need to provide a method (1 or 2) and a filename of the file to solve as arguments.");
            return;
        }

        File f = new File(args[1]);
        switch (args[0]) {
            case "1":
                System.out.println("The part one solution is: " + solvePartOne(f));
                break;
            case "2":
            default:
                System.out.println("The part two solution is: ");
                solvePartTwo(f);
                break;
        }
    }

    public static int solvePartOne(File f) {
        try {
            CPU cpu = new CPU();
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                cpu.process(line);
            }
            s.close();
            return cpu.getResult();
        } catch (Exception e) {
            System.out.println("Solve failed:");
            e.printStackTrace();
        }
        return 0;
    }

    public static void solvePartTwo(File f) {
        try {
            CPU cpu = new CPU();
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                cpu.process(line);
            }
            s.close();
            cpu.printCRT();
        } catch (Exception e) {
            System.out.println("Solve failed:");
            e.printStackTrace();
        }
        return;
    }
}
