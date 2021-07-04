package com.snakeladder.service;

import com.snakeladder.model.Player;

import java.util.List;
import java.util.stream.Collectors;

public class PlayerManager {

    List<Player> playerList;
    BoardManager boardManager;

    public PlayerManager(List<Player> playerList, BoardManager boardManager) {
        this.playerList = playerList;
        this.boardManager = boardManager;
    }

    public void addPlayer(Player player){
        playerList.add(player);
    }

    public void play(int diceValue, Player player) {
        movePlayer(player,diceValue);
    }

    private void movePlayer(Player player, int numberOfPlaces){

        if(player.getPosition()+numberOfPlaces>100) {
            return;
        }
        if(boardManager.snakeHeadExists(player.getPosition()+numberOfPlaces)){
            player.setPosition(boardManager.snakeTailpoint(player.getPosition()+numberOfPlaces));
            movePlayer(player,0);
        }
        else if(boardManager.ladderBottonExists(player.getPosition()+numberOfPlaces)){
            player.setPosition(boardManager.ladderTopPoint(player.getPosition()+numberOfPlaces));
            movePlayer(player,0);
        }else{
            player.setPosition(player.getPosition()+numberOfPlaces);
        }
    }
}
