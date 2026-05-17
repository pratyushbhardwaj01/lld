package com.example.lld.template.tictactoe.models;

import com.example.lld.template.tictactoe.definations.PlayerStrategy;
import com.example.lld.template.tictactoe.enums.PlayingSymbol;


public class Player {
    private PlayingSymbol playingSymbol;
    private String playerName;
    private PlayerStrategy strategy;

    public Player(PlayingSymbol playingSymbol, String playerName, PlayerStrategy strategy) {
        this.playerName = playerName;
        this.playingSymbol = playingSymbol;
        this.strategy = strategy;
    }

    public PlayingSymbol getPlayerSymbol() {
        return this.playingSymbol;
    }

    public PlayerStrategy getPlayerStrategy() {
        return this.strategy;
    }

}
