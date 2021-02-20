package sort;

import java.util.Arrays;

// Class which implements Java Arrays sort for the given set of numbers.
public class ArraySort implements Sort {

    // Name of sort to display in output
    public static final String NAME = "Arrays.sort";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void sortAes(int[] numbers) {
        Arrays.sort(numbers);
    }

    @Override
    public void sortDes(int[] numbers) {
    }
}