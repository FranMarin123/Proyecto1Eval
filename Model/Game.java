package Model;

public class Game {
    private int turn;
    private Player[] players;
    private Desk desk;

    public Game(int turn, Player[] players, Desk desk) {
        this.turn = turn;
        this.players = players;
        this.desk = desk;
    }

    public Game() {
        this(0, null, null);
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Desk getDesk() {
        return desk;
    }

    public void setDesk(Desk desk) {
        this.desk = desk;
    }


    public int calculatePoints(Player playerToCalculate) {
        int points = 0;
        for (int j = 0; j < playerToCalculate.getCards().length; j++) {
            if (playerToCalculate.getCards()[j].getValue() >= 10) {
                points += 10;
            } else {
                points += playerToCalculate.getCards()[j].getValue();
            }
        }
        return points;
    }

    public Player calculateWinner() {
        int points = 0;
        int winnerPoints = 0;
        int winnerPosition = -1;
        for (int i = 0; i < this.players.length; i++) {
            points = calculatePoints(this.players[i]);
            if (winnerPoints < points) {
                winnerPoints = points;
                winnerPosition = i;
            }
        }
        return this.players[winnerPosition];
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
            comp=false;
        }
        return comp;
    }


}
