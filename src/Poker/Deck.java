package Poker;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    ArrayList<Card> cardDeck;

    public Deck(){
        cardDeck = new ArrayList<>();
        for(Card.Suite suite: Card.Suite.values()){
            for(Card.Rank rank: Card.Rank.values()){
                Card cards = new Card(rank, suite);
                cardDeck.add(cards);
            }
        }
        Collections.shuffle(cardDeck);
    }
    public void showCards(){
        for (Card card : cardDeck) {
            System.out.println(card);
        }
    }
    public Card drawCard(){
        Card currentCard = cardDeck.get(0);
        cardDeck.remove(0);
        return currentCard;
        //hello
    }
}
