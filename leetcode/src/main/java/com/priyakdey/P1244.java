package com.priyakdey;

import java.util.*;

/**
 * @author Priyak Dey
 */
public class P1244 {

    private final Map<Integer, Player> table;
    private final PriorityQueue<Player> board;

    public P1244() {
        this.table = new HashMap<>();
        this.board = new PriorityQueue<>(Comparator.comparingInt(Player::getScore).reversed());
    }

    public void addScore(int playerId, int score) {
        Player player;
        if (table.containsKey(playerId)) {
            player = table.get(playerId);
            board.remove(player);
            player.updateScore(score);
        } else {
            player = new Player(playerId, score);
            table.put(playerId, player);
        }
        board.offer(player);
    }

    public int top(int K) {
        List<Player> players = new ArrayList<>(K);

        while (players.size() < K) {
            players.add(board.poll());
        }

        int score = 0;

        while (!players.isEmpty()) {
            Player player = players.removeFirst();
            score += player.getScore();
            board.offer(player);
        }

        return score;
    }

    public void reset(int playerId) {
        Player player = table.get(playerId);
        board.remove(player);
        player.resetScore();
        board.offer(player);
    }

    private class Player {
        private final int playerId;
        private int score;

        private Player(int playerId, int score) {
            this.playerId = playerId;
            this.score = score;
        }

        public int getPlayerId() {
            return playerId;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        private void resetScore() {
            this.score = 0;
        }

        private void updateScore(int score) {
            this.score += score;
        }

        @Override
        public String toString() {
            return "Player{" +
                    "playerId=" + playerId +
                    ", score=" + score +
                    '}';
        }
    }

}
