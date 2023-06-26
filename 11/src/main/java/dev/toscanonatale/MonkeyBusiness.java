package dev.toscanonatale;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class MonkeyBusiness {
    public static void main(String... args) {
        if (args.length <= 1) {
            System.out.println("You need to provide a method (1 or 2) and a filename as arguments.");
            return;
        }

        File f = new File(args[1]);
        switch (args[0]) {
            default:
            case "1":
                System.out.println("The part one solution is: " + solvePartOne(f));
                break;
            case "2":
                break;
        }
    }

    public static ArrayList<Monkey> getMonkeys(Scanner s) {
        int idx = 0;
        Monkey m = new Monkey();
        ArrayList<Monkey> monkeys = new ArrayList<>();
        int monkeyIdx;
        while (s.hasNextLine()) {
            String line = s.nextLine();
            switch (idx % 7) {
                case 0:
                    m = new Monkey();
                    monkeyIdx = Integer.parseInt(line.split(" ")[1].split(":")[0]);
                    monkeys.add(monkeyIdx, m);
                    break;
                case 1:
                    String[] items = line.split(": ")[1].split(", ");
                    for (String item : items) {
                        m.addItem(Integer.parseInt(item));
                    }
                    break;
                case 2:
                    m.operation = line.split(" old ")[1];
                    break;
                case 3:
                    m.test = Integer.parseInt(line.split("divisible by ")[1]);
                    break;
                case 4:
                    m.trueThrow = Integer.parseInt(line.split(" monkey ")[1]);
                    break;
                case 5:
                    m.falseThrow = Integer.parseInt(line.split(" monkey ")[1]);
                    break;
            }
            idx++;
        }
        return monkeys;
    }

    public static void processTurn(ArrayList<Monkey> monkeys, Player p) {
        for (Monkey m : monkeys) {
            while (m.hasNextItem()) {
                long item = m.getNextItem();
                p.setWorry(item);
                String[] splitOp = m.operation.split(" ");
                int num = Integer.parseInt(splitOp[1].equals("old") ? (p.getWorry() + "") : splitOp[1]);
                switch (splitOp[0]) {
                    case "*":
                        p.mulWorry(num);
                        break;
                    case "+":
                        p.addWorry(num);
                        break;
                }
                p.chill();
                if (p.getWorry() % m.test == 0) {
                    monkeys.get(m.trueThrow).addItem(p.getWorry());
                } else {
                    monkeys.get(m.falseThrow).addItem(p.getWorry());
                }
            }
        }
    }

    public static int getSolution(ArrayList<Monkey> monkeys) {
        int[] max = { 0, 0 };
        for (Monkey m : monkeys) {
            if (m.getInspections() > max[1]) {
                if (m.getInspections() > max[0]) {
                    max[1] = max[0];
                    max[0] = m.getInspections();
                } else {
                    max[1] = m.getInspections();
                }
            }
        }
        System.out.println("Solution: " + max[0] * max[1]);
        return max[0] * max[1];
    }

    public static void printMonkeys(ArrayList<Monkey> monkeys) {
        int i = 0;
        for (Monkey m : monkeys) {
            System.out.print("Monkey " + i);
            for (long item : m.getItems()) {
                System.out.print(" " + item + ",");
            }
            System.out.println();
            i++;
        }
    }

    public static int solvePartOne(File f) {
        try {
            Scanner s = new Scanner(f);
            ArrayList<Monkey> monkeys = getMonkeys(s);
            Player p = new Player();
            s.close();
            for (int i = 0; i < 20; i++) {
                processTurn(monkeys, p);
                System.out.println("Round " + (i + 1));
                printMonkeys(monkeys);
                System.out.println();
            }
            return getSolution(monkeys);
        } catch (Exception e) {
            System.out.println("Failed!");
            e.printStackTrace();
        }
        return 0;
    }
}
