package com.lucadani.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree implements BinaryTreeInterface {
    Node root;
    @Override
    public Node addElement(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (value < current.value) {
            current.left = addElement(current.left, value);
        }
        if (value > current.value) {
            current.right = addElement(current.right, value);
        }
        return current;
    }

    public void insertValue(int value) {
        root = addElement(root, value);
    }

    @Override
    public boolean containsNodeRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        return value < current.value ? containsNodeRecursive(current.left, value) : containsNodeRecursive(current.right, value);
    }

    @Override
    public Node deleteElement(Node current, int value) {
        if (current == null) {
            return null;
        }
        if (value < current.value) {
            current.left = deleteElement(current.left, value);
        } else if (value > current.value) {
            current.right = deleteElement(current.right, value);
        } else {
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            }
            current.value = findMinValue(current.right);
            current.right = deleteElement(current.right, current.value);
        }
        return current;
    }

    public void deleteValue(int value) {
        root = deleteElement(root, value);
    }

    @Override
    public int findMinValue(Node node) {
        return node.left == null ? node.value : findMinValue(node.left);
    }

    @Override
    public Node minValue(Node node) {
        for (; node.left != null; node = node.left);
        return node;
    }

    @Override
    public Node maxValue(Node node) {
        for (; node.right != null; node = node.right);
        return node;
    }

    @Override
    public Node findPredecesor(int value) {
        Node current = root;
        Node predecessor = null;
        while (current != null) {
            if (value == current.value) {
                if (current.left != null) {
                    predecessor = maxValue(current.left);
                }
                break;
            } else if (value < current.value) {
                current = current.left;
            } else {
                predecessor = current;
                current = current.right;
            }
        }
        return predecessor;
    }

    @Override
    public Node findSuccessor(int value) {
        Node current = root;
        Node successor = null;
        while (current != null) {
            if (value == current.value) {
                if (current.right != null) {
                    successor = minValue(current.right);
                }
                break;
            } else if (value < current.value) {
                successor = current;
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return successor;
    }

    @Override
    public void traverseInOrderDFS(Node node) {
        if (node != null) {
            traverseInOrderDFS(node.left);
            System.out.print(node.value + " ");
            traverseInOrderDFS(node.right);
        }
    }

    @Override
    public void traversePreOrderDFS(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            traversePreOrderDFS(node.left);
            traversePreOrderDFS(node.right);
        }
    }

    @Override
    public void traversePostOrderDFS(Node node) {
        if (node != null) {
            traversePostOrderDFS(node.left);
            traversePostOrderDFS(node.right);
            System.out.print(node.value + " ");
        }
    }

    @Override
    public void traverseLevelOrder() {
        if (root == null) {
            return;
        }
        Queue<Node> nodesList = new LinkedList<>();
        nodesList.add(root);
        System.out.print("The traversal level order of binary tree:");
        while (!nodesList.isEmpty()) {
            Node node = nodesList.poll();
            System.out.print(" " + node.value);
            if (node.left != null) {
                nodesList.add(node.left);
            }
            if (node.right != null) {
                nodesList.add(node.right);
            }
        }
    }
}
