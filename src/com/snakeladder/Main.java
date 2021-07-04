package com.snakeladder;

import com.snakeladder.model.Board;
import com.snakeladder.model.Ladder;
import com.snakeladder.model.Player;
import com.snakeladder.model.Snake;
import com.snakeladder.service.BoardManager;
import com.snakeladder.service.PlayerManager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static File file = new File("/Users/schongder/Public/snakeladder/src/resource/testcase.txt");

    public static void main(String[] args) throws Exception{

        Scanner scanner = new Scanner(file);

//        while (scanner.hasNextLine()){
//            System.out.println(scanner.nextLine());
//        }

        System.out.println("Welocome to Snake and Ladder game");

        // data start
        List<Snake> snakeList = new ArrayList<>();
        List<Ladder> ladderList = new ArrayList<>();
        List<Player> playerList = new ArrayList<>();

        int numOfSnakes = scanner.nextInt();

        for(int i=0;i<numOfSnakes;i++){
            int head = scanner.nextInt();
            int tail = scanner.nextInt();
            snakeList.add(new Snake(head, tail));
        }

        System.out.println("Snakes set");

        int numOfLadders = scanner.nextInt();

        for(int i=0;i<numOfLadders;i++){
            int bottom = scanner.nextInt();
            int top = scanner.nextInt();
            ladderList.add(new Ladder(bottom,top));
        }

        System.out.println("Ladders set");

        int numOfPlayers = scanner.nextInt();

        for(int i=0;i<numOfPlayers;i++){
            String player = scanner.next();
            playerList.add(new Player(player));
        }

        System.out.println("Players set");
        // data end

        BoardManager boardManager = new BoardManager(new Board());
        PlayerManager playerManager = new PlayerManager(playerList,boardManager);

        while (true){
            boolean flag = false;
            for(Player player: playerList){

                int random = (int)(Math.random() * 6) + 1;
                int currentPlayerPos = player.getPosition();

                playerManager.play(random,player);
                int finalPlayerPos = player.getPosition();

                System.out.printf("%s rolled a %d and moved from %d to %d%n",player.getName(),random, currentPlayerPos, finalPlayerPos);
                if(finalPlayerPos == boardManager.getBoard().getEnd()){
                    System.out.printf("Player %s has won!",player.getName());
                    flag = true;
                    break;
                }
            }
            if(flag) break;
        }

        Logger logger = Logger.getLogger(Main.class.getName());
        logger.setLevel(Level.INFO);
        logger.addHandler(new ConsoleHandler());

    }
}
