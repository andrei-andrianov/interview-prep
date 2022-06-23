package main;

import java.util.Collections;
import java.util.List;

public class PlusMinus {

    public static void main(String[] args) {
        Result.lonelyInteger(List.of(0,0,1,2,1));
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
        int value = 0;
        int n = a.size();

        if (n < 3){
            if (n == 1){
                return a.get(0);
            }
            return 0;
        }

        for (int i = 0; i < n; i++){
            value = a.get(i);

            boolMap[value] = !boolMap[value];
        }

        for (int i = 0; i < a.size(); i++){
            if (boolMap[a.get(i)]){
                return a.get(i);
            }
        }

        return 0;
    }

}
