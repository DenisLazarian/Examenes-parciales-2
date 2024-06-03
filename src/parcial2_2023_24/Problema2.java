package parcial2_2023_24;

public class Problema2 {
    public static void main(String[] args) {
        String[] words = new String[]{"casa","poma", "poma", "poma", "pera", "casa", "casa"};
        System.out.println(consecutives(words)); // resultado 3
    }

    private static int consecutives(String[] words) {
        return consecutives(words, 0);
    }
    private static int consecutives(String[] words, int pos){
        if(pos == words.length-1){
            return 0;
        }else{
            int cont = consecutives(words, pos+1);
            if(words[pos].equals(words[pos+1])){
                return cont + 1;
            }else{
                return cont;
            }
        }
    }


}
