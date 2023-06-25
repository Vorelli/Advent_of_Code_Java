package dev.toscanonatale;

import java.io.File;
import java.util.Scanner;

public class RopeSimulator {
    public static void main(String... args) {
        if (args.length <= 1) {
            System.out.println("Please provide the method (1 or 2) and the filename as arguments");
            return;
        }

        File f = new File(args[1]);
        switch (args[0]) {
            case "2":
                System.out.println("Part two solution: " + solvePartTwo(f));
                break;
            case "1":
                System.out.println("Part one solution: " + solvePartOne(f));
                break;
        }
    }

    public static Position getPos(char dir) {
        switch (dir) {
            case 'R':
                return new Position(1, 0);
            case 'U':
                return new Position(0, 1);
            case 'D':
                return new Position(0, -1);
            case 'L':
            default:
                return new Position(-1, 0);
        }
    }

    public static int solvePartOne(File f) {
        Board b = new Board();
        Tail t = new Tail();
        Head h = new Head(t);
        try {
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                String[] split = line.split(" ");
                Position diff = getPos(split[0].charAt(0));
                for (int i = 0; i < Integer.parseInt(split[1]); i++) {
                    h.getPos().add(diff);
                    t.follow(h.getPos());
                    b.visit(t.getPos());
                }
            }
            s.close();
        } catch (Exception e) {
            System.out.println("Failed!");
            e.printStackTrace();
        }
        return b.getCount();
    }

    public static int solvePartTwo(File f) {
        return 0;
    }
}
