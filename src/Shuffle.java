import java.util.stream.IntStream;

// to generate a array and Shuffle it in random order.
public class Shuffle {

    // returns a random integer from low to high including the limits.
    private static int getRandomPosition(int low, int high) {
        return low + (int) (Math.random() * (high - low));
    }

    // to swap or exchange or interchange two values in a give array of integers.
    private static void swap(int[] numbers, int first, int second) {
        int temp = numbers[first];
        numbers[first] = numbers[second];
        numbers[second] = temp;
    }

    // Given an array of integer it'll shuffle the array into random order.
    public static void shuffle(int[] numbers) {
        int length = numbers.length;
        for (int i = 0; i < length - 1; i++)
            swap(numbers, i, getRandomPosition(i + 1, length - 1));
    }

    // given an integer it'll create an array from -n/2 to n/2 and then shuffle it in random order.
    // If called in bulk not printing anything in output.
    public static int[] generateRandomArray(int n, boolean isBulk) {
        if (isBulk) {
            int[] numbers = IntStream.range(-n / 2, n / 2 + (n % 2)).toArray();
            shuffle(numbers);
            return numbers;
        } else
            return generateRandomArray(n);
    }

    // given an integer it'll create an array from -n/2 to n/2 and then shuffle it in random order.
    // function overloading
    public static int[] generateRandomArray(int n) {
        System.out.println("Creating a Random array of length: " + n);
        int[] numbers = IntStream.range(-n / 2, n / 2 + (n % 2)).toArray();
        shuffle(numbers);
        System.out.println("Array Created");
        return numbers;
    }
}
