package lesson24_lambda._03_predifined_interfaces;

import lesson24_lambda._00_brains.BrainCat;

import java.util.function.UnaryOperator;

public class _05_Main_Unary_Operator {
    public static void main(String[] args) {
        // T -> T
        var brainCat = new BrainCat("Barsik", 10);
        UnaryOperator<BrainCat> operator = cat -> {cat.setAge(cat.getAge() + 1);
                                                    return cat;};
        System.out.println(operator.apply(brainCat));

    }
}
