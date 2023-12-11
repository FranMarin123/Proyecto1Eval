package Controller;

import Model.Player;
import View.MainMenu;
import View.WithoutBetMenu;

import java.util.Objects;

public class WithoutBetController {
    public static void withoutBetController() {
        int numberOfPlayers = WithoutBetMenu.numberPlayers();
    }

    public static Player[] createPlayers(int numPlayers) {
        int arraySize = numPlayers;
        if (numPlayers == 1) {
            arraySize += 1;
        }
        Player[] players = new Player[arraySize];
        for (int i = 0; i < numPlayers; i++) {
            if (numPlayers==1){
                players[players.length-1]=new Player("IA");
            }
            for (int j=0;j<players.length;j++){
                players[j]=new Player(MainMenu.nameCheck(players));
            }
        }
        return players;

    }

}
