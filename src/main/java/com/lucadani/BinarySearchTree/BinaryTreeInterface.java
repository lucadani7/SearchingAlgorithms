package com.lucadani.BinarySearchTree;

public interface BinaryTreeInterface {
    Node addElement(Node current, int value);
    void insertValue(int value);
    boolean containsNodeRecursive(Node current, int value);
    Node deleteElement(Node current, int value);
    void deleteValue(int value);
    int findMinValue(Node node);
    Node minValue(Node node);
    Node maxValue(Node node);
    Node findPredecesor(int value);
    Node findSuccessor(int value);
    void traverseInOrderDFS(Node node);
    void traversePreOrderDFS(Node node);
    void traversePostOrderDFS(Node node);
    void traverseLevelOrder();
}
