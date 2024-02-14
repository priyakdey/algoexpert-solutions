package com.priyakdey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class TournamentWinner {

    public String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        Map<String, Integer> scorecard = new HashMap<>();
        int winningPoints = 3;

        for (int i = 0, size = competitions.size(); i < size; i++) {
            String homeTeam = competitions.get(i).getFirst();
            String awayTeam = competitions.get(i).getLast();

            if (results.get(i) == 1) {
                scorecard.compute(homeTeam, (_, v) -> v == null ? winningPoints : v + winningPoints);
                scorecard.putIfAbsent(awayTeam, 0);
            } else {
                scorecard.compute(awayTeam, (_, v) -> v == null ? winningPoints : v + winningPoints);
                scorecard.putIfAbsent(homeTeam, 0);
            }
        }

        return scorecard.entrySet().stream().max(Map.Entry.comparingByValue())
            .orElseThrow(IllegalArgumentException::new).getKey();

    }

}
