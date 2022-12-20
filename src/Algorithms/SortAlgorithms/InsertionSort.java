package Algorithms.SortAlgorithms;

/*
    INSERTION SORT ALGORITHM
 */

public class InsertionSort {

    //insertion sort algorithm
    //Runtime: O(n²)
    public static void insertionSort(int[] A) {
        for (int i = 1; i < A.length; i++) {
            int idx = binarySearch(A, 0, i - 1, A[i]);
            for (int j = i; j > idx; j--) {
                A[j] ^= A[j - 1];
                A[j - 1] ^= A[j];
                A[j] ^= A[j - 1];
            }
        }
    }

    private static int binarySearch(int[] A, int l, int r, int x) {
        if (l > r) return l;
        int m = l + ((r - l) >> 1);
        if (A[m] == x) return m;
        if (A[m] > x) {
            return binarySearch(A, l, m - 1, x);
        } else {
            return binarySearch(A, m + 1, r, x);
        }
    }
}
