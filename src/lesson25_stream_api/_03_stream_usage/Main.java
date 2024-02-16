package lesson25_stream_api._03_stream_usage;

import lesson24_lambda._00_brains.BrainCat;
import lesson24_lambda._01_evolutions.Cat;
//import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.SocketHandler;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        var cats = List.of(
                new BrainCat("Qwerty", 10),
                new BrainCat("Cold", 6),
                new BrainCat("Raze", 2),
                new BrainCat("Murzik", 14)
        );
        // .filter
        System.out.println("Filter");
        var stream = cats.stream()
                .filter(cat -> cat.getAge() > 3)
                .filter(cat -> cat.getName().length() >= 5);
        // .map
        System.out.println("Map and flatMap");
        cats.stream()
                .map(cat -> cat.getName());

        List.of(
                        new FlatMapCat("cat1", 5, List.of("mouse", "ball")),
                        new FlatMapCat("cat1", 5, List.of("toy1", "toy2"))
                ).stream().flatMap(cat -> cat.getToys().stream())
                .collect(Collectors.toList()).forEach(System.out::println);
        // .foreach
        System.out.println("ForEach");
        cats.forEach(System.out::println);
        // .sorted
        System.out.println("Sorted");
        cats.stream()
                .sorted()
                .forEach(it -> System.out.print(it + ", "));
        System.out.println();
        cats.stream().sorted(new BrainCatComparator())
                .forEach(it -> System.out.print(it + ", "));
        //.concat
        System.out.println("Concat");
        var brainCatsStream = cats.stream();
        var flatMapCats = List.of(
                new FlatMapCat("cat1", 5, List.of("mouse", "ball")),
                new FlatMapCat("cat2", 5, List.of("toy1", "toy2"))
        ).stream().map(cat -> new BrainCat(cat.getName(), cat.getAge()));
        Stream.concat(brainCatsStream, flatMapCats).forEach(System.out::print);
        //.distinct
        System.out.println("Distinct");
        var numbers = List.of(1, 2, 2, 4, 4, 5, 5);
        numbers.stream().distinct().forEach(System.out::print);
        System.out.println();
        //.skip and limit
        System.out.println("Skip and Limit");
        var numbers1 = List.of(1, 2, 3, 4, 5, 6, 7);
        numbers1.stream().skip(2).limit(3).forEach(System.out::println);
        // count
        System.out.println("Count");
        System.out.println(cats.stream().count());
        //findFirst
        System.out.println("FindFirst");
        System.out.println(cats.stream().findFirst().get());
        //findAny
        System.out.println("FindAny");
        System.out.println(cats.stream().findAny().get());
        //allMatch
        System.out.println("AllMatch");
        System.out.println(cats.stream().allMatch(it -> it.getName().length() >= 3));
        System.out.println(cats.stream().allMatch(it -> it.getAge() > 5));
        //anyMatch
        System.out.println("AnyMatch");
        System.out.println(cats.stream().anyMatch(it -> it.getAge() > 5));
        //noneMatch
        System.out.println("NoneMatch");
        System.out.println(cats.stream().noneMatch(it -> it.getAge() < 1));
        //max
        System.out.println("Max");
        System.out.println(cats.stream()
                .max(new Comparator<BrainCat>() {
                    @Override
                    public int compare(BrainCat o1, BrainCat o2) {
                        return o1.getAge() - o2.getAge();
                    }
                }).get());
        //min
        System.out.println("Min");
        System.out.println(cats.stream()
                .min(new Comparator<BrainCat>() {
                    @Override
                    public int compare(BrainCat o1, BrainCat o2) {
                        return o1.getAge() - o2.getAge();
                    }
                }).get());
        //reduce(BinaryOperator<T> accumulator)
        System.out.println("Reduce1");
        System.out.println(Stream.of(1,2,3,4,5,-1,-2,-3,-4,-5).reduce((x, y) -> x + y).get());
        System.out.println(Stream.of(1,2,3,4,5,-1,-2,-3,-4,-5).reduce((x, y) -> x * y).get());
        //reduce(T identity, BinaryOperator<T> accumulator)
        System.out.println("Reduce2");
        System.out.println(Stream.<Integer>empty().reduce(5, (x, y) -> x + y));
        System.out.println(Stream.of(1,2,3,4,5,-1,-2,-3,-4,-5).reduce(1, (x, y) -> x + y));
        System.out.println(Stream.of(1,2,3,4,5,-1,-2,-3,-4,-5).reduce(0, (x, y) -> x * y));
        //reduce(U identity, BiFunction<T, U>, BinaryOperator<U> accumulator)
        System.out.println("Reduce3");
        Stream<BrainCat> catStream = Stream.of(
            new BrainCat("cat1", 1),
            new BrainCat("cat2", 5),
            new BrainCat("cat3", 4),
            new BrainCat("cat4", 2)
        );
        int sum = catStream.reduce(0, (x,y) -> {
            if(y.getAge() < 3){ return x + y.getAge();}
            else return x + 0;

        }, (x,y) -> x + y);
        System.out.println(sum);
        //collect(Collector<? super T, A, R> collector)
        System.out.println("Collect");
        var adultCats = cats.stream()
                .filter(it -> it.getAge() > 5)
                .collect(Collectors.toList());
        System.out.println(adultCats.getClass().getName());
        adultCats.forEach(System.out::println);
        var adultCats1 = cats.stream()
                .filter(it -> it.getAge() > 5)
                .collect(Collectors.toSet());
        System.out.println(adultCats1.getClass().getName());
        adultCats1.forEach(System.out::println);
        Map<String, Integer> catsMap = cats.stream()
                .collect(Collectors.toMap(k -> k.getName(), v -> v.getAge()));
        catsMap.forEach((k,v) -> System.out.println(k + " " + v));

//        cats.stream()
//                .filter(it -> StringUtils.startsWith(it.getName(), "R"))
//                .collect(Collectors.toCollection(LinkedList::new));

        // parallel
        System.out.println("Parallel");
        var people = List.of("Tom", "Bob", "Sam", "Kate", "Tim", "Ann");
        people.stream().filter(p -> p.length() == 3).forEach(p -> System.out.print(p + ", "));
        System.out.println();
        people.parallelStream().filter(p -> p.length() == 3).forEach(p -> System.out.print(p + ", "));
    }
}
