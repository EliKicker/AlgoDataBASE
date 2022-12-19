package Algorithms.SortAlgorithms;

/*
    BUBBLE SORT ALGORITHM
 */

public class BubbleSort {

    //bubble sort algorithm
    //Runtime: O(n²)
    public static void bubbleSort(int[] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length - 1; j++) {
                if (A[j] > A[j + 1]) {
                    A[j] ^= A[j + 1];
                    A[j + 1] ^= A[j];
                    A[j] ^= A[j + 1];
                }
            }
        }
    }
}