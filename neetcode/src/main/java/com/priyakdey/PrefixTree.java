package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class PrefixTree {

    private final Node root;

    public PrefixTree() {
        this.root = new Node('\0');
    }

    public void insert(String word) {
        Node curr = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new Node(c);
            }
            curr = curr.children[index];
        }

        curr.end = true;
    }

    public boolean search(String word) {
        Node node = traverse(word);
        if (node == null) return false;
        return node.end;
    }

    public boolean startsWith(String prefix) {
        return traverse(prefix) != null;
    }

    private Node traverse(String word) {
        Node curr = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) {
                return null;
            }
            curr = curr.children[index];
        }

        return curr;
    }

    private static class Node {
        final char ch;
        final Node[] children;
        boolean end;

        private Node(char ch) {
            this.ch = ch;
            this.children = new Node[26];
        }
    }

}
