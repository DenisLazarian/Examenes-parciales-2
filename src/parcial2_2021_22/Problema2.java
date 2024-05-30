package parcial2_2021_22;


import acm.program.CommandLineProgram;

public class Problema2 extends CommandLineProgram {

    public void run() {
        int[] v = {21, 84, 7, 35, -42, 21};
        println(balanced(v, v[0] + v[v.length-1]));
    }

    public static boolean balanced(int[] v, int factor) {
        // Precondición: 0 <= v.length
        return balanced(v, factor, 0, v.length-1);
    }

    public static boolean balanced(int[] v, int factor, int begin,  int end){
        if(begin > end){
            return true;
        }

        if(begin == end){
            return true;
        }else if(v[end] + v[begin] == factor){
            return balanced(v, factor, begin+1, end -1);
        }

        return false;
    }


    public static void main(String[] args) {
        new Problema2().start(args);
    }
}
