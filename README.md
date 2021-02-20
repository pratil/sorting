# Sorting Techniques

This repository contains a list of different types of sorting techniques:

- [Selection Sort](https://github.com/pratil/sorting/blob/master/src/Selection.java)
- [Insertion Sort](https://github.com/pratil/sorting/blob/master/src/Insertion.java)
- [Shell Sort](https://github.com/pratil/sorting/blob/master/src/Shell.java)
- [Heap Sort](https://github.com/pratil/sorting/blob/master/src/Heap.java)
- [Merge Sort](https://github.com/pratil/sorting/blob/master/src/Merge.java)
- [Quick Sort](https://github.com/pratil/sorting/blob/master/src/Quick.java)

On the other hand, I have compared all the types of sorting techniques.
The type of comparison that we can see here is:
 1. Testing all the types of a sort on a random array.
 2. Testing all the types of sorting on N randomly generated array and taking out average.

To compare and to calculate the time taken by them we need some more small classes which are:

- [Timer](https://github.com/pratil/sorting/blob/master/src/Timer.java) (To capture time taken to perform any task in nanoseconds)
- [Shuffle](https://github.com/pratil/sorting/blob/master/src/Shuffle.java) (To generate a random array for a given length)
- [Stats](https://github.com/pratil/sorting/blob/master/src/Stats.java) (To store all times and calculate an average value from it)
- [CompareSorts](https://github.com/pratil/sorting/blob/master/src/CompareSorts.java) (To compare between different sorting techniques on a random array)
- [Test](https://github.com/pratil/sorting/blob/master/src/Test.java) (To run a single/multiple sorts on N random arrays of a given size and keep their average)
- [Sort](https://github.com/pratil/sorting/blob/master/src/Sort.java) (An interface that works as the parent for all the sort types)
- [ArraySort](https://github.com/pratil/sorting/blob/master/src/ArraySort.java) (A class that used to duplicate Java's array sort as a child of Sort)
- [Order](https://github.com/pratil/sorting/blob/master/src/Order.java) (An enum to decide in which order we want to sort the array)