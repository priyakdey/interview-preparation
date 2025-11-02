package com.priyakdey;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author Priyak Dey
 */
public class P0588 {

    private final Inode root;

    public P0588() {
        this.root = new Inode("", true);
    }

    public List<String> ls(String path) {
        String[] parts = path.split("/");

        Inode curr = root;

        for (int i = 1; i < parts.length; i++) {
            String part = parts[i];
            curr = curr.children.get(part);
        }

        if (curr.isDir) {
            return new ArrayList<>(curr.children.keySet());
        }

        return List.of(curr.name);
    }

    public void mkdir(String path) {
        String[] parts = path.split("/");
        Inode curr = root;

        for (int i = 1; i < parts.length; i++) {
            String part = parts[i];
            if (!curr.children.containsKey(part)) {
                curr.children.put(part, new Inode(part, true));
            }

            curr = curr.children.get(part);
        }
    }

    public void addContentToFile(String filePath, String content) {
        String[] parts = filePath.split("/");
        Inode curr = root;

        for (int i = 1; i < parts.length; i++) {
            String part = parts[i];
            if (!curr.children.containsKey(part)) {
                curr.children.put(part, new Inode(part, i < parts.length - 1));
            }

            curr = curr.children.get(part);
        }

        curr.appendContent(content);
    }

    public String readContentFromFile(String filePath) {
        String[] parts = filePath.split("/");
        Inode curr = root;

        for (int i = 1; i < parts.length; i++) {
            String part = parts[i];
            curr = curr.children.get(part);
        }

        return curr.getContent();
    }

    private static class Inode {
        final String name;
        final boolean isDir;
        final StringBuilder sb;
        final TreeMap<String, Inode> children;

        private Inode(String name, boolean isDir) {
            this.name = name;
            this.isDir = isDir;
            this.sb = isDir ? null : new StringBuilder();
            this.children = new TreeMap<>();
        }

        private void appendContent(String content) {
            this.sb.append(content);
        }

        private String getContent() {
            return this.sb.toString();
        }
    }

}
