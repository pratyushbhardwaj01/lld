package com.example.lld.test.snakeLadderGame2.models;

import com.example.lld.test.snakeLadderGame2.enums.MovingEntityType;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> currentPlayerList;
    private Player currentPlayer;
    private final Dice dice;
    private static Game game;
    private final Maze maze;
    int rank = 0;

    private Game() {
        this.dice = new Dice();
        this.currentPlayerList = new ArrayList<>();
        this.maze = new Maze(6);
    }

    public synchronized static Game getGameInstance() {
        if (game == null) {
            game = new Game();
        }
        return game;
    }

    public synchronized void setPlayerList(List<Player> playerList) {
        System.out.println(playerList.size());
        this.currentPlayerList = playerList;
    }

    public int getNumber() {
        int consecutiveSixes = 0;
        int totalPoint = 0;
        boolean isTrue = true;
        while (isTrue) {
            int x = dice.rollDice();
            if (x != 6) {
                totalPoint += x;
                isTrue = false;
            } else {
                consecutiveSixes++;
                if (consecutiveSixes == 3) {
                    totalPoint = 0;
                    isTrue = false;
                } else {
                    totalPoint += x;
                }
            }

        }
        return totalPoint;
    }


    public void startGame() {
        int turn = 0;
        while (rank < currentPlayerList.size()) {
            currentPlayer = currentPlayerList.get(turn);
            int number = getNumber();
            int finalPosition = maze.getUpdatedPlayerPosition(number, currentPlayer);
            System.out.println(currentPlayer.getName() + " " + finalPosition);
            currentPlayer.setCurrentPosition(finalPosition);
            if (maze.hasReachedDestination(currentPlayer) && currentPlayer.getRank() == -1) {
                this.rank++;
                currentPlayer.setRank(rank);

            }
            turn = (turn + 1) % currentPlayerList.size();
        }
        printPlayerOrder();
    }

    public void printPlayerOrder() {
        currentPlayerList.sort((a, b) -> Integer.compare(a.getRank(), b.getRank()));
        for (Player player : currentPlayerList) {
            System.out.println("rank " + player.getRank() + ": " + player.getName());
        }
    }

    public void addMovingEntity(int start, int end, MovingEntityType movingEntityType) {
        maze.addMovingEntity(start, end, movingEntityType);
    }
}
