import java.util.Arrays;
import java.util.stream.IntStream;

public class EvenNumberFilter {
    public static void main(String[] args) {
        int[] numbers = {15, 24, 31, 42, 59, 60};

        // Filter and print even numbers
        IntStream.of(numbers)
                 .filter(n -> n % 2 == 0)
                 .forEach(System.out::println);
    }
}



