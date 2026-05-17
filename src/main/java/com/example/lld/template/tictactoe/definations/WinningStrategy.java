package com.example.lld.template.tictactoe.definations;

import com.example.lld.template.tictactoe.models.Board;
import com.example.lld.template.tictactoe.models.Move;

public interface WinningStrategy {
    public Boolean checkWinner(Board board, Move move);
}
