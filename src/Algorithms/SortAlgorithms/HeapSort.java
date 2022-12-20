package Algorithms.SortAlgorithms;

/*
    HEAP SORT ALGORITHM
 */

public class HeapSort {

    //heap sort algorithm
    //Runtime: O(n * log n)
    public static void heapSort(int[] A) {
        for (int i = (A.length - 1) >> 1; i >= 0; i--) {
            restoreHeapCondition(A, i, A.length - 1);
        }
        for (int m = A.length - 1; m >= 1; m--) {
            A[0] ^= A[m];
            A[m] ^= A[0];
            A[0] ^= A[m];
            restoreHeapCondition(A, 0, m - 1);
        }
    }

    private static void restoreHeapCondition(int[] A, int i, int m) {
        while ((i << 1) + 1 <= m) {
            int j = (i << 1) + 1;
            if (j + 1 <= m && A[j] < A[j + 1]) j++;
            if (A[i] >= A[j]) return;
            A[i] ^= A[j];
            A[j] ^= A[i];
            A[i] ^= A[j];
            i = j;
        }
    }
}
