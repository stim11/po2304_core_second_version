package lesson24_lambda._04_method_reference;

import lesson24_lambda._00_brains.BrainCat;

import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        //ссылкак на статический метод
        Function<String, Boolean> function = str -> Boolean.valueOf(str);
        System.out.println(function.apply("true"));
        Function<String, Boolean> function1 = Boolean::valueOf;
        System.out.println(function1.apply("asd"));
        // ссылка на нестатический метод некоего объекта
        Integer integer = 5;
        var brainCat = new BrainCat("Barsik", 10);
        Supplier<String> supplier = () -> integer.toString();
        System.out.println(supplier.get());

        Supplier<String> supplier1 = brainCat::toString;
        System.out.println(supplier1.get());

        //  ссылка на нестатический метод любого объекта конкретного типа
        Function<String, String> function2 = str ->str.toLowerCase();
        System.out.println(function2.apply("QWERTY"));
        Function<String, String> function3 = String::toLowerCase;
        System.out.println(function3.apply("QWERTY"));

        // Ссылка на конструктор

        Function<String, BrainCat> function4 = str -> new BrainCat(str);
        System.out.println(function4.apply("Murzik"));
        Function<String, BrainCat> function5 = BrainCat::new;
        System.out.println(function5.apply("Murzik"));



    }
}
