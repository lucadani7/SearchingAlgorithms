package com.lucadani.BinarySearch.ExistsElement;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchWithoutPosition {
    public static boolean existsElement(int[] arr, int value) {
        Arrays.sort(arr);
        int p = 0, q = arr.length - 1;
        int m = (p + q) / 2;
        while (arr[m] != value && p < q) {
            if (value < arr[m]) {
                q = m - 1;
            } else {
                p = m + 1;
            }
            m = (p + q) / 2;
        }
        return arr[m] == value;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // number of elements in array
        int value = scanner.nextInt(); // the value to search in array
        int[] arr = new int[n];
        for (int i = 0; i < n; arr[i] = scanner.nextInt(), ++i);
        String message1 = "The value " + value + " exists into array!";
        String message2 = "The value " + value + " does not exist into array!";
        System.out.println(existsElement(arr, value) ? message1 : message2);
    }
}
