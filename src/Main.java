import Algorithms.DP.*;
import Algorithms.GraphAlgorithms.*;
import util.ArrayUtil;
import util.GraphUtil;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] A = ArrayUtil.getArray("src/util/test_input/ArrayDistinctIntegers2");
        //System.out.println(Arrays.toString(LIS.lis(A)));
        System.out.println(Arrays.toString(LIS.lis(new int[] {10, 20, 2, 5, 3, 8, 8, 25, 6})));
    }
}