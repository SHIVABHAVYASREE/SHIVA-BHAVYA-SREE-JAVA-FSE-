import java.util.*;

public class LambdaSort {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Zara", "Mike", "Alex", "John");

        // Sort using lambda
        Collections.sort(names, (a, b) -> a.compareToIgnoreCase(b));

        System.out.println("Sorted Names:");
        names.forEach(System.out::println);
    }
}

