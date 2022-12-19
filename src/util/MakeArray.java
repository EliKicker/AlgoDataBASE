package util;

/*
    UTILITY FUNCTIONS TO TEST THE NON-GRAPH ALGORITHMS
 */

import java.io.File;
import java.util.Scanner;

public class MakeArray {

    //get scanner for input file
    private static Scanner getInputFile(String path) {
        try {
            return new Scanner(new File(path));
        } catch (Exception e) {
            System.out.println("Cannot open file: '" + path + "'");
            return null;
        }
    }

    //return graph in form of an adjacency list
    public static int[] getArray(String input_path) {
        Scanner input = getInputFile(input_path);
        if (input != null) {
            int n = input.nextInt();                                //number of elements
            int[] A = new int[n];                                   //Array

            for (int i = 0; i < n; i++) {
                A[i] = input.nextInt();
            }

            return A;
        }
        return null;
    }
}
