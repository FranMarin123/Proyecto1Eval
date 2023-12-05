package Model;

import java.util.Arrays;

public class Desk {
    private Card[] cards;

    /*public Desk() {
        this(null);
    }*/
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

    /**
     * Este método elige una carta aleatoria del mazo.
     * @return Devuelve una carta.
     */
    public Card pickARandomCard(){
        int randomPos= (int) (Math.random() * (cards.length - 1));
        return cards[randomPos];
    }

    /**
     * Genera un mazo de cartas de 52
     * @return
     */
    public void frenchDesk(){
        this.cards=new Card[52];
        String suit="";
        for (int i=0,value=1;i<cards.length;i++){
            cards[i]=new Card();
            if (i<13) {
                suit="Corazones";
                cards[i].setValue(value);
                cards[i].setSuit(suit);
            }else if (i<26) {
                suit="Treboles";
                cards[i].setValue(value);
                cards[i].setSuit(suit);
            }else if (i<39) {
                suit="Picas";
                cards[i].setValue(value);
                cards[i].setSuit(suit);
            }else {
                suit="Diamantes";
                cards[i].setValue(value);
                cards[i].setSuit(suit);
            }
            if(value==13){
                value=1;
            }
            value++;
        }

    }



}
