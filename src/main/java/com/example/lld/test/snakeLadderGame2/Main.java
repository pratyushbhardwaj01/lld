package com.example.lld.test.snakeLadderGame2;

import com.example.lld.test.snakeLadderGame2.enums.MovingEntityType;
import com.example.lld.test.snakeLadderGame2.models.Game;
import com.example.lld.test.snakeLadderGame2.models.Player;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Game game = Game.getGameInstance();
        Player player1 = new Player("Pratyush");
        Player player2 = new Player("Aman");
        Player player3 = new Player("Atul");
        List<Player> playerList  = new ArrayList<>();
        playerList.add(player1);
        playerList.add(player2);
        playerList.add(player3);
        game.setPlayerList(playerList);
        game.addMovingEntity(4, 1, MovingEntityType.SNAKE);
        game.addMovingEntity(3, 6, MovingEntityType.LADDER);
        game.startGame();
    }
}
