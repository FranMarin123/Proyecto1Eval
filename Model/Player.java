package Model;

import java.util.Arrays;
import java.util.Objects;

public class Player {
    private Card[] cards;
    private String name;
    private int money;

    public Player() {
        this(null,"",-1);
    }

    public Player(Card[] cards, String name, int money) {
        this.cards = cards;
        this.name = name;
        this.money = money;
    }

    public Player(String name) {
        this.cards = null;
        this.name = name;
        this.money = 0;
    }

    public Card[] getCards() {
        return cards;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public String toString() {
        return "Player{" +
                " name='" + name +
                ", cards=" + Arrays.toString(cards) +
                ", money=" + money +
                '}';
    }


    public void addCard(Card cardToAdd){
        this.cards=new Card[52];
        boolean comp=false;
        for (int i=0;i<cards.length && !comp;i++){
            if (cards[i]==null){
                cards[i]=new Card();
                this.cards[i]=cardToAdd;
                comp=true;
            }
        }
    }

    public void addMoney(int numPlay){
        this.money=money*numPlay;
    }

    public void looseMoney(int numPlay){
        this.money=money/2;
    }
}
