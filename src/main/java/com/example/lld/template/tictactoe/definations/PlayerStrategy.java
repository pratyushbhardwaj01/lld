package com.example.lld.template.tictactoe.definations;

import com.example.lld.template.tictactoe.enums.PlayingSymbol;
import com.example.lld.template.tictactoe.models.Board;
import com.example.lld.template.tictactoe.models.Move;


public interface PlayerStrategy {
    public Move makeMove(Board board, PlayingSymbol symbol);
}
