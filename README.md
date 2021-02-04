# Sorting Techniques

This repository contains a list of different types of sorting techniques:

- Selection Sort
- Insertion Sort
- Shell Sort
- Heap Sort
- Merge Sort
- Quick Sort

On the other hand, I have compared all the types of sorting techniques.
The type of comparison that we can see here is:
 1. Testing all the types of a sort on a random array.
 2. Testing all the types of sorting on N randomly generated array and taking out average.

To compare and to calculate the time taken by them we need some more small classes which are:

- Timer (To capture time taken to perform any task in nanoseconds)
- Shuffle (To generate a random array for a given length)
- Stats (To store all times and calculate an average value from it)
- CompareSorts (To compare between different sorting techniques on a random array)
- Test (To run a single/multiple sorts on N random arrays of a given size and keep their average)
- Sort (An interface that works as the parent for all the sort types)
- ArraySort (A class that used to duplicate Java's array sort as a child of Sort)
- Order (An enum to decide in which order we want to sort the array)

Here is a data which is the average of running these sorts over 100 random arrays:

|Size of Array↓|Selection.sort|Insertion.sort|
|      ---:|:---:|:---:|
|        50,000| 0.569508188| 0.369651549|
|       100,000| 2.218213807| 1.451540697|
|       200,000| 9.053829326| 5.931873042|
|       500,000|58.541881722|38.205644483|



|Size of Array↓|Shell.sort|Heap.sort|Merge.sort|Quick.sort|Arrays.sort|
|      ---:|:---:|:---:|:---:|:---:|:---:|
|        50,000| 0.007788335| 0.004852684| 0.005443337| 0.004632609| 0.003587351|
|       100,000| 0.122510510| 0.010500123| 0.011385145| 0.009646074| 0.006838452|
|       200,000| 0.214421293| 0.022690100| 0.024487798| 0.020336871| 0.014429728|
|       500,000| 0.117853091| 0.063964193| 0.064516861| 0.054153651| 0.039034140|
|     1,000,000| 0.258667383| 0.135301210| 0.129033406| 0.109442461| 0.084241867|
|     2,000,000| 0.600035991| 0.327406473| 0.264568937| 0.225157817| 0.171502894|
|     5,000,000| 1.733755007| 1.056676630| 0.698748320| 0.589271478| 0.456997531|
|    10,000,000| 3.984183917| 2.381708186| 1.460757314| 1.233305494| 0.947967369|
|    20,000,000| 8.771336628| 5.322993067| 3.058225460| 2.552687592| 1.985351130|
|    50,000,000|24.944511105|16.134708356| 8.341580859| 7.659095986| 5.298573137|