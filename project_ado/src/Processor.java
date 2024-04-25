public class Processor {

    private int[] proc;
    private Memory mem;

    public Processor() {
        proc = new int[256];
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

}
