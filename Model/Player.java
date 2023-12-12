package Model;

import java.util.Arrays;
import java.util.Objects;

public class Player {
    private Card[] cards;
    private String name;
    private int money;
    private Trophy[] playerTrophies;

    public Player() {
        this(null, "", -1);
    }

    public Player(Card[] cards, String name, int money) {
        this.cards = cards;
        this.name = name;
        this.money = money;
        this.playerTrophies = null;
    }

    public Player(Card[] cards, String name, int money, Trophy[] playerTrophies) {
        this.cards = cards;
        this.name = name;
        this.money = money;
        this.playerTrophies = playerTrophies;
    }

    public Card[] getCards() {
        return cards;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }

    public Trophy[] getPlayerTrophies() {
        return playerTrophies;
    }

    public void setPlayerTrophies(Trophy[] playerTrophies) {
        this.playerTrophies = playerTrophies;
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


    public void addCard(Card cardToAdd) {
        boolean comp = false;
        for (int i = 0; i < cards.length && !comp; i++) {
            if (cards[i].getValue() == 0) {
                cards[i] = new Card();
                this.cards[i] = cardToAdd;
                comp = true;
            }
        }
    }

    public void fillPlayerTrophy() {
        this.playerTrophies = new Trophy[5];
        for (int i = 0; i < this.playerTrophies.length; i++) {
            this.playerTrophies[i] = new Trophy("",0);
        }
    }

    public void addTrophy(Trophy trophyToAdd) {
        boolean comp = false;
        for (int i = 0; i < playerTrophies.length && !comp; i++) {
            if (Objects.equals(playerTrophies[i].getFigure(), "")) {
                playerTrophies[i].setFigure(trophyToAdd.getFigure());
                playerTrophies[i].setValue(trophyToAdd.getValue());
                comp = true;
            }
        }
    }

public void fillPlayerCards() {
        this.cards = new Card[52];
        for (int i = 0; i < this.cards.length; i++) {
            this.cards[i] = new Card(0, "");
        }
    }

}
