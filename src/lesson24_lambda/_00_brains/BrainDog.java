package lesson24_lambda._00_brains;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class BrainDog {
    @NonNull
    private String name;
    private int age;

}
