package recu_2022_23;

import acm.program.CommandLineProgram;

public class Problema2 extends CommandLineProgram {

    public void run() {
        int[] v = {1,2,55,44,23,5,77,8,99};
        print(posOfMax(v));
    }

    public static int posOfMax(int[] v){
        return posOfMax(v, v.length);
    }

    public static int posOfMax(int[] v , int pos){
        if(pos == 1){
            return 0;
        }else{
            int max = posOfMax(v, pos-1);
            if(v[max] <= v[pos-1]){
                return pos-1;
            }else{
                return max;
            }
        }
    }


    public static void main(String[] args) {
        new Problema2().start(args);
    }
}

