package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PlusMinus {

    public static void main(String[] args) {
        System.out.println(Result.diagonalDifference(
                List.of(
                    List.of(11,2,4),
                    List.of(4,5,6),
                    List.of(10,8,-12)
                )
        ));
    }

}

class Result {

    public static void plusMinus(List<Integer> arr) {
        var nTotal = arr.size();
        var nNeg = arr.stream().filter(i -> i < 0).count();
        var nPos = arr.stream().filter(i -> i > 0).count();
        var nZero = arr.stream().filter(i -> i == 0).count();

        System.out.printf("%.5f%n", (float) nPos/nTotal);
        System.out.printf("%.5f%n", (float) nNeg/nTotal);
        System.out.printf("%.5f%n", (float) nZero/nTotal);
    }

    public static void miniMaxSum(List<Integer> arr){
        Collections.sort(arr);
        var max = arr.stream().limit(4).mapToLong(Integer::longValue).sum();

        arr.sort(Collections.reverseOrder());
        var min = arr.stream().limit(4).mapToLong(Integer::longValue).sum();

        System.out.println(min + " " + max);
    }

    public static String timeConversion(String s) {
        if (s.contains("PM")){
            return s.startsWith("12")
                    ? s.substring(0, 8)
                    : s.replace(s.substring(0, 2), String.valueOf(12 + Integer.parseInt(s.substring(0, 2)))).substring(0, 8);
        } else {
            return s.startsWith("12")
                    ? s.replace("12", "00")
                    : s.substring(0, 8);
        }
    }

    public static int lonelyInteger(List<Integer> a) {
        boolean[] boolMap = new boolean[101];

        for (Integer item : a) {
            boolMap[item] = !boolMap[item];
        }

        for (Integer item : a) {
            if (boolMap[item]) {
                return item;
            }
        }

        return 0;
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        int n = arr.size();
        int leftDiagonalSum = 0;
        int rightDiagonalSum = 0;
        int k = 0;
        int t = n-1;

        for (List<Integer> integers : arr) {
            for (int j = 0; j < n; j++) {
                if (j == k ){
                    leftDiagonalSum += integers.get(k);
                }
                if (j == t){
                    rightDiagonalSum += integers.get(t);
                }
            }
            k++;
            t--;
        }

        return Math.abs(leftDiagonalSum - rightDiagonalSum);
    }

    public static List<Integer> countingSort(List<Integer> arr) {
        var n = Collections.max(arr);
        var array = new int[n + 1];
        Arrays.fill(array, 0);

        for (Integer x : arr){
            array[x] += 1;
        }

        return Arrays.stream(array).boxed().toList();
    }

}
