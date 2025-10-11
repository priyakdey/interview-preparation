package com.priyakdey;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class WordSearchII {

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.addWord(word);
        }

        return trie.findWords(board);
    }

    private static class Trie {
        private final Node root;

        private Trie() {
            this.root = new Node('\0');
        }

        private void addWord(String word) {
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

        private List<String> findWords(char[][] board) {
            int rows = board.length;
            int cols = board[0].length;
            int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

            StringBuilder sb = new StringBuilder();
            List<String> acc = new ArrayList<>();

            for (Node node : root.children) {
                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < cols; col++) {
                        dfs(board, row, col, rows, cols, node, sb, acc, directions);
                        sb.setLength(0);
                    }
                }
            }

            return acc;
        }

        private void dfs(char[][] board, int row, int col, int rows, int cols,
                         Node node, StringBuilder sb, List<String> acc, int[][] directions) {
            if (row < 0 || row >= rows || col < 0 || col >= cols || node == null) return;
            char c = board[row][col];
            if (c == '.' || c != node.ch) return;

            sb.append(c);
            board[row][col] = '.';

            if (node.end) {
                acc.add(sb.toString());
                node.end = false;       // make sure no duplicates
            }

            for (int[] direction : directions) {
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];
                for (Node child : node.children) {
                    dfs(board, nextRow, nextCol, rows, cols, child, sb, acc, directions);
                }
            }

            board[row][col] = c;
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    private static class Node {
        private final char ch;
        private final Node[] children;
        private boolean end;

        private Node(char ch) {
            this.ch = ch;
            this.children = new Node[26];
        }
    }

}
