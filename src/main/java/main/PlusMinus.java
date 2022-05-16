package main;

import java.io.*;
import java.lang.reflect.Array;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
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

}
