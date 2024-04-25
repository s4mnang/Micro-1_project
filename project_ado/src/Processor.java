package project_ado.src;

public class Processor {

    private int PC;
    private int IR;
    private int[] reg;
    private Memory mem;

    public Processor() {
        reg = new int[8];
        PC = 0;
        IR = -1;
    }

    public boolean step() 
    {
        IR = PC;
        if (!mem.read(IR, this))
            return true;
        PC++;
        return false;
    }

    public void dump() {
        for (int i = 0; i < reg.length; i++) {
            System.out.printf("%02X: %d\n", i, reg[i]);
        }
    }

    public void setMemory(Memory mem) {
        this.mem = mem;
    }

    public void setPC(int mem) {
        PC = mem;
    }


    public void halt() { //0. halt = stop fetch-execute cycle
        reg[0] = 0; // pas sur du move
    }

    public void load(int a, int b) { // 1
        reg[a] = reg[b];
    }

    public void loadc(int a) { // 2
        PC ++;
        reg[a] = mem.getMem()[PC];
    }

    public void store(int a, int b) { // 3
        mem.getMem()[reg[a]] = reg[b];
    }
    public void add(int a, int b) { // 4
        reg[a] = reg[a] + reg[b];
    }

    public void mul(int a, int b) { // 5
        reg[a] = reg[a] * reg[b];
    }

    public void sub(int a, int b) { // 6
        reg[a] = reg[a] - reg[b];
    }

    public void div(int a, int b) { // 7
        reg[a] = reg[a] / reg[b];
    }

    public void and(int a, int b) { // 8
        if (reg[a]!= 0&&reg[b]!=0) 
            reg[a]=1;
        else reg[a]=0;
    }

    public void or(int a, int b) { // 9
        if (reg[a]!=0||reg[b]!=0) 
            reg[a]=1;
        else 
            reg[a]=0;
    }

    public void not(int a, int b) { // 10 ou A
        if (reg[b]!=0) 
            reg[a]=0;
        else 
            reg[a]=1;
    }

    public void lshift(int a, int b) { // 11 ou B
        reg[a] = reg[b] << 1;
    }

    public void rshift(int a, int b) { // 12 ou C
        reg[a] = reg[b] >> 1;
    }

    public void bwc(int a, int b) { // 13 ou D
        reg[a] = reg[a] & reg[b];
    }

    public void bwd(int a, int b) { // 14 ou E
        reg[a] = reg[a] | reg[b];
    }

    /*
    public void IF(int a, int b) { // 15 ou F
        if (proc[a] != 0) {
            proc[0] = mem[b];
        }
    }
    */



}
