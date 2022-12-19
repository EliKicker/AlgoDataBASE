package Algorithms.SortAlgorithms;

/*
    SELECTION SORT ALGORITHM
 */

public class SelectionSort {

    //selection sort algorithm
    //Runtime: O(n²)
    public static void selectionSort(int[] A) {
        for (int i = 0; i < A.length; i++) {
            int idx = i;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[idx]) {
                    idx = j;
                }
            }
            if (idx == i) continue;
            A[i] ^= A[idx];
            A[idx] ^= A[i];
            A[i] ^= A[idx];
        }
    }
}
