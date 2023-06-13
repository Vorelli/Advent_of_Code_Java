package dev.toscanonatale;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DirectoryScanner {
    public static void main(String... args) {
        if (args.length == 0) {
            System.out.println("Please provide a filename for your first argument");
            return;
        }
        int result = solve(new File(args[0]));
        System.out.println("The answer is: " + result);
    }

    public static int solve(File f) {
        try {
            Scanner s = new Scanner(f);
            String command = "";
            FSDir root = new FSDir("/", null);
            FSDir cwd = root;
            while (s.hasNextLine()) {
                String line = s.nextLine();
                System.out.println("line: " + line);
                if (line.startsWith("$")) {
                    // "command"
                    command = line.substring(2);
                    System.out.println("Command: " + command);
                    if (command.startsWith("cd")) {
                        String[] commands = command.split(" ");
                        if (commands[1].equals("..")) {
                            System.out.println("Going up!");
                            cwd = cwd.getParent();
                        } else if (commands[1].equals("/")) {
                            System.out.println("Going to root");
                            cwd = root;
                        } else {
                            System.out.println("Going to: " + commands[1]);
                            cwd = cwd.findChild(commands[1]);
                        }
                    }
                } else {
                    // result of command
                    switch (command) {
                        case "ls":
                            System.out.println("LS");
                            String[] lineSplit = line.split(" ");
                            String childName = lineSplit[1];
                            String childPath = cwd.getPath() + childName;
                            if (lineSplit[0].equals("dir"))
                                childPath += "/";
                            FSNode child;
                            // need to determine whether child is dir or file
                            if (line.startsWith("dir")) {
                                child = new FSDir(childPath, cwd);
                            } else {
                                int size = Integer.parseInt(lineSplit[0]);
                                child = new FSFile(childPath, cwd, size);
                            }
                            System.out.println("Child: " + child.getPath() + "  " + child.getSize());
                            cwd.addChild(child);
                            break;
                    }
                }
            }
            s.close();
            return root.getDirUnder100k();
        } catch (Exception e) {
            if (e instanceof FileNotFoundException) {
                System.out.println("Failed to find file: " + f.getPath());
            }
            e.printStackTrace();
            return -1;
        }
    }
}
