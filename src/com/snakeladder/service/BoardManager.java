package com.snakeladder.service;

import com.snakeladder.model.Board;
import com.snakeladder.model.Snake;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class BoardManager {

    Board board;

    public BoardManager(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    public boolean snakeHeadExists(int pos){
        // there can't be multiple snake heads at one point
        return !board.getSnakes().stream().filter(snake -> snake.getHead()==pos).collect(Collectors.toList()).isEmpty();
    }

    public int snakeTailpoint(int head){
        // there can't be multiple snake heads at one point
        return board.getSnakes().stream().filter(snake -> snake.getHead()==head).collect(Collectors.toList()).get(0).getTail();
    }

    public boolean ladderBottonExists(int pos){
        // there can't be multiple ladder bottoms at one point
        return !board.getLadders().stream().filter(ladder -> ladder.getBottom()==pos).collect(Collectors.toList()).isEmpty();
    }

    public int ladderTopPoint(int bottom){
        // there can't be multiple ladder bottoms at one point
        return board.getLadders().stream().filter(ladder -> ladder.getBottom()==bottom).collect(Collectors.toList()).get(0).getTop();
    }
}
