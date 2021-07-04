package com.snakeladder.model;

import java.util.ArrayList;
import java.util.List;

public class Board {

    int start;
    int end;
    List snakes;
    List ladders;

    public Board(int start, int end) {
        this.start = start;
        this.end = end;
        this.snakes = new ArrayList();
        this.ladders = new ArrayList();
    }

    public Board() {
        this.start = 1;
        this.end = 100;
        this.snakes = new ArrayList();
        this.ladders = new ArrayList();
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public List<Snake> getSnakes() {
        return snakes;
    }

    public void setSnakes(List snakes) {
        this.snakes = snakes;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public void setLadders(List ladders) {
        this.ladders = ladders;
    }
}
