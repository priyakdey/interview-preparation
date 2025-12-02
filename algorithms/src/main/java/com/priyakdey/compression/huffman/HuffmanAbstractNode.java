package com.priyakdey.compression.huffman;

/**
 * @author Priyak Dey
 */
public abstract sealed class HuffmanAbstractNode
        permits HuffmanLeafNode, HuffmanNode {
    private final long freq;

    public HuffmanAbstractNode(long freq) {
        this.freq = freq;
    }

    public long getFreq() {
        return freq;
    }
}
