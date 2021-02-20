package sort;

// Class which implements Insertion sort for the given set of numbers.
// Basic Idea: assuming that the array is sorted on the left of ith element we have to insert the ith element in to the sorted array
public class Insertion implements Sort {

    // Name of sort to display in output
    public static final String NAME = "sort.Insertion.sort";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void sortAes(int[] numbers) {
        int length = numbers.length;
        for (int i = 1; i < length; i++)
            for (int j = i; j > 0 && isLess(numbers[j], numbers[j - 1]); j--)
                swap(numbers, j, j - 1);
    }

    @Override
    public void sortDes(int[] numbers) {
        int length = numbers.length;
        for (int i = 1; i < length; i++)
            for (int j = i; j > 0 && isLess(numbers[j - 1], numbers[j]); j--)
                swap(numbers, j, j - 1);
    }
}
