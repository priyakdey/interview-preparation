package com.priyakdey.bst;

/**
 * @author priyakdey
 */
public class BST {

    public int value;
    public BST left = null;
    public BST right = null;

    public BST(int value) {
        this.value = value;
    }

    public void insert(int value) {
        if (value < this.value) {
            if (left == null) {
                left = new BST(value);
            } else {
                left.insert(value);
            }
        } else {
            if (right == null) {
                right = new BST(value);
            } else {
                right.insert(value);
            }
        }
    }

}
