package Model;

import java.util.Arrays;

public class Deck {
    private Card[] cards;

    /*public Desk() {
        this(null);
    }*/
    public Deck(Card[] cards) {
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
        Deck deck = (Deck) o;
        return Arrays.equals(cards, deck.cards);
    }

    @Override
    public String toString() {
        return "Desk{" +
                "cards=" + Arrays.toString(cards) +
                '}';
    }

    /**
     * Este método elige una carta aleatoria del mazo.
     *
     * @return Devuelve una carta.
     */
    public Card pickARandomCard() {
        int randomPos = (int) (Math.random() * (this.cards.length - 1));
        while (this.cards[randomPos]==null){
            randomPos = (int) (Math.random() * (this.cards.length - 1));
        }
        return this.cards[randomPos];
    }

    public void removeCard(Card cardToRemove){
        for (int i=0;i<this.cards.length;i++){
            if (this.cards[i]==cardToRemove){
                this.cards[i]=null;
            }
        }
    }

    /**
     * Genera un mazo de cartas de 52
     *
     * @return
     */
    public void frenchDesk() {
        this.cards = new Card[52];
        String suit = "";
        for (int i = 0, value = 1; i < cards.length; i++) {
            cards[i] = new Card();
            if (i < 13) {
                suit = "♥";
                cards[i].setValue(value);
                cards[i].setSuit(suit);
            } else if (i < 26) {
                suit = "♣";
                cards[i].setValue(value);
                cards[i].setSuit(suit);
            } else if (i < 39) {
                suit = "♠";
                cards[i].setValue(value);
                cards[i].setSuit(suit);
            } else {
                suit = "♦";
                cards[i].setValue(value);
                cards[i].setSuit(suit);
            }
            if (value == 13) {
                value = 1;
            }
            value++;
        }

    }


}
