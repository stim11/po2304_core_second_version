package lesson24_lambda._01_evolutions;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        var cats = List.<Cat>of(
                new Cat("Qwerty", Breed.SIBERIAN, 5),
                new Cat("Murzik", Breed.SIAMSKY, 12),
                new Cat("Pushok", Breed.GARBAGE, 2),
                new Cat("Murka", Breed.SIBERIAN, 5),
                new Cat("Markiz", Breed.SIAMSKY, 3),
                new Cat("Sosiska", Breed.SIBERIAN, 5)
        );
//        System.out.println("Siberian cats quantity is " + countByBreed(cats, Breed.SIBERIAN));
//        System.out.println("Cats with age equals 5 are " + countByAge(cats, 5));

//        System.out.println("Siberian cats quantity is " + countByCondition(cats, new BreedFilterable(), Breed.SIBERIAN));
//        System.out.println("Cats with age equals 5 are " + countByCondition(cats, new AgeFilterable(), 5));
//        System.out.println("Siberian cats quantity is " + countByCondition(cats, new Filterable<Breed>() {
//            @Override
//            public boolean check(Cat cat, Breed value) {
//                return cat.getBreed().equals(value);
//            }
//        }, Breed.SIBERIAN));
//        System.out.println("Cats with age equals 5 are " + countByCondition(cats, new Filterable<Integer>() {
//            @Override
//            public boolean check(Cat cat, Integer value) {
//                return cat.getAge() == value;
//            }
//        }, 5));
        Filterable<Breed> breedFilterable = (cat, value) -> cat.getBreed().equals(value);
        Filterable<Integer> ageFilterable = (cat, value) -> cat.getAge() == value;
        System.out.println("Siberian cats quantity is " + countByCondition(cats, breedFilterable, Breed.SIBERIAN));
        System.out.println("Cats with age equals 5 are " + countByCondition(cats, ageFilterable, 5));
    }

//    private static int countByBreed(List<Cat> cats, Breed breed) {
//        var count = 0;
//        for (Cat cat: cats) {
//            if(cat.getBreed().equals(breed)) {
//                count++;
//            }
//        }
//        return  count;
//    };
//
//    private static int countByAge(List<Cat> cats, int age) {
//        var count = 0;
//        for(Cat cat: cats) {
//            if(cat.getAge() == age) {
//                count++;
//            }
//        }
//        return count;
//    };

    private static<T>  int countByCondition(List<Cat> cats,Filterable<T> function, T value) {
        var count = 0;
        for(Cat cat: cats) {
            if(function.check(cat, value)) {
                count++;
            }
        }
        return count;
    }


}
