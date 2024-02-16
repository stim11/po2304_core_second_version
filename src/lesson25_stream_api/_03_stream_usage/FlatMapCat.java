package lesson25_stream_api._03_stream_usage;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@ToString
public class FlatMapCat implements BaseCat {
    @NonNull
    private String name;
    private int age;
    private List<String> toys;
}
