package sort;

// Class which implements Selection sort for the given set of numbers.
// Basic Idea: Pick the minimum and replace with first then second minimum with second and so on ....
public class Selection implements Sort {

    // Name of sort to display in output
    public static final String NAME = "Selection.sort";

    @Override
    public String getName() {
        return NAME;
    }

    // to find minimum in a given array of integers within a range from low to high
    private int findMinimum(int[] numbers, int low, int high) {
        int minimum = low;
        for (int i = low + 1; i <= high; i++)
            minimum = isLess(numbers[i], numbers[minimum]) ? i : minimum;
        return minimum;
    }

    // to find maximum in a given array of integers within a range from low to high
    private int findMaximum(int[] numbers, int low, int high) {
        int maximum = low;
        for (int i = low + 1; i <= high; i++)
            maximum = isLess(numbers[maximum], numbers[i]) ? i : maximum;
        return maximum;
    }

    @Override
    public void sortAes(int[] numbers) {
        int length = numbers.length;
        for (int i = 0; i < length - 1; i++) {
            int minimum = findMinimum(numbers, i, length - 1); // selecting the minimum
            if (i != minimum)
                swap(numbers, i, minimum); // swap min with ith element
        }
    }

    @Override
    public void sortDes(int[] numbers) {
        int length = numbers.length;
        for (int i = 0; i < length - 1; i++) {
            int maximum = findMaximum(numbers, i, length - 1); // selecting the maximum
            if (i != maximum)
                swap(numbers, i, maximum); // swap min with ith element
        }
    }
}
