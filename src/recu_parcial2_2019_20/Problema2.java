package recu_parcial2_2019_20;

import acm.program.CommandLineProgram;

public class Problema2 extends CommandLineProgram {

    public void run() {
        String[] words = new String[] { "hola", "mundo", "alarma", "planeta"};
        String result = reverseConcat(words);
        System.out.println(result);
//        assertEquals("mundohola", result);
    }


    private String reverseConcat(String[] words) {
        return reverseConcat(words, 0);
    }

    private String reverseConcat(String[] words, int pos){
        if(pos == words.length){
            return "";
        }else{
            String resu = reverseConcat(words, pos+1);
            return resu + words[pos];
        }
    }


    public static void main(String[] args) {
        new Problema2().start(args);
    }


    private void assertEquals(String mundohola, String result) {
        System.out.println(mundohola.equals(result));
    }

}
