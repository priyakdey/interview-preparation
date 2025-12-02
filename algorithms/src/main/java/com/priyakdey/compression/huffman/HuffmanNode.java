package com.priyakdey.compression.huffman;

/**
 * @author Priyak Dey
 */
public final class HuffmanNode extends HuffmanAbstractNode {

    private final HuffmanAbstractNode left;
    private final HuffmanAbstractNode right;

    public HuffmanNode(HuffmanAbstractNode left, HuffmanAbstractNode right) {
        super(left.getFreq() + right.getFreq());
        this.left = left;
        this.right = right;
    }

    public HuffmanAbstractNode getLeft() {
        return left;
    }

    public HuffmanAbstractNode getRight() {
        return right;
    }
}
