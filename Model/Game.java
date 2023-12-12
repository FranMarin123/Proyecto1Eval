package Model;

import java.util.Objects;

public class Game {
    private int turn;
    private Player[] players;
    private Deck deck;

    public Game(int turn, Player[] players, Deck deck) {
        this.turn = turn;
        this.players = players;
        this.deck = deck;
    }

    public Game() {
        this(0, null, null);
    }

    public Game(Player[] players, Deck fDeck) {
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Deck getDesk() {
        return deck;
    }

    public void setDesk(Deck deck) {
        this.deck = deck;
    }


    public int calculatePoints(Player playerToCalculate) {
        int points = 0;
        for (int j = 0; j < playerToCalculate.getCards().length; j++) {
            if (playerToCalculate.getCards()[j].getValue() >= 10) {
                points += 10;
            } else if (playerToCalculate.getCards()[j].getValue() == 1 && points < 11) {
                points += 11;
            } else {
                points += playerToCalculate.getCards()[j].getValue();
            }
        }
        return points;
    }

    public String calculateWinner() {
        int points = 0;
        int winnerPoints = 0;
        String winner="";
        for (int i = 0; i < this.players.length; i++) {
            points = calculatePoints(this.players[i]);
            if (winnerPoints==points){
                winner="empate";
            }
            if (winnerPoints < points && points <= 21) {
                winnerPoints = points;
                winner=this.players[i].getName();
            }
            if (Objects.equals(winner, "")){
                winner="ninguno";
            }
        }
        return winner;
    }

    public boolean isAllPlayers() {
        boolean comp = true;
        for (int i = 0; i < this.players.length && comp; i++) {
            if (this.players[i].getName().isEmpty()) {
                comp = false;
            }
        }
        return comp;
    }

    public boolean isAlreadyPlayed() {
        boolean comp = true;
        if (this.players == null) {
            comp = false;
        }
        return comp;
    }


}
