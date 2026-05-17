package com.example.lld.template.tictactoe;

import com.example.lld.template.tictactoe.definations.impl.BotPlayerStrategy;
import com.example.lld.template.tictactoe.definations.impl.HumanPlayerStrategy;
import com.example.lld.template.tictactoe.enums.GameStatus;
import com.example.lld.template.tictactoe.enums.PlayingSymbol;
import com.example.lld.template.tictactoe.definations.WinningStrategy;
import com.example.lld.template.tictactoe.definations.impl.DiagonalWiseWinningStrategy;
import com.example.lld.template.tictactoe.definations.impl.RowColWinningStrategy;
import com.example.lld.template.tictactoe.models.Board;
import com.example.lld.template.tictactoe.models.Player;
import com.example.lld.template.tictactoe.service.GameService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(3);
        HumanPlayerStrategy humanPlayerStrategy = new HumanPlayerStrategy();
        BotPlayerStrategy botPlayerStrategy = new BotPlayerStrategy();
        Player player1 = new Player(PlayingSymbol.X, "Pratyush",humanPlayerStrategy );
        Player player2 = new Player(PlayingSymbol.O, "Computer", botPlayerStrategy);
        List<Player> players = new ArrayList();
        players.add(player1);
        players.add(player2);
        WinningStrategy rowColWinningStrategy = new RowColWinningStrategy();
        WinningStrategy diagonalWinningStrategy = new DiagonalWiseWinningStrategy();
        List<WinningStrategy> strategies = new ArrayList();
        strategies.add(rowColWinningStrategy);
        strategies.add(diagonalWinningStrategy);
        GameService gameService = new GameService.Builder().setBoard(board).setCurrentPlayer(player1).setPlayers(players).setStrategies(strategies).setGameStatus(GameStatus.IN_PROGRESS).build();
        gameService.startGame();

    }
}
