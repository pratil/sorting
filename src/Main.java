import sort.Order;
import sort.Sort;

public class Main {

    // to generate a random number and sort it using the type of sort and then test if the array is sorted or not
    private static void testSingleSort(int length, Sort type, Order order) {
        int[] numbers = Shuffle.generateRandomArray(length);
        type.sort(numbers, order);
        Test.isSorted(numbers, order);
    }

    // to Create CompareSorts and run tests
    private static void compareSorts() {
        CompareSorts compare = new CompareSorts();
//        compare.runTests(200_000, 500_000, 1_000_000, 2_000_000, 5_000_000, 10_000_000, 100_000_000);
//        compare.runTests(100_000_000, 200_000_000, 300_000_000);
//        compare.runTests(10, 100, 1_000, 10_000, 100_000, 200_000, 500_000, 1_000_000);
//        compare.runTests(1_000_000);
        compare.runTests(10, 100, 1_000, 10_000, 100_000);
        compare.printResult();
    }

    // to test one type of sort for a given number of times and get the average time taken by them
    private static void getAverageRunningTimeForOne(Sort sort, int noOfTimes, int... lengths) {
        Test test = new Test();
        test.oneSort(sort, noOfTimes, lengths);
        test.printResult();
    }

    // to test all type of sort for a given number of times and get the average time taken by them
    private static void getAverageRunningTimeForAll(int noOfTimes, int... lengths) {
        Test test = new Test();
        test.all(noOfTimes, lengths);
        test.printResult();
    }

    public static void main(String[] args) {
//        compareSorts();
//        getAverageRunningTimeForOne(new ArraySort(), 100, 50_000);
//        getAverageRunningTimeForAll(100, 1_000_000, 2_000_000, 5_000_000, 10_000_000, 20_000_000);
    }
}
