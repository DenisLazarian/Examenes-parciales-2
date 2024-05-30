package recu_2017_18;

public class Problema2 {

    public static void main(String[] args) {
        int[] numbers = new int[] {1, 2, -3, 0, -4, 8};
        System.out.println(diffParity(numbers));
    }


    private static int diffParity(int[] v) {
        // 0 <= pos <= v.length
       return  diffParity(v, v.length-1);
    }
    private static int diffParity(int[] v, int pos){
        if(pos < 0){
            return 0;
        }else{
            int result = 0;
            if(v[pos] % 2 == 0){
                result += 1;
            }else{
                 result -= 1;
            }
            return result + diffParity(v, pos-1);
        }
    }

}
