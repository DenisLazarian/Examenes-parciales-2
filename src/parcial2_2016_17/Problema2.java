package parcial2_2016_17;

import acm.program.CommandLineProgram;

public class Problema2 extends CommandLineProgram {

    public static void main(String[] args) {
        int[] v = {1, 2, 3, 3, 5};
        int[] v2 = {1,1, 2, 3, 4, 5};
        System.out.println(twoInARow(v));
        System.out.println(twoInARow(v2));
    }

    public static boolean twoInARow(int[] v) {
        return twoInARow(v, v.length);
    }

    public static boolean twoInARow(int[] v, int pos){
        if ((pos-1) == 0) {
            return false;
        }
        // Comparar el elemento actual con el siguiente
        if (v[pos-1] == v[pos-2]) {
            return true;
        }
        // Llamada recursiva excluyendo el primer elemento del vector
        return twoInARow(v, pos-2);
    }
}
