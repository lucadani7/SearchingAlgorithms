package com.lucadani.BinarySearchTree;

import com.google.common.primitives.Ints;
import com.lucadani.BinarySearch.ExistsElement.BinarySearchWithoutPosition;

import java.util.Collections;
import java.util.Scanner;

public class OurMain {
    static int getMax(int[] arr) {
        var arrayList = Ints.asList(arr);
        return Collections.max(arrayList);
    }

    static int getMin(int[] arr) {
        var arrayList = Ints.asList(arr);
        return Collections.min(arrayList);
    }

    static int generateRandomNumberFromArray(int[] arr) {
        int mini = getMin(arr), maxi = getMax(arr);
        return (int) Math.floor(Math.random() * (maxi - mini + 1) + mini);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTreeInterface tree = new BinaryTree();
        int n = scanner.nextInt(); // number of elements in array
        int[] arr = new int[n];
        for (int i = 0; i < n; arr[i] = scanner.nextInt(), tree.insertValue(arr[i]), ++i);
        System.out.print("Original tree: ");
        tree.traverseInOrderDFS(((BinaryTree) tree).root);
        System.out.println();
        System.out.print("PreOrder Traversal: ");
        tree.traversePreOrderDFS(((BinaryTree) tree).root);
        System.out.println();
        System.out.print("PostOrder Traversal: ");
        tree.traversePostOrderDFS(((BinaryTree) tree).root);
        System.out.println();
        tree.traverseLevelOrder();
        System.out.println();
        int valueToFind = generateRandomNumberFromArray(arr);
        String message1 = "The value " + valueToFind + " exists into tree!";
        String message2 = "The value " + valueToFind + " does not exist into tree!";
        System.out.println(tree.containsNodeRecursive(((BinaryTree) tree).root, valueToFind) ? message1 : message2);
        int valueToDelete = generateRandomNumberFromArray(arr);
        System.out.println("Value to delete: " + valueToDelete);
        tree.deleteValue(valueToDelete);
        System.out.print("Original tree: ");
        tree.traverseInOrderDFS(((BinaryTree) tree).root);
        System.out.println();
        System.out.println("Max value: " + tree.maxValue(((BinaryTree) tree).root));
        System.out.println("Min value: " + tree.minValue(((BinaryTree) tree).root));
        int valueToFindSuccessor;
        do {
            valueToFindSuccessor = generateRandomNumberFromArray(arr);
        } while (!BinarySearchWithoutPosition.existsElement(arr, valueToFindSuccessor));
        System.out.println("Successor of " + valueToFindSuccessor + " is " + tree.findSuccessor(valueToFindSuccessor));
        int valueToFindPredecessor;
        do {
            valueToFindPredecessor = generateRandomNumberFromArray(arr);
        } while (!BinarySearchWithoutPosition.existsElement(arr, valueToFindPredecessor));
        System.out.println("Predecessor of " + valueToFindPredecessor + " is " + tree.findPredecesor(valueToFindPredecessor));
    }
}
