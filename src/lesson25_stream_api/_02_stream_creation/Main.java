package lesson25_stream_api._02_stream_creation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream.empty();
        List.of(1,2,3).stream();
        new HashMap<String, String>().entrySet().stream();
        String[] sss = {"sss","ss"};
        Arrays.stream(sss);
        Stream.<Integer>of(1,2,3);
    }
}
