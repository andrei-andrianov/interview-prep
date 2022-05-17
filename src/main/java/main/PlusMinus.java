package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class PlusMinus {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
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
        Collections.sort(a);
        for (int i = 0; i < a.size(); i++) {
            if (i > 0 && !a.get(i).equals(a.get(i - 1))){
                return a.get(i);
            }
        }
        return 0;
    }

}
