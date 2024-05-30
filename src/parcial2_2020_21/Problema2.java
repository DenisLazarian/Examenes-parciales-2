package parcial2_2020_21;

import acm.program.CommandLineProgram;

public class Problema2 extends CommandLineProgram {

    public void run() {
        int[] numbers = new int[] {1, 2, -4, 3, 0, 6};
        print(sumEven(numbers));
    }

    private int sumEven(int[] numbers) {
        return sumEven(numbers, numbers.length);
    }
    private int sumEven(int[] numbers, int pos){
        if(pos == 0) {
            return 0;
        } else  {
            int sum = sumEven(numbers, pos-1);
            if(numbers[pos-1] % 2 == 0){
                return sum + numbers[pos-1];
            }else{
                return sum;
            }
        }
    }

    public static void main(String[] args) {
        new Problema2().start(args);
    }

}
