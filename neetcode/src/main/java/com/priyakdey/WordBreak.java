package com.priyakdey;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Priyak Dey
 */
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        Boolean[][] cache = new  Boolean[length + 1][length + 1];
        return wordBreak(s, 0, 1, new HashSet<>(wordDict), cache);
    }

    private boolean wordBreak(String s, int start, int end, Set<String> wordDict,
                              Boolean[][] cache) {
        String word = s.substring(start, end);
        if (end == s.length()) {
            return wordDict.contains(word);
        }

        if (cache[start][end] != null) {
            return cache[start][end];
        }

        boolean canBreak = wordBreak(s, start, end + 1, wordDict, cache);

        if (wordDict.contains(word)) {
            canBreak = canBreak || wordBreak(s, end, end + 1, wordDict, cache);
        }

        cache[start][end] = canBreak;
        return canBreak;
    }

}
