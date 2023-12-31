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


    /**
     * Este método recibe un jugador y devuelve un
     * entero con los puntos del jugador recibido
     * @param playerToCalculate Recibe un jugador del que vamos a calcular los puntos
     * @return Devuelve los puntos que tiene el jugador
     */
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

    /**
     * Consulta los puntos de todos los jugadores y devuelve un ganador
     * @return Devuelve el resultado de la partida
     */
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

}
