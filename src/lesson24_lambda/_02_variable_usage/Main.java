package lesson24_lambda._02_variable_usage;

public class Main {
    private static  int x = 10;
    private static  int y = 20;

    public static void main(String[] args) {
        Operable operable = () -> {
            x= 30;
            return x + y;
        };
        System.out.println(operable.operate());
    }
}
