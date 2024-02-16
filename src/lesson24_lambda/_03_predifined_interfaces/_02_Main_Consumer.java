package lesson24_lambda._03_predifined_interfaces;

import java.util.Locale;
import java.util.function.Consumer;

public class _02_Main_Consumer {
    public static void main(String[] args) {
        //T -> void;
        Consumer<String> toUpperCase  = str -> System.out.println(str.toUpperCase());
        Consumer<String> toLowerCase  = str -> System.out.println(str.toLowerCase());
//        toUpperCase.accept("hello!!!");
        toUpperCase.andThen(toLowerCase).accept("Hello World");


    }
}
