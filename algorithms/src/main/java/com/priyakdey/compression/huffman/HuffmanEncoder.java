package com.priyakdey.compression.huffman;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Path;
import java.util.*;

/**
 * @author Priyak Dey
 */
public class HuffmanEncoder {

    public void encode(String data) {
        Map<Character, Long> freqMap = generateFreqMap(data);
        if (freqMap.size() < 2) {
            throw new IllegalArgumentException("not even 2 characters");
        }

        PriorityQueue<HuffmanLeafNode> pq = new PriorityQueue<>(freqMap.size(),
                Comparator.comparingLong(HuffmanLeafNode::getFreq));

        for (Map.Entry<Character, Long> entry : freqMap.entrySet()) {
            char ch = entry.getKey();
            long freq = entry.getValue();
            pq.offer(new HuffmanLeafNode(ch, freq));
        }

        System.out.println(pq);

        HuffmanLeafNode left = Objects.requireNonNull(pq.poll());
        HuffmanLeafNode right = Objects.requireNonNull(pq.poll());
        HuffmanNode root = new HuffmanNode(left, right);

        while (!pq.isEmpty()) {
            HuffmanLeafNode leftChild = pq.poll();
            root = new HuffmanNode(leftChild, root);
        }

        Map<Character, String> prefixMap = new HashMap<>();
        StringBuilder prefixBuilder = new StringBuilder();

        generatePrefix(root, prefixMap, prefixBuilder);

        System.out.println(prefixMap);
    }

    private void generatePrefix(HuffmanAbstractNode node,
                                Map<Character, String> prefixMap,
                                StringBuilder prefixBuilder) {
        if (node instanceof HuffmanLeafNode) {
            prefixMap.put(((HuffmanLeafNode) node).getChar(),
                    prefixBuilder.toString());
            return;
        }

        prefixBuilder.append(0);
        generatePrefix(((HuffmanNode) node).getLeft(), prefixMap,
                prefixBuilder);
        prefixBuilder.deleteCharAt(prefixBuilder.length() - 1);

        prefixBuilder.append(1);
        generatePrefix(((HuffmanNode) node).getRight(), prefixMap,
                prefixBuilder);
        prefixBuilder.deleteCharAt(prefixBuilder.length() - 1);
    }

    private Map<Character, Long> generateFreqMap(String data) {
        Map<Character, Long> map = new HashMap<>();
        for (char ch : data.toCharArray()) {
            map.compute(ch, (_, v) -> v == null ? 1 : v + 1);
        }

        return map;
    }

    static void main() {
        String inputPath = "/home/priyakdey/dev/github.com/priyakdey/interview-preparation/algorithms/src/main/resources/english.txt";
        Path path = Path.of(inputPath);

        File file = path.toFile();
        try (BufferedInputStream bis =
                     new BufferedInputStream(new FileInputStream(file))) {
            byte[] bytes = bis.readAllBytes();
            new HuffmanEncoder().encode(new String(bytes));
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

    }

}
