// Class which implements Merge sort for the given set of numbers.
// Basic Idea:
// 1. Divide array into two parts
// 2. Sort both the half's recursively
// 3. Merge both the sorted array in while maintaining order
public class Merge implements Sort {

    // Name of sort to display in output
    public static final String NAME = "Merge.sort";

    @Override
    public String getName() {
        return NAME;
    }

    // function to merge two sorted arrays into a array while maintaining order
    private void merge(int[] numbers, int[] auxNumbers, int low, int mid, int high, Order order) {
        System.arraycopy(numbers, low, auxNumbers, low, high - low + 1);
        int first = low, second = mid + 1, result = low;
        if (order == Order.ASCENDING)
            while (first <= mid && second <= high)
                numbers[result++] = isLess(auxNumbers[first], auxNumbers[second]) ? auxNumbers[first++] : auxNumbers[second++];
        else
            while (first <= mid && second <= high)
                numbers[result++] = isLess(auxNumbers[second], auxNumbers[first]) ? auxNumbers[first++] : auxNumbers[second++];
        while (first <= mid)
            numbers[result++] = auxNumbers[first++];
    }

    // to divide then sort recursively then calling merge to merge for Ascending order
    private void sortAesUtil(int[] numbers, int[] auxNumbers, int low, int high) {
        if (low >= high)
            return;
        int mid = (low + high) / 2;
        sortAesUtil(numbers, auxNumbers, low, mid);
        sortAesUtil(numbers, auxNumbers, mid + 1, high);
        if (isLess(numbers[mid], numbers[mid + 1])) return;
        merge(numbers, auxNumbers, low, mid, high, Order.ASCENDING);
    }

    @Override
    public void sortAes(int[] numbers) {
        int length = numbers.length;
        int[] auxNumbers = new int[length];
        sortAesUtil(numbers, auxNumbers, 0, length - 1);
    }

    // to divide then sort recursively then calling merge to merge for Descending order
    private void sortDesUtil(int[] numbers, int[] auxNumbers, int low, int high) {
        if (low >= high)
            return;
        int mid = (low + high) / 2;
        sortDesUtil(numbers, auxNumbers, low, mid);
        sortDesUtil(numbers, auxNumbers, mid + 1, high);
        if (isLess(numbers[mid + 1], numbers[mid])) return;
        merge(numbers, auxNumbers, low, mid, high, Order.DESCENDING);
    }

    @Override
    public void sortDes(int[] numbers) {
        int length = numbers.length;
        int[] auxNumbers = new int[length];
        sortDesUtil(numbers, auxNumbers, 0, length - 1);
    }
}

























