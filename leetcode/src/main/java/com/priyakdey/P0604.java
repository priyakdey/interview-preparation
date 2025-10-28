package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class P0604 {

    private final String compressedString;
    private char currCh;
    private int currCount;
    private int cursor;

    public P0604(String compressedString) {
        this.compressedString = compressedString;
        moveNext();
    }

    public char next() {
        if (currCount == 0 && cursor == compressedString.length()) {
            return ' ';
        }

        char ch = currCh;
        currCount--;

        if (cursor < compressedString.length() && currCount == 0) {
            moveNext();
        }

        return ch;
    }

    public boolean hasNext() {
        return currCount > 0 || cursor < compressedString.length();
    }

    private void moveNext() {
        currCh = compressedString.charAt(cursor);
        int start = cursor + 1;
        do {
            cursor++;
        } while (cursor < compressedString.length() && Character.isDigit(compressedString.charAt(cursor)));

        currCount = Integer.parseInt(compressedString.substring(start, cursor));
    }

}
