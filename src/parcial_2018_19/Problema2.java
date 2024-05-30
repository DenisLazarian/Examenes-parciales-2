package parcial_2018_19;

import acm.program.CommandLineProgram;

public class Problema2 extends CommandLineProgram {


    public void run() {
        int[] v = new int[] {1, 2, -3, 0, -4, 8};
        println(diffParity(v));
    }

    private static int diffParity(int[] v) {
        return diffParity(v, 0);
    }

    private static int diffParity(int[] v, int pos){
        if(pos == v.length){
            return 0;
        }else{
            int sum = diffParity(v, pos+1);
            if(pos % 2 == 0){
                return sum + v[pos];
            }else{
                return sum - v[pos];
            }
        }
    }

    public static void main(String[] args) {
        new Problema2().start(args);
    }



}
