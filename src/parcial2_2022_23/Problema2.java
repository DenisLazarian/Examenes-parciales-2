package parcial2_2022_23;

import acm.program.CommandLineProgram;

public class Problema2 extends CommandLineProgram {

    public void run() {
        int[] v = new int[]{5,4,4,3,2,1};
        if(isDecreasing(v)){
            print("Si, decreze");
        }else{
            print("No decrece");
        }
    }

    private boolean isDecreasing(int[] v){
        return isDecreasing(v, v.length-1);
    }


    private boolean isDecreasing(int[] v, int pos){
        if(pos==0){
            return true;
        }else{
            boolean dec = isDecreasing(v, pos-1);
            return dec && v[pos-1] >= v[pos];
        }
    }

    public static void main(String[] args) {
        new Problema2().start(args);
    }
}
