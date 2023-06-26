package dev.toscanonatale;

public class CPU {
    private int reg = 1;
    private int result = 0;
    private int cycle = 0;
    private char[] crt = new char[240];
    private int crtIndex = 0;

    public void process(String instruction) {
        String[] instructionSplit = instruction.split(" ");
        switch (instructionSplit[0]) {
            case "addx":
                this.increaseCycle();
                this.increaseCycle();
                this.reg += Integer.parseInt(instructionSplit[1]);
                break;
            default:
            case "noop":
                this.increaseCycle();
                break;
        }
    }

    public void draw() {
        int currentI = this.crtIndex % 40;
        boolean drawSprite1 = this.reg == currentI;
        boolean drawSprite2 = this.reg + 1 == currentI;
        boolean drawSprite3 = this.reg - 1 == currentI;
        if (drawSprite1 || drawSprite2 || drawSprite3) {
            this.crt[this.crtIndex] = '#';
        } else {
            this.crt[this.crtIndex] = '.';
        }
        this.crtIndex++;
    }

    public void increaseCycle() {
        this.cycle++;
        if (this.cycle == 20 || (this.cycle < 221 && (this.cycle - 20) % 40 == 0)) {
            this.result += this.cycle * this.reg;
        }
        this.draw();
    }

    public int getResult() {
        return this.result;
    }

    public void printCRT() {
        for (int i = 0; i < crt.length; i++) {
            System.out.print(crt[i]);
            if (i % 40 == 39)
                System.out.println();
        }
    }
}
