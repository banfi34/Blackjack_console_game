package Poker;

public class Card {

    public enum Suite {
        Hearts, Spades, Clubs, Diamonds
    }
    public enum Rank {
        Two(2), Three(3), Four(4), Five(5), six(6), Seven(7), Eight(8), Nine(9), Ten(10), Ace(11), King(10), Jack(10), Queen(10);

        public int rank;

        Rank(int rank){
            this.rank = rank;
        }
    }
    public Rank rank;

    public Suite suite;


    public Card(Rank rank, Suite suite){
        this.suite = suite;
        this.rank = rank;
    }

    public String toString(){
        return suite + " "+rank;
    }

}
