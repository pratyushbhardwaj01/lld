package com.example.lld.template.tictactoe.models;

import com.example.lld.template.tictactoe.enums.PlayingSymbol;

public class Cell {
    private PlayingSymbol symbol;

    public PlayingSymbol getPlayingSymbol() {
        return this.symbol;
    }

    public void setPlayingSymbol(PlayingSymbol symbol) {
        this.symbol = symbol;
    }

    public Boolean isCellEmpty() {
        return this.symbol == null;
    }
}
