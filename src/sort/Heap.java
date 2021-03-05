package sort;

// Class which implements Heap sort for the given set of numbers.
// Basic Idea:
// 1. Create a max/min heap
// 2. swap max/min with last and create max/min heap again
// Method: Using the array to represent the array as a tree.
// For simplicity storing the array from 1 to n (Instead of 0 to n-1)
// Due to this we have to override swap and isLess to check an index lower instead of the passed index
public class Heap implements Sort {

    // Name of sort to display in output
    public static final String NAME = "Heap.sort";
    // to keep the array to be sorted
    private int[] numbers;
    // to keep the size of array to be sorted
    private int length;

    @Override
    public String getName() {
        return NAME;
    }

    // an override of swap function to swap first-1 with second-1 instead of first with second (For reference see: Line 8-9)
    @Override
    public void swap(int[] numbers, int first, int second) {
        first--;
        second--;
        int temp = numbers[first];
        numbers[first] = numbers[second];
        numbers[second] = temp;
    }

    // to compare first-1 and second-1 instead of first and second (For reference see: Line 8-9)
    public boolean isLess(int[] numbers, int first, int second) {
        return numbers[first - 1] < numbers[second - 1];
    }

    // to move up a node whose value is more than it's parent in the Max heap tree which makes the tree again a Max Heap
    private void swimAes(int element) {
        while (element > 1 && isLess(numbers, element / 2, element)) {
            swap(numbers, element, element / 2);
            element /= 2;
        }
    }

    // to move down a node whose value is less than it's child in the Max heap tree which makes the tree again a Max heap
    private void sinkAes(int element) {
        int maxChild;
        while (2 * element <= length) {
            maxChild = 2 * element;
            if (maxChild + 1 <= length && isLess(numbers, maxChild, maxChild + 1)) maxChild++;
            if (isLess(numbers, element, maxChild))
                swap(numbers, maxChild, element);
            element = maxChild;
        }
    }

    @Override
    public void sortAes(int[] numbers) {
        this.length = numbers.length;
        this.numbers = numbers;
        for (int i = length / 2; i > 0; i--)
            sinkAes(i);
        while (length > 1) {
            swap(this.numbers, length, 1);
            length--;
            sinkAes(1);
        }
    }

    // to move up a node whose value is less than it's parent in the Min heap tree which makes the tree again a Min Heap
    private void swimDes(int element) {
        while (element > 1 && isLess(numbers, element, element / 2)) {
            swap(numbers, element / 2, element);
            element /= 2;
        }
    }

    // to move down a node whose value is more than it's child in the Min heap tree which makes the tree again a Min heap
    private void sinkDes(int element) {
        int minChild;
        while (2 * element <= length) {
            minChild = 2 * element;
            if (minChild + 1 <= length && isLess(numbers, minChild + 1, minChild)) minChild++;
            if (isLess(numbers, minChild, element))
                swap(numbers, minChild, element);
            element = minChild;
        }
    }


    @Override
    public void sortDes(int[] numbers) {
        this.numbers = numbers;
        this.length = numbers.length;
        for (int i = length / 2; i > 0; i--)
            sinkDes(i);
        while (length > 1) {
            swap(numbers, length, 1);
            length--;
            sinkDes(1);
        }
    }
}