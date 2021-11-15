package Poker;

import java.util.ArrayList;
import java.util.Scanner;

public class PokerGame {
    private ArrayList<Player> players;
    private ArrayList<Player> tablePlayer;
    private int playerAmount;
    private Scanner sc;

    public PokerGame(){
        sc = new Scanner(System.in);
        players = new ArrayList<>();
        tablePlayer = new ArrayList<>();
        playerAmount();
    }

    public void playerAmount() {
        Player table = new Player("Table");
        tablePlayer.add(table);
        System.out.println("How many player do you want to play? (2-4)");
        playerAmount = Integer.parseInt(sc.nextLine());
        System.out.println("Write your Name");
        for (int i = 1; i <= playerAmount; i++) {
            System.out.print("Player " + (i) + ": \n");
            String name = sc.nextLine();
            Player player = new Player(name);
            players.add(player);
        }
        deal();
    }
    public void checkWinner(){
        int[] list = new int[10];
        for(Player player: players) {
            for (int i = 0; i < players.size(); i++) {
                if(player.getSum() < 21) {
                    list[i] = player.getSum();
                }
            }
            System.out.println(Player.findClosest(list, 21));
        }
    }
    public void deal() {
        boolean result = true;
        while (result) {
            System.out.println("1. Deal cards");
            switch (sc.nextInt()) {
                case 1:
                    for(int i = 0; i < 2; i++){
                        tablePlayer.get(0).giveCard();
                    }
                    System.out.println("\n"+tablePlayer.get(0).getName());
                    tablePlayer.get(0).showHand();
                    tablePlayer.get(0).evaluateHand();
                    for (Player player : players) {
                        for (int i = 0; i < 2; i++)
                            player.giveCard();
                        System.out.println("\n"+"Player "+player.getName());
                        player.showHand();
                        player.evaluateHand();
                    }
                    checkWinner();
                default:
                    result = false;
            }
        }
    }
}
