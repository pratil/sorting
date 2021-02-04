import java.util.ArrayList;

// To find the average out of N number of observations
public class Stats {

    // to store the list of values
    private ArrayList<Double> tests;
    private double sum;

    public Stats() {
        tests = new ArrayList<>(100);
        sum = 0.0;
    }

    // to initialize the array
    public Stats(double[] array) {
        this();
        for (double element : array) {
            tests.add(element);
            sum += element;
        }
    }

    // to add one test at a time
    public boolean addTest(double test) {
        sum += test;
        return tests.add(test);
    }

    // to get the average out of the number of observations
    public double average() {
        return sum / tests.size();
    }
}
