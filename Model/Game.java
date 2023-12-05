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
        this(0,null,null);
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
    
}
