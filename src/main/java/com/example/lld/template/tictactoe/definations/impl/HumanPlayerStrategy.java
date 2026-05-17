package com.example.lld.template.tictactoe.definations.impl;

import com.example.lld.template.tictactoe.definations.PlayerStrategy;
import com.example.lld.template.tictactoe.enums.PlayingSymbol;
import com.example.lld.template.tictactoe.models.Board;
import com.example.lld.template.tictactoe.models.Move;

import java.util.Scanner;

public class HumanPlayerStrategy implements PlayerStrategy {
    private static Scanner sc = new Scanner(System.in);

    @Override
    public Move makeMove(Board board, PlayingSymbol playingSymbol) {
        System.out.println("Enter the row...");
        int row = sc.nextInt();
        System.out.println("Enter the col...");
        int col = sc.nextInt();
        return new Move(row, col, playingSymbol);


    }
}
