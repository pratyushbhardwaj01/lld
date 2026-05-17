package com.example.lld.template.tictactoe.models;

import com.example.lld.template.tictactoe.enums.PlayingSymbol;

public class Board {
    private Cell[][] board;
    private Integer size;

    public Board(Integer size) {
        this.size = size;
        this.board = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                PlayingSymbol symbol = this.board[i][j].getPlayingSymbol();
                System.out.print(symbol == null ? "_" : symbol);
            }
            System.out.println();
        }
    }

    public Integer getBoardSize() {
        return this.size;
    }

    public Cell getCell(Integer row, Integer col) {
        if (row < 0 || col < 0 || row >= this.size || col >= this.size) {
            return null;
        }
        return this.board[row][col];

    }

    public Boolean isBoardFull() {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                PlayingSymbol symbol = board[i][j].getPlayingSymbol();
                if (symbol == null) {
                    return false;
                }

            }
        }
        return true;
    }
}
