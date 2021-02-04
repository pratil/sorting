import java.util.HashMap;
import java.util.TreeMap;

// Class to compare the sorting methods
public class CompareSorts {

    // To store the data of sorted method, first key will be name of sort and
    // the TreeMap will contain key as size of array and value will be no of seconds it took for that type of sort
    private HashMap<String, TreeMap<Integer, Double>> output;

    public CompareSorts() {
        output = new HashMap<>();
    }

    // to run one test on a given number of array using the type of sort.
    private void runOneTest(Sort sortUsing, int[] numbersCopy, int length) {
        Timer timer;
        System.out.println("Sorting using " + sortUsing.getName());
        int[] numbers = numbersCopy.clone();
        timer = new Timer();
        sortUsing.sort(numbers);
        output.get(sortUsing.getName()).put(length, timer.getTime());
    }

    // run test on all the sorting types for a given lengths of numbers
    public void runTests(int... tests) {
        ArraySort arraySort = new ArraySort();
        Selection selection = new Selection();
        Insertion insertion = new Insertion();
        Shell shell = new Shell();
        Merge merge = new Merge();
        Quick quick = new Quick();
        Heap heap = new Heap();
        output.put(ArraySort.NAME, new TreeMap<>());
        output.put(Selection.NAME, new TreeMap<>());
        output.put(Insertion.NAME, new TreeMap<>());
        output.put(Shell.NAME, new TreeMap<>());
        output.put(Merge.NAME, new TreeMap<>());
        output.put(Quick.NAME, new TreeMap<>());
        output.put(Heap.NAME, new TreeMap<>());
        int[] numbers, numbersCopy;
        for (int test : tests) {
            numbers = Shuffle.generateRandomArray(test);
            numbersCopy = numbers.clone();

            runOneTest(arraySort, numbersCopy, test);

            runOneTest(selection, numbersCopy, test);

            runOneTest(insertion, numbersCopy, test);

            runOneTest(shell, numbersCopy, test);

            runOneTest(merge, numbersCopy, test);

            runOneTest(quick, numbersCopy, test);

            runOneTest(heap, numbersCopy, test);

            System.gc();

            System.out.println();
        }
        System.out.println();
    }

    // print the result of the Comparision
    public void printResult() {
        Test.printResult(output);
    }

}
