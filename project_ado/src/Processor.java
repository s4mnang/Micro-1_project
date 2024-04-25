public class Processor {

    private int[] proc;


    public Processor() {
        proc = new int[256];
    }

    public void step() {

    }

    public void dump() {
        for (int i = 0; i < proc.length; i++) {
            System.out.printf("%02X: %02X\n", i, proc[i]);
        }

    }

}
