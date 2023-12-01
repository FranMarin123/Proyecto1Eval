package Model;

import java.util.Arrays;

public class Desk {
    Card[] cards;

    public Desk() {
        this(null);
    }
    public Desk(Card[] cards) {
        this.cards = cards;
    }

    public Card[] getCards() {
        return cards;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Desk desk = (Desk) o;
        return Arrays.equals(cards, desk.cards);
    }

    @Override
    public String toString() {
        return "Desk{" +
                "cards=" + Arrays.toString(cards) +
                '}';
    }

    public Card pickARandomCard(){
        int randomPos= (int) (Math.random() * (cards.length - 1));
        return cards[randomPos];
    }

    public Card[] frenchDesk(){
        Card[] frenchDesk=new Card[52];
        String suit="";
        for (int i=0,value=1;i<frenchDesk.length;i++){
            if (i<13) {
                suit="Corazones";
                frenchDesk[i].setValue(value);
                frenchDesk[i].setSuit(suit);
            }else if (i<26) {
                suit="Treboles";
                frenchDesk[i].setValue(value);
                frenchDesk[i].setSuit(suit);
            }else if (i<39) {
                suit="Picas";
                frenchDesk[i].setValue(value);
                frenchDesk[i].setSuit(suit);
            }else {
                suit="Diamantes";
                frenchDesk[i].setValue(value);
                frenchDesk[i].setSuit(suit);
            }
            
        }
        return frenchDesk;
    }



}
