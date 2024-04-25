package project_ado.src;


import java.text.BreakIterator;

public class Memory {
    private final int[] mem;
    private Processor processor;

    public int[] getMem() 
    {
        return mem;
    }


    public Memory(int cap) {
        mem = new int[cap];
    }

    public void read(int address)
    {
        int len = Integer.toString(address).length();
        int a = (address/10)%10;
        int b = address%10;
        int p = (address/100);
        switch (p) {
            case 1:
                processor.load(a, b);
                break;
            case 2:
                processor.loadc(a);
                break;
            case 3:
                processor.store(a, b);
                break;
            case 4:
                processor.add(a, b);
                break;
            case 5:
                processor.mul(a, b);
                break;
            case 6:
                processor.sub(a, b);
                break;
            case 7:
                processor.div(a, b);
                break;
            case 8:
                processor.and(a, b);
                break;
            case 9:
                processor.or(a, b);
                break;
            case 10:
                processor.not(a, b);
                break;
            case 11:
                processor.lshift(a, b);
                break;
            case 12:
                processor.rshift(a, b);
                break;
            case 13:
                processor.bwc(a, b);
                break;
            case 14:
                processor.bwd(a, b);
                break;
        }
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
