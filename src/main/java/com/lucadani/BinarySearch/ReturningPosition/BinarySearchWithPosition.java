package com.lucadani.BinarySearch.ReturningPosition;

import com.google.common.primitives.Ints;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BinarySearchWithPosition {
    static boolean isSorted(int[] arr) {
        var arrayList = Ints.asList(arr);
        var arrayListSorted = new ArrayList<>(arrayList);
        Collections.sort(arrayListSorted);
        return arrayList.equals(arrayListSorted);
    }

    static int positionOfValueInArray(int[] arr, int value) {
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
        return arr[m] == value ? m : -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // number of elements in array
        int value = scanner.nextInt(); // the value to search in array
        int[] arr = new int[n];
        for (int i = 0; i < n; arr[i] = scanner.nextInt(), ++i);
        if (!isSorted(arr)) {
            System.err.println("Your array is not sorted! For doing binary search with position, the array must be sorted!");
            return;
        }
        int position = positionOfValueInArray(arr, value);
        String message1 = "The value " + value + " does not exist into array!";
        String message2 = "The value " + value + " is on the position " + position;
        System.out.println(position == -1 ? message1 : message2);
    }
}
