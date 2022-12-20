package Algorithms.SortAlgorithms;

/*
    MERGE SORT ALGORITHM
 */

public class MergeSort {

    //straight merge sort algorithm (iterative)
    //Runtime: O(n * log n)
    public static void straightMergeSort(int[] A) {
        int len = 1;
        while (len < A.length) {
            int r = -1;
            while (r + len < A.length) {
                int l = r + 1;
                int m = l + len - 1;
                r = Math.min(m + len, A.length - 1);
                merge(A, l, m, r);
            }
            len <<= 1;
        }
    }

    //merge sort algorithm (recursive)
    //Runtime: O(n * log n)
    public static void mergeSort(int[] A, int l, int r) {
        if (l >= r) return;
        int m = l + ((r - l) >> 1);
        mergeSort(A, l, m);
        mergeSort(A, m + 1, r);
        merge(A, l, m, r);
    }

    private static void merge(int[] A, int l, int m, int r) {
        int[] B = new int[r - l + 1];
        int i = l;
        int j = m + 1;
        int k = 0;
        while (i <= m && j <= r) {
            if (A[i] <= A[j]) {
                B[k] = A[i];
                i++;
            } else {
                B[k] = A[j];
                j++;
            }
            k++;
        }
        while (i <= m) {
            B[k] = A[i];
            i++;
            k++;
        }
        while (j <= r) {
            B[k] = A[j];
            j++;
            k++;
        }
        for (k = l; k <= r; k++) {
            A[k] = B[k - l];
        }
    }
}
