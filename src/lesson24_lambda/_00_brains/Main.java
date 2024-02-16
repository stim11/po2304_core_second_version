package lesson24_lambda._00_brains;

//import org.apache.commons.lang3.StringUtils;
//import org.apache.commons.lang3.math.NumberUtils;

public class Main {
    public  static  final String BARSIK = "BARSIK";

    public static void main(String[] args) {
        var cat = new BrainCat();
        if (BARSIK.equals(cat.getName())) {
            System.out.println("Ok");
        } else {
            System.out.println("Bad");
        }
//        System.out.println(StringUtils.equals(cat.getName(), BARSIK));
    }
}
