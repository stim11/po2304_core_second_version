package lesson24_lambda._03_predifined_interfaces;

import lesson24_lambda._00_brains.BrainCat;
import lesson24_lambda._00_brains.BrainDog;

import java.util.function.Function;

public class _03_Main_Function {
    public static void main(String[] args) {
        Function<Double, Long> function = doub -> Math.round(doub); // Math::round () method reference
        System.out.println(function.apply(5.75));

        Function<String, String> f1 = str -> str + "1";
        Function<String, String> f2 = str -> str + "2";
        Function<String, String> f3 = str -> str + "3";
        Function<String, String> f4 = str -> str + "4";

        System.out.println(f1.andThen(f2).compose(f3).compose(f4).apply("Compose"));
        System.out.println(f1.andThen(f2).andThen(f3).apply("Apply"));
        var brainCat = new BrainCat("Barsik", 10);
        Function<BrainCat, BrainDog> transformer = cat -> new BrainDog(cat.getName(), cat.getAge());
        System.out.println(transformer.apply(brainCat));

    }
}
