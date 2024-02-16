package lesson24_lambda._03_predifined_interfaces;

//import org.apache.commons.lang3.StringUtils;

import java.util.function.Predicate;

public class _01_Main_Predicate {
    public static void main(String[] args) {
        //T -> boolean;
        Predicate<Integer> negative =  integer -> integer < 0;
        System.out.println(negative.test(-6));
        System.out.println(negative.test(5));

        Predicate<String> containsA = str -> str.contains("A");
        Predicate<String> containsB = str -> str.contains("B");

        System.out.println(containsA.or(containsB).test("ACV"));
//        StringUtils.containsAny("VAC", "V", "C");



    }
}
