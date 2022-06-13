package main.java.wissen;

import java.util.*;

public class ClimbingLeaderboard {

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        // Write your code here
        int rank = 1;
        List<Integer> rankAfterEachGame = new ArrayList<>();

        Map<Integer, Integer> rankMap = new HashMap<>();
        for(Integer score : ranked) {
            if(!rankMap.containsKey(score)) {
                rankMap.put(score, rank++);
            }
        }

        int initial = ranked.size() - 1;
        for(Integer score : player) {
            for (int i = initial; i >= 0; i--) {
                if(score >= ranked.get(i)) {
                    rank = rankMap.get(ranked.get(i));
                    initial -= 1;
                } else {
                    break;
                }
            }
            rankAfterEachGame.add(rank);
        }
        return rankAfterEachGame;
    }

    public static void main(String[] args) {
        List<Integer> ranked = Arrays.asList(100, 90, 90, 80);
        List<Integer> player = Arrays.asList(70, 80, 105); // [4, 3, 1]
//        climbingLeaderboard(ranked, player);
        System.out.println(climbingLeaderboard(ranked, player));
    }
}
