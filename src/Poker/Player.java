package Poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Player {
    private String name;
    public ArrayList<Card> playerCards;
    private int money;
    private int sum;
    private Scanner sc;
    private boolean Y;
    private int numberChange = 2;
    private Deck deck;

    public Player(String name){
        this.name = name;
        this.money = 1000;
        this.playerCards = new ArrayList<Card>();
        sc = new Scanner(System.in);
        deck = new Deck();
    }

    public String getName() {
        return name;
    }

    public void giveCard(){
        playerCards.add(deck.drawCard());
    }

    public int getSum() {
        return sum;
    }

    public void evaluateHand(){
        for (Card playerCard : playerCards) {
            sum += playerCard.rank.rank;
        }
        System.out.println(sum);
        if(sum == 21){
            System.out.println("blackjack!");
        }else if (sum < 21){
            do {
                System.out.println("want another card? (Y/N)");
                String answer = sc.nextLine();
                if (answer.equalsIgnoreCase("Y")) {
                    this.Y = true;
                    giveCard();
                    for(Card card : playerCards){
                        System.out.println(card);
                    }
                    sum += playerCards.get(numberChange).rank.rank;
                    System.out.println("You now have " + sum);
                    if(sum > 21){
                        System.out.println("Busted!");
                    }
                }else if (answer.equalsIgnoreCase("N")){
                    this.Y = false;
                }
                numberChange++;
            }while (this.Y && sum < 21);
        }
    }
    public static int findClosest(int[] arr, int target) {
        int idx = 0;
        int dist = Math.abs(arr[0] - target);

        for (int i = 1; i< arr.length; i++) {
            int cdist = Math.abs(arr[i] - target);

            if (cdist < dist) {
                idx = i;
                dist = cdist;
            }
        }
        return arr[idx];
    }

    public void showHand(){
        for(Card cards : playerCards){
            System.out.println(cards);
        }
    }
}
