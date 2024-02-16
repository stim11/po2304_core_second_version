package lesson25_stream_api._01_base;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private static final Predicate<Integer> POSITIVE_PREDICATE = it -> it > 0;
    private static final Predicate<Integer> NEGATIVE_PREDICATE = it -> it < 0;
    public static void main(String[] args) {
        List<Integer> list = List.of(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5);
        System.out.println(getPositiveNumberQuantity(list));
        System.out.println(list.stream()
                .filter(it -> it>= 0)
                .count());
        List<Integer> negativeNumbers = list.stream()
                .filter(NEGATIVE_PREDICATE).toList();
        negativeNumbers.forEach(System.out::println);
        List<Integer> positiveNumbers = list.stream()
                .filter(POSITIVE_PREDICATE).toList();
        positiveNumbers.forEach(System.out::println);

//        list = list.stream()
//                .filter(it -> it == 0).toList();
//        list.forEach(System.out::println);
        Stream<Integer> stream = list.stream();
        System.out.println(stream.filter(POSITIVE_PREDICATE).count());
    }

    private static int getPositiveNumberQuantity(List<Integer> numbers) {
        int counter = 0;
        for (Integer number : numbers) {
           if(number >= 0) {
               counter++;
           }
        }
        return counter;
    }
}
