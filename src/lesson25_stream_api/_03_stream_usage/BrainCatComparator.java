package lesson25_stream_api._03_stream_usage;

import lesson24_lambda._00_brains.BrainCat;

import java.util.Comparator;

public class BrainCatComparator  implements Comparator<BrainCat> {
    @Override
    public int compare(BrainCat cat1, BrainCat cat2) {
        return cat1.getAge() - cat2.getAge();
    }
}
