package com.example.lld.template.tictactoe.definations.impl;

import com.example.lld.template.tictactoe.definations.PlayerStrategy;
import com.example.lld.template.tictactoe.enums.PlayingSymbol;
import com.example.lld.template.tictactoe.models.Board;
import com.example.lld.template.tictactoe.models.Move;

import java.util.Random;
import java.util.Scanner;

public class BotPlayerStrategy implements PlayerStrategy {
    private static Scanner sc = new Scanner(System.in);

    @Override
    public Move makeMove(Board board, PlayingSymbol playingSymbol) {
        int size = board.getBoardSize();
        Random rand = new Random();
        int row = rand.nextInt(size);
        int col = rand.nextInt(size);
        return new Move(row, col, playingSymbol);
    }

}
