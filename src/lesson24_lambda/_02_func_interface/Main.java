package lesson24_lambda._02_func_interface;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,6,7,8,9};
        for(int numb : numbers) {
            if(numb < 5) {
                System.out.println(numb);
            } else {
                return;
            }
        }
    }
}
