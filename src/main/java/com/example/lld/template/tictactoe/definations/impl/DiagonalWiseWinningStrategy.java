package com.example.lld.template.tictactoe.definations.impl;

import com.example.lld.template.tictactoe.enums.PlayingSymbol;
import com.example.lld.template.tictactoe.definations.WinningStrategy;
import com.example.lld.template.tictactoe.models.Board;
import com.example.lld.template.tictactoe.models.Cell;
import com.example.lld.template.tictactoe.models.Move;

public class DiagonalWiseWinningStrategy implements WinningStrategy {
    @Override
    public Boolean checkWinner(Board board, Move move) {
        PlayingSymbol currentSymbol = move.getSymbol();
        Integer size = board.getBoardSize();
        if (checkInMainDiagonal(board, currentSymbol, size)) {
            return true;
        }
        if (checkInAntiDiagonal(board, currentSymbol, size)) {
            return true;
        }
        return false;

    }

    private Boolean checkInAntiDiagonal(Board board, PlayingSymbol symbol, Integer size) {
        for (int i = 0; i < size; i++) {
            Integer row = i;
            Integer col = size - 1 - i;
            Cell cell = board.getCell(row, col);
            PlayingSymbol cellSymbol = cell.getPlayingSymbol();
            if (cellSymbol != symbol) {
                return false;
            }
        }
        return true;
    }

    private Boolean checkInMainDiagonal(Board board, PlayingSymbol symbol, Integer size) {
        for (int i = 0; i < size; i++) {
            Integer row = i;
            Integer col = i;
            Cell cell = board.getCell(row, col);
            PlayingSymbol cellSymbol = cell.getPlayingSymbol();
            if (cellSymbol != symbol) {
                return false;
            }
        }
        return true;
    }
}
