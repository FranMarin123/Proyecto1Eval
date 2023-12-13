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
        Deck fDeck = new Deck(new Card[1]);
        fDeck.frenchDeck();
        Game withoutBetGame = new Game(0, createPlayers(numberOfPlayers), fDeck);
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

    /**
     * Este método recibe un entero que es el número de jugadores que
     * queremos crear y devuelve un array con los jugadores creados
     * @param numPlayers Recibe un entero que representa a la cantidad de jugadores que queremos crear
     * @return Devuelve un array de jugadores.
     */
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

    /**
     * Este método recibe un jugador, un mazo y un juego
     * y realiza la partida del jugador introducido.
     * @param playerPlaying Jugador que queremos que realice sus jugadas
     * @param gameDeck Mazo que vamos a utilizar
     * @param game El juego en el que se almacenan el jugador y el mazo
     */
    public static void playerPlay(Player playerPlaying, Deck gameDeck, Game game) {
        boolean playerFinal = false;
        String playerAnswer = "";
        while (!playerFinal) {
            System.out.println("JUGANDO EL JUGADOR " + playerPlaying.getName());
            playerAnswer = UI.readString("¿Quieres una carta (Introduce \"si\" para recibir carta o " +
                    "\"no\" para terminar tu turno)?");
            //Comprobamos si ha introducido si o no
            if (playerAnswer.toLowerCase().replaceAll(" ", "").equals("si")) {
                Card randomCard = gameDeck.pickARandomCard();
                playerPlaying.addCard(randomCard);
                gameDeck.removeCard(randomCard);
                System.out.println(MainMenu.printCard(randomCard) + "\n" +
                        "Tienes: " + game.calculatePoints(playerPlaying));
            } else if (playerAnswer.toLowerCase().replaceAll(" ", "").equals("no")) {
                playerFinal = true;
            }
            //Comprobamos si se ha pasado de 21
            if (game.calculatePoints(playerPlaying) > 21) {
                playerFinal = true;
                System.out.println("Pasaste los 21 puntos, perdiste");
            }
        }
    }

    /**
     * Este método recibe un juego y hace que todos los jugadores del juego jueguen.
     * @param game Recibe el juego
     */
    public static void playersPlaying(Game game) {
        for (int i = 0; i < game.getPlayers().length; i++) {
            playerPlay(game.getPlayers()[i], game.getDesk(), game);
        }
    }

    /**
     * Este método recibe el juego y hace que la IA juegue su turno
     * @param game
     */
    public static void IA(Game game) {
        int IApoints = 0;
        int player1Points=game.calculatePoints(game.getPlayers()[0]);
        //Comprobamos si el jugador ha pasado los 21 puntos y si es así le asignamos el valor mínimo
        if (player1Points>21){
            player1Points=1;
        }
        //Hacemos que pida cartas mientras tenga menos puntos que el jugador, una vez que lo supere se plantará
        while (player1Points > IApoints) {
            Card randomCard = game.getDesk().pickARandomCard();
            game.getPlayers()[1].addCard(randomCard);
            game.getDesk().removeCard(randomCard);
            IApoints=game.calculatePoints(game.getPlayers()[1]);
        }
        System.out.println("La IA ha conseguido "+IApoints+" puntos");
    }

    /**
     * Recibe el juego y asigna un valor por defecto a todos las cartas de todos los jugadores
     * @param game Recibe el juego
     */
    public static void fillAllPlayerCards(Game game){
        for (int i=0;i<game.getPlayers().length;i++){
            game.getPlayers()[i].fillPlayerCards();
        }
    }


}
