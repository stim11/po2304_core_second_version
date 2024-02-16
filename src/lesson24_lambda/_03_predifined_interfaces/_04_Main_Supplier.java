package lesson24_lambda._03_predifined_interfaces;

import java.util.Locale;
import java.util.function.Supplier;

public class _04_Main_Supplier {
    public static void main(String[] args) {
        // () -> T
        var str = "One";
        Supplier<String> supplier = () -> str.toUpperCase();
        System.out.println(supplier.get());
    }

}
