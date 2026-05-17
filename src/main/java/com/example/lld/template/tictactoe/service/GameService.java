package com.example.lld.template.tictactoe.service;

import com.example.lld.template.tictactoe.definations.PlayerStrategy;
import com.example.lld.template.tictactoe.enums.GameStatus;
import com.example.lld.template.tictactoe.enums.PlayingSymbol;
import com.example.lld.template.tictactoe.definations.WinningStrategy;
import com.example.lld.template.tictactoe.models.Board;
import com.example.lld.template.tictactoe.models.Cell;
import com.example.lld.template.tictactoe.models.Move;
import com.example.lld.template.tictactoe.models.Player;

import java.util.List;

public class GameService {
    private Board board;
    private Player currentPlayer;
    private List<Player> players;
    private Player winningPlayer;
    private List<WinningStrategy> strategies;
    private GameStatus status;

    private GameService(Builder builder) {
        this.board = builder.board;
        this.currentPlayer = builder.currentPlayer;
        this.players = builder.players;
        this.strategies = builder.strategies;
        this.status = builder.status;
    }

    public static class Builder {
        private Board board;
        private Player currentPlayer;
        private List<Player> players;
        private List<WinningStrategy> strategies;
        private GameStatus status;

        public Builder setBoard(Board board) {
            this.board = board;
            return this;
        }

        public Builder setCurrentPlayer(Player player) {
            this.currentPlayer = player;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setStrategies(List<WinningStrategy> strategies) {
            this.strategies = strategies;
            return this;
        }

        public Builder setGameStatus(GameStatus gameStatus) {
            this.status = gameStatus;
            return this;
        }

        public GameService build() {
            return new GameService(this);
        }
    }

    public void startGame() {
        Integer currentPlayerIndex = 0;
        while (this.status == GameStatus.IN_PROGRESS) {
            board.printBoard();
            PlayingSymbol currentPlayerSymbol = currentPlayer.getPlayerSymbol();
            PlayerStrategy playerStrategy = currentPlayer.getPlayerStrategy();
            Move move = playerStrategy.makeMove(board,currentPlayerSymbol);
            int row = move.getRow();
            int col = move.getCol();
            Cell cell = board.getCell(row, col);

            if (cell == null) {
                System.out.println("The move is not valid please try again!...");
                continue;
            }
            if (cell.isCellEmpty() == false) {
                System.out.println("Cell is already occupied try again!...");
                continue;

            }

            cell.setPlayingSymbol(currentPlayerSymbol);
            for (WinningStrategy strategy : strategies) {
                if (strategy.checkWinner(board, move)) {
                    this.status = GameStatus.WON;
                    this.winningPlayer = currentPlayer;
                    System.out.println("The winner is " + currentPlayer.getPlayerSymbol());
                    return;
                }
            }

            if (board.isBoardFull()) {
                this.status = GameStatus.DRAW;
                System.out.println("The game draws...");
                return;
            }
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
            currentPlayer = players.get(currentPlayerIndex);
        }
    }

}
