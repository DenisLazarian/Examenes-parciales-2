package parcial2_2015_16;

import acm.program.CommandLineProgram;

public class Problema2 extends CommandLineProgram {

    public static void main(String[] args) {
        int[] v1 = {1,2,4,5,2,3,7};
        int[] v2 = {1,2,5,6,3,7,8};

        System.out.println(eachLessThan(v1, v2));
    }
    public static boolean eachLessThan(int[] a, int[] b) {
        // 0 <= a.length = b.length
        return eachLessThan(a, b, a.length);
    }

    public static boolean eachLessThan(int[] a, int[] b, int pos) {
        // 0 <= a.length = b.length
        if(0 == pos){
            return true;
        }else{
            boolean exp = eachLessThan(a, b, pos-1);
            return exp && a[pos-1] <= b[pos-1];
        }

    }

}
