package recu_2021_22;

import acm.program.CommandLineProgram;

public class Problema2 extends CommandLineProgram {

    public void run() {
        String[] v = {"one", "two", "three"};
        println(intersperse(v, "<->"));
    }

    private String intersperse(String[] v, String sep) {
        return intersperse(v, sep, 0);
    }

    // version prefijo
    private String intersperse(String[] v, String sep, int pos){
        if(pos == 0) {
            return "";
        }else if(pos==1){
            return v[0];
        }else{
            String s = intersperse(v, sep, pos-1);
            return s + sep + v[pos - 1];
        }
    }



    public static void main(String[] args) {
        new Problema2().start(args);
    }
}
