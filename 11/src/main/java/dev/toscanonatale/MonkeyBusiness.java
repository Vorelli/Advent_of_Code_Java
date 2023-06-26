package dev.toscanonatale;

import java.io.File;
import java.math.BigInteger;
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
                System.out.println("The part one solution is: " + solve(f, true));
                break;
            case "2":
                System.out.println("The part two solution is: " + solve(f, false));
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
                        m.addItem(new BigInteger(item));
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

    public static void processTurn(ArrayList<Monkey> monkeys, Player p, boolean partOne) {
        BigInteger superMod = BigInteger.ONE;
        for (Monkey m : monkeys) {
            superMod = superMod.multiply(BigInteger.valueOf(m.test));
        }

        for (Monkey m : monkeys) {
            while (m.hasNextItem()) {
                BigInteger item = m.getNextItem();
                p.setWorry(item);
                String[] splitOp = m.operation.split(" ");
                BigInteger num = splitOp[1].equals("old") ? p.getWorry() : new BigInteger(splitOp[1]);
                switch (splitOp[0]) {
                    case "*":
                        p.mulWorry(num);
                        break;
                    case "+":
                        p.addWorry(num);
                        break;
                }
                if (partOne) {
                    p.chill();
                }

                if (p.getWorry().mod(BigInteger.valueOf(m.test)).equals(BigInteger.valueOf(0))) {
                    monkeys.get(m.trueThrow).addItem(p.getWorry().mod(superMod));
                } else {
                    monkeys.get(m.falseThrow).addItem(p.getWorry().mod(superMod));
                }
            }
        }
    }

    public static long getSolution(ArrayList<Monkey> monkeys) {
        long[] max = { 0, 0 };
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
            for (BigInteger item : m.getItems()) {
                System.out.print(" " + item + ",");
            }
            System.out.println();
            i++;
        }
    }

    public static long solve(File f, boolean partOne) {
        try {
            Scanner s = new Scanner(f);
            ArrayList<Monkey> monkeys = getMonkeys(s);
            Player p = new Player();
            s.close();
            for (int i = 0; i < (partOne ? 20 : 10000); i++) {
                processTurn(monkeys, p, partOne);
            }
            return getSolution(monkeys);
        } catch (Exception e) {
            System.out.println("Failed!");
            e.printStackTrace();
        }
        return 0;
    }
}
