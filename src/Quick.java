// Class which implements insertion sort for the given set of numbers.
// Basic Idea:
// 1. Partition the array in two parts where all the left elements are smaller then the partition and on right all are larger.
// 2. Recursively sort the left half and right half except for the partition element
public class Quick implements Sort {

    // Name of sort to display in output
    public static final String NAME = "Quick.sort";

    @Override
    public String getName() {
        return NAME;
    }

    // partition the array in ascending order
    private int partitionAes(int[] numbers, int low, int high) {
        int pivot = numbers[low], left = low + 1, right = high;
        while (true) {
            while (left < high && isLess(numbers[left], pivot))
                left++;
            while (right > low && isLess(pivot, numbers[right]))
                right--;
            if (left >= right)
                break;
            swap(numbers, left, right);
        }
        swap(numbers, low, right);
        return right;
    }

    // partition the array and sort the left half and right half recursively
    private void sortAesUtil(int[] numbers, int low, int high) {
        if (low < high) {
            int partition = partitionAes(numbers, low, high);
            sortAesUtil(numbers, low, partition - 1);
            sortAesUtil(numbers, partition + 1, high);
        }
    }

    @Override
    public void sortAes(int[] numbers) {
        sortAesUtil(numbers, 0, numbers.length - 1);
    }

    // partition the array in descending order
    private int partitionDes(int[] numbers, int low, int high) {
        int left = low + 1, right = high, pivot = numbers[low];
        while (true) {
            while (left < high && isLess(pivot, numbers[left]))
                left++;
            while (right > low && isLess(numbers[right], pivot))
                right--;
            if (left >= right)
                break;
            swap(numbers, left, right);
        }
        swap(numbers, low, right);
        return right;
    }

    // partition the array and sort the left half and right half recursively
    private void sortDesUtil(int[] numbers, int low, int high) {
        if (low < high) {
            int partition = partitionDes(numbers, low, high);
            sortDesUtil(numbers, low, partition - 1);
            sortDesUtil(numbers, partition + 1, high);
        }
    }

    @Override
    public void sortDes(int[] numbers) {
        sortDesUtil(numbers, 0, numbers.length - 1);
    }
}
