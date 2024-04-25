public class Processor {

    private int[] proc;
    private Memory mem;

    public Processor() {
        proc = new int[256]; // utile ?
    }

    public boolean step() {
        boolean halt = true;
        if (proc[0] == 0) { // proc[0]  ?????????
            halt = false;
        }
        return halt;
    }

    public void dump() {
        for (int i = 0; i < proc.length; i++) {
            System.out.printf("%02X: %02X\n", i, proc[i]);
        }
    }

    public void setMemory( Memory mem) {
        this.mem = mem;
    }

    public void setPC(int mem) {
        proc[0] = mem;
    }


    public void halt() { //0. halt = stop fetch-execute cycle
        proc[0] = 0; // pas sur du move
    }

    public void load(int a, int b) { // 1
        proc[a] = mem.read(proc[b]);
    }

    public void loadc(int a) { // 2
        proc[a] = mem.read(proc[0]++);
    }

    public void store(int a, int b) { // 3
        mem.write(proc[a], proc[b]);
    }
    public int add(int a, int b) { // 4
        return a + b;
    }

    public int mul(int a, int b) { // 5
        return a * b;
    }

    public int sub(int a, int b) { // 6
        return a - b;
    }

    public int div(int a, int b) { // 7
        return a / b;
    }

    public int and(int a, int b) { // 8
        if (a != 0 && b != 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public int or(int a, int b) { // 9
        if (a != 0 || b != 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public int not(int a, int b) { // 10 ou A
        if (b != 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public int lshift(int a, int b) { // 11 ou B
        return b << 1;
    }

    public int rshift(int a, int b) { // 12 ou C
        return b >> 1;
    }

    public int bwc(int a, int b) { // 13 ou D
        return a & b;
    }

    public int bwd(int a, int b) { // 14 ou E
        return a | b;
    }

    /*
    public void IF(int a, int b) { // 15 ou F
        if (proc[a] != 0) {
            proc[0] = mem[b];
        }
    }
    */



}
