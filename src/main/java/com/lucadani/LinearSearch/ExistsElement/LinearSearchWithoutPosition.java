package com.lucadani.LinearSearch.ExistsElement;

import java.util.Scanner;

public class LinearSearchWithoutPosition {
    static boolean existsElement(int[] arr, int value) {
        for (var elem : arr) {
            if (elem == value) {
                return true;
            }
        }
        return false;
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
