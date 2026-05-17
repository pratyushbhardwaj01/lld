package com.example.lld.template.tictactoe.models;

import com.example.lld.template.tictactoe.enums.PlayingSymbol;


public class Move {
    private Integer row;
    private Integer col;
    private PlayingSymbol symbol;

    public Move(Integer row, Integer col, PlayingSymbol symbol) {
        this.row = row;
        this.col = col;
        this.symbol = symbol;
    }


    public PlayingSymbol getSymbol() {
        return this.symbol;
    }

    public Integer getRow() {
        return this.row;

    }

    public Integer getCol() {
        return this.col;
    }
}
