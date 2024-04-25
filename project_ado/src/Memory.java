package project_ado.src;


import java.text.BreakIterator;

public class Memory {
    private final int[] mem;

    public int[] getMem() 
    {
        return mem;
    }


    public Memory(int cap) {
        mem = new int[cap];
    }

    public boolean read(int address, Processor processor)
    {
        int current = mem[address];
        if (current == 0)
            return false;
        String currentVal = Integer.toString(Integer.parseInt(Integer.toString(current), 10), 16);
        System.out.println("Address : " + address);
        System.out.println("currentVal  : " + currentVal);
        int len = currentVal.length();
        if (len != 3)
            return true;
        current = Integer.parseInt(currentVal);
        int a = (current/10)%10;
        int b = current%10;
        int p = (current/100);
        System.out.println("a : " + a);
        System.out.println("b  : " + b);
        System.out.println("p  : " + p);
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
        return true;
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
