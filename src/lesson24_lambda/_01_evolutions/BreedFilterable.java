package lesson24_lambda._01_evolutions;

public class BreedFilterable implements  Filterable<Breed>{
    @Override
    public boolean check(Cat cat, Breed value) {
        return cat.getBreed().equals(value);
    }
//    @Override
//    public boolean check(Cat cat, Breed value) {
//        return cat.getBreed().equals(value);
//    }
}
