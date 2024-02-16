package lesson24_lambda._01_evolutions;

public class AgeFilterable implements Filterable<Integer>{
    @Override
    public boolean check(Cat cat, Integer value) {
        return cat.getAge() == value;
    }
//    @Override
//    public boolean check(Cat cat, Integer value) {
//        return cat.getAge() == value;
//    }
}
