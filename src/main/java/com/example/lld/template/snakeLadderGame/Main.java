package com.example.lld.template.snakeLadderGame;

import com.example.lld.template.snakeLadderGame.definations.MovingEntity;
import com.example.lld.template.snakeLadderGame.enums.MovingEntityType;
import com.example.lld.template.snakeLadderGame.models.*;
import com.example.lld.template.snakeLadderGame.service.GameService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Player player1 = createPlayer("101", "Pratyush", 1);
        Player player2 = createPlayer("102", "Mahendra", 1);
        Player player3 = createPlayer("103", "Pawan", 1);
        List<Player> playerList = new ArrayList<>();
        playerList.add(player1);
        playerList.add(player2);
        playerList.add(player3);
        Dice dice = new Dice(6);
        Board board = new Board(5);
        MovingEntity s1 = createSnake(10, 2);
        MovingEntity s2 = createSnake(99, 1);
//        MovingEntity l1 = createLadder(3, 90);
        MovingEntity l2 = createLadder(11, 45);
        board.addMovingEntity(s1);
        board.addMovingEntity(s2);
//        board.addMovingEntity(l1);
        board.addMovingEntity(l2);
        GameService g1 = new GameService(dice, board, playerList, 0);
        g1.startGame();

    }

    public static Player createPlayer(String id, String name, int currentPos) {
        return new Player(id, name, currentPos);
    }

    public static MovingEntity createSnake(int startPos, int endPos) {
        return new Snake(startPos, endPos, MovingEntityType.SNAKE);
    }

    public static MovingEntity createLadder(int startPos, int endPos) {
        return new Ladder(startPos, endPos, MovingEntityType.LADDER);
    }
}
