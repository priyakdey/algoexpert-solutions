package com.priyakdey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class TournamentWinner {

    // use a hashmap to keep a scoreboard for winner

    public String tournamentWinner(ArrayList<ArrayList<String>> competitions,
                                   ArrayList<Integer> results) {
        assert competitions.size() == results.size();

        String champion = "";
        int maxScore = 0;
        Map<String, Integer> scoreboard = new HashMap<>();

        for (int i = 0; i < competitions.size(); i++) {
            String home = competitions.get(i).get(0);
            String away = competitions.get(i).get(1);
            String winner = results.get(i) == 1 ? home : away;
            int score = scoreboard.compute(winner,
                    (_, v) -> v == null ? 1 : v + 1);
            if (score > maxScore) {
                maxScore = score;
                champion = winner;
            }
        }

        return champion;
    }

}
