package basic001.stream.lambda;

import java.util.Comparator;


public class CustomComparator {

    public static Comparator<String> getComparator() {
        return (o1, o2) -> {
            return o1.length() < o2.length() ? -1 : 1;
        };
    }
}
