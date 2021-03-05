package sort;

public interface Sort {

    // to define the name of a Sort method, for displaying purpose.
    String getName();

    // to swap or exchange or interchange two values in a give array of integers.
    default void swap(int[] numbers, int first, int second) {
        int temp = numbers[first];
        numbers[first] = numbers[second];
        numbers[second] = temp;
    }

    // to check if the first element is smaller or not from the second element
    default boolean isLess(int first, int second) {
        return first < second;
    }

    // to sort a list of numbers in ascending order
    void sortAes(int[] numbers);

    // to sort a list of numbers in ascending order
    void sortDes(int[] numbers);

    // this is the main sort method for any type of sorting technique
    // It will take array to be sorted and order in which you want to sort it.
    default void sort(int[] numbers, Order order) {
        switch (order) {
            case ASCENDING:
                sortAes(numbers);
                break;
            case DESCENDING:
                sortDes(numbers);
                break;
        }
    }

    // if not order passed it'll sort by default in ascending order.
    default void sort(int[] numbers) {
        sortAes(numbers);
    }
}
