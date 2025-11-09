package com.priyakdey.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class TournamentWinner {

    // Use a map to track the scores of each team.

    public String tournamentWinner(ArrayList<ArrayList<String>> competitions,
                                   ArrayList<Integer> results) {
        Map<String, Integer> scorecard = new HashMap<>();

        String tournamentWinner = "";
        int highestScore = 0;

        for (int i = 0; i < competitions.size(); i++) {
            int result = results.get(i);
            String matchWinner = competitions.get(i).get(result ^ 1);
            int score = scorecard.compute(matchWinner,
                    (_, v) -> v == null ? 1 : v + 3);
            if (score > highestScore) {
                highestScore = score;
                tournamentWinner = matchWinner;
            }
        }

        return tournamentWinner;
    }

}
