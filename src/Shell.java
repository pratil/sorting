// Class which implements Shell sort for the given set of numbers.
// Basic Idea: Insertion sort in parts like h sized sorted array
// The pattern I followed is: 3x+1 (1, 4, 13, 40, 121, ....)
// For ex: Arrays size is 15 then it'll do insertion for the size 13 then for size 4 then at last for size 1
public class Shell implements Sort {

    // Name of sort to display in output
    public static final String NAME = "Shell.sort";

    // value of H which may cary from method to method I have used '3x + 1' therefore it starts from 1
    private int h = 1;

    @Override
    public String getName() {
        return NAME;
    }

    // used to set H to set at max less then the size of array.
    private void initializeH(int length) {
        while (h < length)
            h = 3 * h + 1;
    }

    // to decrement the H value
    private void decreaseH() {
        h /= 3;
    }

    @Override
    public void sortAes(int[] numbers) {
        int length = numbers.length;
        initializeH(length);
        while (h >= 1) {
            for (int i = h; i < length; i++)
                for (int j = i; j >= h && isLess(numbers[j], numbers[j - h]); j -= h)
                    swap(numbers, j, j - h);
            decreaseH();
        }
    }

    @Override
    public void sortDes(int[] numbers) {
        int length = numbers.length;
        initializeH(h);
        while (h >= 1) {
            for (int i = h; i < length; i++)
                for (int j = i; j >= h && isLess(numbers[j - 1], numbers[j]); j -= h)
                    swap(numbers, j, j - h);
            decreaseH();
        }
    }
}
