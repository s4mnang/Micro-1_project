public class Memory {
    private int[] mem;

    public Memory(int cap) {
        mem = new int[cap];
    }

    public int read(int address) {
        return mem[address];
    }

    public void write(int address, int value) {
        mem[address] = value;
    }

    public void dump() {
        for (int i = 0; i < mem.length; i++) {
            System.out.printf("%02X: %02X\n", i, mem[i]);
        }

    }
}
