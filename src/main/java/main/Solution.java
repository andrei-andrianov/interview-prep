package main;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

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

    public static void quickSort(int[] arr, int begin, int end){
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    private static int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }

    public static int countDuplicate(List<Integer> numbers) {
        var counter = new int[1001];
        var totalCount = 0;
        Arrays.fill(counter, 0);

        for (var x : numbers){
            counter[x] += 1;
        }

        for (var x : counter){
            if (x >= 2){
                totalCount++;
            }
        }

        return totalCount;
    }

    public static int findLargestSquareSize(List<List<Integer>> samples) {
        var input = samples.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
        var n = samples.size();
        int maxSize = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (input[i][j] == 1) {
                    int size = 1;
                    boolean flag = true;

                    while (size + i < n && size + j < n && flag) {
                        for (int k = j; k <= size + j; k++) {
                            if (input[i + size][k] == 0) {
                                flag = false;
                                break;
                            }
                        }

                        for (int k = i; k <= size + i; k++) {
                            if (input[k][j + size] == 0) {
                                flag = false;
                                break;
                            }
                        }

                        if (flag)
                            size++;
                    }

                    if (maxSize < size) {
                        maxSize = size;
                    }
                }
            }
        }

        return maxSize;
    }

    public static void bubbleSort(int[] arr){
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j-1] > arr[j]){
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static int getMinimumDays(List<Integer> parcels) {
        int n = parcels.size();

        //assumption
        if (n <= 1){
            return 0;
        }

        boolean isAllDelivered = false;
        int days = 0;


        while (!isAllDelivered){
            //assumption
            int minParcelAmount = Integer.MAX_VALUE;

            for (int parcelAmount : parcels) {
                minParcelAmount = (parcelAmount == 0) ? minParcelAmount : Math.min(minParcelAmount, parcelAmount);
            }

            for (int i = 0; i < n; i++) {
                if (parcels.get(i) >= 1){
                    parcels.set(i, parcels.get(i) - minParcelAmount);
                }
            }

            days++;
            isAllDelivered = parcels.stream().noneMatch(center -> center > 0);
        }

        return days;
    }

}
