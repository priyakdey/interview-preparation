package com.priyakdey.compression.huffman;

/**
 * @author Priyak Dey
 */
public final class HuffmanLeafNode extends HuffmanAbstractNode {
    private final char ch;

    public HuffmanLeafNode(char ch, long freq) {
        super(freq);
        this.ch = ch;
    }

    public char getChar() {
        return ch;
    }

    public String toString() {
        return String.format("{char = 0x%02x(%c), freq = %d}", (int) ch, ch,
                super.getFreq());
    }

}
