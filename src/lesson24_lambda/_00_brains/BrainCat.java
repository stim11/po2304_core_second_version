package lesson24_lambda._00_brains;

import lesson25_stream_api._03_stream_usage.BaseCat;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@ToString
public class BrainCat implements Comparable<BrainCat>, BaseCat {
    @NonNull
    private String name;
    private int age;

    @Override
    public int compareTo(BrainCat cat) {
        return name.compareTo(cat.getName());
    }
}
