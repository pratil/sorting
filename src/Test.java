import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

// Test the sorting method over a given number of time and then take out average.
public class Test {

    // To store the data of sorted method, first key will be name of sort and
    // the TreeMap will contain key as size of array and value will be average no of seconds it took for that type of sort
    private HashMap<String, TreeMap<Integer, Double>> output;

    public Test() {
        output = new HashMap<>();
    }

    // to check if the arrays is sorted or not for a given set of number and for a given order
    public static boolean isSorted(int[] numbers, Order order) {
        int length = numbers.length;
        Timer timer = new Timer();
        switch (order) {
            case ASCENDING:
                for (int i = 0; i < length - 1; i++)
                    if (numbers[i] > numbers[i + 1]) {
                        System.out.printf(String.format("%60s", "Is Sorted " + order + " : " + false + ", time taken : %07.3f seconds\n"), timer.getTime());
                        return false;
                    }
                break;
            case DESCENDING:
                for (int i = 0; i < length - 1; i++)
                    if (numbers[i] < numbers[i + 1]) {
                        System.out.printf(String.format("%60s", "Is Sorted " + order + " : " + false + ", time taken : %07.3f seconds\n"), timer.getTime());
                        return false;
                    }
                break;
        }
        System.out.printf(String.format("%60s", "Is Sorted " + order + " :  " + true + ", time taken : %07.3f seconds\n"), timer.getTime());
        return true;
    }

    // to check if the arrays is sorted or not in Ascending order
    private static boolean isSorted(int[] numbers) {
        return isSorted(numbers, Order.ASCENDING);
    }

    // to print a given type of HashMap which is used by both CompareSorts.java and Test.Java
    static void printResult(HashMap<String, TreeMap<Integer, Double>> output) {
        for (Map.Entry<String, TreeMap<Integer, Double>> sort : output.entrySet()) {
            System.out.format("%20s : ", sort.getKey());
            for (Map.Entry<Integer, Double> length : sort.getValue().entrySet()) {
                System.out.format("%10d =>> % 12.9f,", length.getKey(), length.getValue());
            }
            System.out.println();
        }
    }

    // to create a random array a given no of times and sort it using the given type
    // return average time taken to sort the array
    private double getAverage(Sort type, int length, int noOfTimes) {
        int[] numbers;
        Stats sort = new Stats(), createArray = new Stats();
        Timer timer = new Timer();
        while (noOfTimes-- > 0) {
            timer.resetTime();
            numbers = Shuffle.generateRandomArray(length, true);
            createArray.addTest(timer.getTime());
            timer.resetTime();
            type.sort(numbers);
            sort.addTest(timer.getTime());
            if (noOfTimes % 20 == 0)
                System.out.println(type.getName() + " " + noOfTimes);
            System.gc();
        }
        System.out.format("%s =>> % 12.9f,", "Array Creation (" + length + ") took on an AVG: ", createArray.average());
        System.out.println();
        return sort.average();
    }

    // to test one type of sorting method, a given number of times and
    // also to test it on given set of arrays of different lengths
    public void oneSort(Sort type, int noOfTimes, int... lengths) {
        TreeMap<Integer, Double> treeMap = new TreeMap<>();
        for (int length : lengths) {
            System.out.println(type.getName());
            System.out.println();
            treeMap.put(length, getAverage(type, length, noOfTimes));
            System.out.println();
        }
        output.put(type.getName(), treeMap);
        System.gc();
    }

    // to test all types of sorting methods a given number of time and for a given set of lengths.
    public void all(int noOfTimes, int... lengths) {
        oneSort(new Selection(), noOfTimes, lengths);
        oneSort(new Insertion(), noOfTimes, lengths);
        oneSort(new Shell(), noOfTimes, lengths);
        oneSort(new Merge(), noOfTimes, lengths);
        oneSort(new Quick(), noOfTimes, lengths);
        oneSort(new Heap(), noOfTimes, lengths);
        oneSort(new ArraySort(), noOfTimes, lengths);
    }

    // to print the result
    public void printResult() {
        printResult(output);
    }
}
