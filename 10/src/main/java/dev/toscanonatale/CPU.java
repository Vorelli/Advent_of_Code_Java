package dev.toscanonatale;

public class CPU {
    private int reg = 1;
    private int result = 0;
    private int cycle = 0;

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

    public void increaseCycle() {
        this.cycle++;
        if (this.cycle == 20 || (this.cycle < 221 && (this.cycle - 20) % 40 == 0)) {
            this.result += this.cycle * this.reg;
        }
    }

    public int getResult() {
        return this.result;
    }
}
