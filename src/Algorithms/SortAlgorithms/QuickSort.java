package Algorithms.SortAlgorithms;

/*
    QUICK SORT ALGORITHM
 */

public class QuickSort {

    //quick sort algorithm (chooses right most pivot which can lead wort case to O(n²) runtime)
    //Runtime: O(n log n)
    public static void quickSort(int[] A, int l, int r) {
        if (l >= r) return;
        int k = partition(A, l, r);
        quickSort(A, l, k - 1);
        quickSort(A, k + 1, r);
    }

    private static int partition(int[] A, int l, int r) {
        int i = l;
        int j = r - 1;
        int p = A[r];                           //choose right most pivot (better probabilistic runtime with random pivot)
        do {
            while (i < r && A[i] <= p) i++;     // <= if there are duplicates
            while (j > l && A[j] >= p) j--;     // >= if there are duplicates
            if (i < j && i != j) {
                A[i] ^= A[j];
                A[j] ^= A[i];
                A[i] ^= A[j];
            }
        } while (i < j);
        if (i == r) return r;
        A[i] ^= A[r];
        A[r] ^= A[i];
        A[i] ^= A[r];
        return i;
    }

    //quick select algorithm using median_of_medians
    //Runtime: O(n)
    private static int quickSelect() {
        return -1;
    }

    //median_of_medians algorithm
    //Runtime: O(n)
    private static int median_of_medians() {
        return -1;
    }
}
