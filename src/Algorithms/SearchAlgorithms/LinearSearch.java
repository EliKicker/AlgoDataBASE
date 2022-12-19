package Algorithms.SearchAlgorithms;

/*
    LINEAR SEARCH ALGORITHM
 */

public class LinearSearch {

    //linear search algorithm
    //Runtime: O(n)
    public static int linearSearch(int[] A, int x) {
        int idx = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == x) {
                idx = i;
                break;
            }
        }
        return idx;
    }
}