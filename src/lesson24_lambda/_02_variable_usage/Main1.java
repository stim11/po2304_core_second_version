package lesson24_lambda._02_variable_usage;

public class Main1 {
    public static void main(String[] args) {
        int n = 70;
        int m = 30;
        Operable operable = () -> {
            //n = 100;
            return n + m; // нельзя изменять переменные в структуре лямбды выражения
            // переменные лучше профинаализировать перед лямбда-выражением
        };

        System.out.println(operable.operate());
    }
}
