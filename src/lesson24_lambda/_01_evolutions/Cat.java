package lesson24_lambda._01_evolutions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Data
@ToString
public class Cat {
    private String name;
    private Breed breed;
    private int age;

}
