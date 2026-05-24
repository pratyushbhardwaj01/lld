package com.example.lld.template.snakeLadderGame.service;

import com.example.lld.template.snakeLadderGame.enums.GameStatus;
import com.example.lld.template.snakeLadderGame.models.Board;
import com.example.lld.template.snakeLadderGame.models.Dice;
import com.example.lld.template.snakeLadderGame.models.Player;

import java.util.Comparator;
import java.util.List;

public class GameService {
    private Dice dice;
    private Board board;
    private List<Player> playerList;
    private Player currentPlayer;
    private int rank;
    private int consecutiveSixes;
    private int currentPlayerIndex;

    public GameService(Dice dice, Board board, List<Player> playerList, int currentPlayerIndex) {
        this.dice = dice;
        this.board = board;
        this.playerList = playerList;
        this.currentPlayerIndex = currentPlayerIndex;
        this.rank = 0;
        this.consecutiveSixes = 0;
    }

    public boolean canPlay() {
        return this.rank != playerList.size();
    }

    public boolean canMove(Player player, int pos) {
        return pos <= board.getBoardSize() && player.getRank() == -1;

    }

    public int changeTurn(int diceNumber) {
        consecutiveSixes = diceNumber == 6 ? consecutiveSixes + 1 : 0;
        if (consecutiveSixes == 3 || diceNumber != 6) {
            if (consecutiveSixes == 3) {
                System.out.printf("Turn change for player %d because of consecutive sixes", currentPlayerIndex);
                System.out.println();
            }
            return (currentPlayerIndex + 1) % playerList.size();

        }
        return currentPlayerIndex;

    }

    public void printCurrentGameStatus() {
        for (Player player : playerList) {
            System.out.printf("%s is at position %d", player.getName(), player.getCurrentPos());
            System.out.println();
        }
    }

    public void printRanks() {
        playerList.sort(Comparator.comparingInt(Player::getRank));
        for (Player player : playerList) {
            System.out.printf("%s rank is %d", player.getName(), player.getRank());
            System.out.println();
        }
    }

    public int getNextDiceNumber() {
        int consecutiveSixes = 0;
        int totalCnt = 0;
        while (true) {
            int number = dice.rollDice();
            totalCnt += number;
            if (number == 6) {
                consecutiveSixes++;
            } else {
                consecutiveSixes = 0;
                break;
            }
            if (consecutiveSixes == 3) {
                break;
            }
        }
        return consecutiveSixes == 3 ? 0 : totalCnt;

    }

    public void startGame() {
        while (canPlay()) {
            int totalDiceNumber = getNextDiceNumber();
            Player currentPlayer = playerList.get(currentPlayerIndex);
            System.out.printf("%s got %d on dice", currentPlayer.getName(), totalDiceNumber);
            System.out.println();
            int currentPosition = currentPlayer.getCurrentPos();
            int updatedPosition = board.getUpdatePosition(currentPosition + totalDiceNumber);
            if (canMove(currentPlayer, updatedPosition)) {
                currentPlayer.updateCurrentPosition(updatedPosition);
                if (board.isAtLastPos(updatedPosition)) {
                    currentPlayer.updateRank(this.rank + 1);
                    this.rank++;
                }

            }
            currentPlayerIndex = (currentPlayerIndex + 1) % playerList.size();
            printCurrentGameStatus();
        }
        printRanks();
    }

}
