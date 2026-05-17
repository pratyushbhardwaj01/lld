package com.example.lld.template.tictactoe.definations.impl;

import com.example.lld.template.tictactoe.enums.PlayingSymbol;
import com.example.lld.template.tictactoe.definations.WinningStrategy;
import com.example.lld.template.tictactoe.models.Board;
import com.example.lld.template.tictactoe.models.Cell;
import com.example.lld.template.tictactoe.models.Move;

public class RowColWinningStrategy implements WinningStrategy {
    @Override
    public Boolean checkWinner(Board board, Move move) {
        Integer boardSize = board.getBoardSize();
        PlayingSymbol symbol = move.getSymbol();
        Integer row = move.getRow();
        Integer col = move.getCol();
        if (checkRowWise(board, symbol, row, boardSize)) {
            return true;
        }
        if (checkColumnWise(board, symbol, col, boardSize)) {
            return true;
        }
        return false;
    }

    private Boolean checkRowWise(Board board, PlayingSymbol symbol, Integer row, Integer size) {
        for (int i = 0; i < size; i++) {
            Cell cell = board.getCell(row, i);
            PlayingSymbol cellSymbol = cell.getPlayingSymbol();
            if (cellSymbol != symbol) {
                return false;
            }
        }
        return true;
    }

    private Boolean checkColumnWise(Board board, PlayingSymbol symbol, Integer col, Integer size) {
        for (int i = 0; i < size; i++) {
            Cell cell = board.getCell(i, col);
            PlayingSymbol cellSymbol = cell.getPlayingSymbol();
            if (cellSymbol != symbol) {
                return false;
            }
        }
        return true;
    }
}
