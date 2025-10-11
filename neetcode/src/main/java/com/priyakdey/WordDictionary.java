package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class WordDictionary {

    final Node root;

    public WordDictionary() {
        root = new Node('\0');
    }

    public void addWord(String word) {
        Node curr = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new Node(ch);
            }
            curr = curr.children[index];
        }

        curr.end = true;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }

    public boolean search(String word, int index, Node curr) {
        if (index == word.length()) {
            return curr.end;
        }

        char ch = word.charAt(index);

        if (ch == '.') {
            for (Node child : curr.children) {
                if (child != null && search(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            Node child = curr.children[ch - 'a'];
            return child != null && search(word, index + 1, child);
        }
    }

    private static class Node {
        final char ch;
        final Node[] children;
        boolean end;

        private Node(char ch) {
            this.ch = ch;
            children = new Node[26];
        }
    }

}
