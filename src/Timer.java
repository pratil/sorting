// It is used to capture time taken to do a certain task. Used like a Stopwatch.
public class Timer {

    // it captures the time at which the task was started. (in nanoseconds)
    private long start;

    // Stop watch is started as soon as we create an object for timer class.
    public Timer() {
        start = System.nanoTime();
    }

    // We can get time at any point of time after the stop watch is started. (It gives time in seconds.)
    public double getTime() {
        return (double) (System.nanoTime() - start) / 1_000_000_000;
    }

    // This can we used to stop and start a new stop watch, i.e. reset the start time to current time.
    public void resetTime() {
        start = System.nanoTime();
    }

}
