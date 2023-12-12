package Controller;

import Model.Card;
import Model.Deck;
import Model.Game;
import Model.Player;
import View.MainMenu;
import View.UI;
import View.WithoutBetMenu;

import java.io.IOException;
import java.util.Objects;

public class WithoutBetController {
    public static void withoutBetController() {
        int numberOfPlayers = WithoutBetMenu.numberPlayers();
        //MainMenu.clearScreen();
        Deck fDeck = new Deck(new Card[1]);
        fDeck.frenchDeck();
        Game withoutBetGame = new Game(0, createPlayers(numberOfPlayers), fDeck);
        //MainMenu.clearScreen();
        fillAllPlayerCards(withoutBetGame);
        if (numberOfPlayers != 1) {
            playersPlaying(withoutBetGame);
        }else {
            playerPlay(withoutBetGame.getPlayers()[0],fDeck,withoutBetGame);
            IA(withoutBetGame);
        }
        String result=withoutBetGame.calculateWinner();
        MainMenu.winnerResolution(result);
    }

    public static Player[] createPlayers(int numPlayers) {
        int arraySize = numPlayers;
        if (numPlayers == 1) {
            arraySize += 1;
        }
        Player[] players = new Player[arraySize];
        if (numPlayers == 1) {
            players[1] = new Player(new Card[52], "IA", 0);
            players[0] = new Player(new Card[52], MainMenu.nameCheck(players), 0);
        } else {
            for (int j = 0; j < arraySize; j++) {
                players[j] = new Player(new Card[52], MainMenu.nameCheck(players), 0);
            }
        }

        return players;
    }

    public static void playerPlay(Player playerPlaying, Deck gameDeck, Game game) {
        boolean playerFinal = false;
        String playerAnswer = "";
        int playerNumber = 1;
        //playerPlaying.fillPlayerCards();
        while (!playerFinal) {
            System.out.println("JUGANDO EL JUGADOR " + playerPlaying.getName());
            playerAnswer = UI.readString("¿Quieres una carta (Introduce \"si\" para recibir carta o \"no\" para " +
                    "terminar tu turno)?"/*"Actualmente tienes " + game.calculatePoints(playerPlaying,numberOfCards) + " puntos"*/);
            if (playerAnswer.toLowerCase().replaceAll(" ", "").equals("si")) {
                Card randomCard = gameDeck.pickARandomCard();
                playerPlaying.addCard(randomCard);
                gameDeck.removeCard(randomCard);
                System.out.println(MainMenu.printCard(randomCard) + "\n" +
                        "Tienes: " + game.calculatePoints(playerPlaying));
            } else if (playerAnswer.toLowerCase().replaceAll(" ", "").equals("no")) {
                playerFinal = true;
            }
            if (game.calculatePoints(playerPlaying) > 21) {
                playerFinal = true;
                System.out.println("Pasaste los 21 puntos, perdiste");
            }
            if (playerFinal) {
                playerNumber++;
            }
        }
        /*MainMenu.clearScreen();*/
    }

    public static void playersPlaying(Game game) {
        for (int i = 0; i < game.getPlayers().length; i++) {
            playerPlay(game.getPlayers()[i], game.getDesk(), game);
        }
    }

    public static void IA(Game game) {
        int IApoints = 0;
        int player1Points=game.calculatePoints(game.getPlayers()[0]);
        if (player1Points>21){
            player1Points=1;
        }
        while (player1Points > IApoints) {
            Card randomCard = game.getDesk().pickARandomCard();
            game.getPlayers()[1].addCard(randomCard);
            game.getDesk().removeCard(randomCard);
            IApoints=game.calculatePoints(game.getPlayers()[1]);
        }
        System.out.println("La IA ha conseguido "+IApoints+" puntos");
    }

    public static void fillAllPlayerCards(Game game){
        for (int i=0;i<game.getPlayers().length;i++){
            game.getPlayers()[i].fillPlayerCards();
        }
    }


}
