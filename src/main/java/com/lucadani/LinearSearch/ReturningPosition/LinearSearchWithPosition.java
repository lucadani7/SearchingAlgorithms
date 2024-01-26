package com.lucadani.LinearSearch.ReturningPosition;

import java.util.Scanner;

public class LinearSearchWithPosition {
    static int positionOfValueInArray(int[] arr, int value) {
        for (int i = 0; i < arr.length; ++i) {
            if (value == arr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // number of elements in array
        int value = scanner.nextInt(); // the value to search in array
        int[] arr = new int[n];
        for (int i = 0; i < n; arr[i] = scanner.nextInt(), ++i);
        int position = positionOfValueInArray(arr, value);
        String message1 = "The value " + value + " does not exist into array!";
        String message2 = "The value " + value + " is on the position " + position;
        System.out.println(position == -1 ? message1 : message2);
    }
}
