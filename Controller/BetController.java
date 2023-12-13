package Controller;

import Model.*;
import View.BetMenu;
import View.MainMenu;
import View.UI;

import java.util.Objects;

public class BetController {
    /**
     * Este método inicia el juego con apuesta
     */
    public static void betController() {
        /*Genera un array con dos jugadores, uno el principal y otro que
         cambiará de nombre según elijamos la opción de IA o de jugador*/
        Player[] gamePlayers = new Player[2];
        gamePlayers[0] = new Player(new Card[52], MainMenu.readName(), 500, new Trophy[5]);
        gamePlayers[1] = new Player(new Card[52], "", 0);
        //Genera la baraja francesa
        Deck fDeck = new Deck(new Card[1]);
        fDeck.frenchDeck();
        Game betGame = new Game(0, gamePlayers, fDeck);
        //Inicializa las cartas y los trofeos de los jugadores a valores por defecto
        WithoutBetController.fillAllPlayerCards(betGame);
        betGame.getPlayers()[0].fillPlayerTrophy();
        optionSelection(betGame);
    }

    /**
     * Este método recibe el juego creado y da a elegir al usuario
     * entre las diferentes opciones y solo sale si elegimos la opción salir
     * @param betGame Recibe el juego
     */
    public static void optionSelection(Game betGame) {
        //Generamos las recompensas
        Awards betGameAwards = new Awards(new Trophy[5]);
        betGameAwards.createTrophies();
        int option = -1;
        while (option != 6 && betGame.getPlayers()[0].getMoney() > 0) {
            int moneyToBet = 0;
            option = BetMenu.optionsMenu();
            //Volvemos a generar el mazo para que en cada partida el mazo esté completo
            Deck fDeck = new Deck(new Card[1]);
            fDeck.frenchDeck();
            betGame.setDesk(fDeck);
            /*Inicializamos las cartas a unos valores por defecto para
            que los jugadores no tengan puntos de las anteriores partidas*/
            WithoutBetController.fillAllPlayerCards(betGame);
            switch (option) {
                case 1:
                    moneyToBet = UI.readInt("Inserte la cantidad a apostar");
                    //Comprobamos si el dinero que se quiere apostar es correcto
                    if (moneyToBet <= betGame.getPlayers()[0].getMoney() || moneyToBet <= 0) {
                        createIA(betGame);
                        WithoutBetController.playerPlay(betGame.getPlayers()[0], betGame.getDesk(), betGame);
                        WithoutBetController.IA(betGame);
                        String result = betGame.calculateWinner();
                        MainMenu.winnerResolution(result);
                        //Comprobamos quien ha ganado y asignamos puntos al jugador según el resultado
                        if (result.equals(betGame.getPlayers()[0].getName())) {
                            betGame.getPlayers()[0].setMoney(betGame.getPlayers()[0].getMoney() + moneyToBet);
                            BetMenu.moneyWinMessage(betGame.getPlayers()[0].getMoney(), moneyToBet);
                        } else if (result.equals("empate")) {
                            BetMenu.moneyDrawMessage();
                        } else {
                            betGame.getPlayers()[0].setMoney(betGame.getPlayers()[0].getMoney() - moneyToBet);
                            BetMenu.moneyLoseMessage(betGame.getPlayers()[0].getMoney(), moneyToBet);
                        }
                    } else {
                        BetMenu.moneyError();
                    }
                    UI.pressEnter();
                    break;
                case 2:
                    moneyToBet = UI.readInt("Inserte la cantidad a apostar");
                    //Comprobamos si el dinero que se quiere apostar es correcto
                    if (moneyToBet <= betGame.getPlayers()[0].getMoney() || moneyToBet <= 0) {
                        createSecondPlayer(betGame);
                        WithoutBetController.playerPlay(betGame.getPlayers()[0], betGame.getDesk(), betGame);
                        WithoutBetController.playerPlay(betGame.getPlayers()[1], betGame.getDesk(), betGame);
                        String result = betGame.calculateWinner();
                        MainMenu.winnerResolution(result);
                        //Comprobamos quien ha ganado y asignamos puntos al jugador según el resultado
                        if (result.equals(betGame.getPlayers()[0].getName())) {
                            betGame.getPlayers()[0].setMoney(betGame.getPlayers()[0].getMoney() + moneyToBet);
                            BetMenu.moneyWinMessage(betGame.getPlayers()[0].getMoney(), moneyToBet);
                        } else if (result.equals("empate")) {
                            BetMenu.moneyDrawMessage();
                        } else {
                            betGame.getPlayers()[0].setMoney(betGame.getPlayers()[0].getMoney() - moneyToBet);
                            BetMenu.moneyLoseMessage(betGame.getPlayers()[0].getMoney(), moneyToBet);
                        }
                    } else {
                        BetMenu.moneyError();
                    }
                    UI.pressEnter();
                    break;
                case 3:
                    listTrophies(betGameAwards.getTrophies());
                    //Pedimos que nos elija el trofeo y le restamos uno, ya que esa será su posición en el array
                    int trophyOption = (BetMenu.thophyOptionCheck("¿Que trofeo desea adquirir?(Pulse 6 para salir)")) - 1;
                    if (trophyOption == 5) {
                        System.out.println("Vuelva a comprar cuando quiera");
                    }
                    //Comprobamos si el usuario tiene saldo suficiente para comprar el trofeo seleccionado
                    else if (betGameAwards.getTrophies()[trophyOption].getValue() >= betGame.getPlayers()[0].getMoney()) {
                        System.out.println("No tienes el saldo suficiente o tienes el justo");
                    }
                    //Comprobamos si este trofeo ya ha sido comprado
                    else if (Objects.equals(betGameAwards.getTrophies()[trophyOption].getFigure(), "")) {
                        System.out.println("Ya posees este trofeo");
                    }
                    //Y si no se cumple ninguna de las anteriores sacamos de Awards el trofeo y se lo añadimos a jugador
                    else {
                        Trophy trophyBuyed = betGameAwards.getTrophies()[trophyOption];
                        betGame.getPlayers()[0].addTrophy(trophyBuyed);
                        betGame.getPlayers()[0].getPlayerTrophies();
                        betGameAwards.removeTrophy(trophyBuyed);
                        betGame.getPlayers()[0].setMoney
                                (betGame.getPlayers()[0].getMoney()
                                        - betGameAwards.getTrophies()[trophyOption].getValue());
                        System.out.println("Comprado con éxito");
                    }
                    UI.pressEnter();
                    break;
                case 4:
                    listPlayerTrophies(betGame.getPlayers()[0].getPlayerTrophies());
                    break;
                case 5:
                    BetMenu.checkBalance(betGame.getPlayers()[0].getMoney());
                    UI.pressEnter();
                    break;
            }
            //Comprobamos si ha perdido todo el dinero y le mostramos un mensaje
            if (betGame.getPlayers()[0].getMoney() <= 0) {
                System.out.println("Te quedaste sin dinero");
            }
        }
        BetMenu.bye();
    }

    /**
     * Este método recibe el juego y cambia el nombre al jugador 2 para llamarlo IA
     * @param betGame Recibe el juego
     */
    public static void createIA(Game betGame) {
        betGame.getPlayers()[1].setName("IA");
    }

    /**
     * Este método recibe el juego y cambia el nombre al jugador 2 para llamarlo como diga el usuario
     * @param betGame Recibe el juego
     */
    public static void createSecondPlayer(Game betGame) {
        betGame.getPlayers()[1].setName(MainMenu.readName());
    }

    /**
     * Este método recibe un array de trofeos y los muestra por pantalla
     * y si el trofeo ya lo posee el jugador muestra que ya lo posee
     * @param trophyGroup Recibe un array de trofeos
     */
    public static void listTrophies(Trophy[] trophyGroup) {
        for (int i = 0; i < trophyGroup.length; i++) {
            System.out.println("TROFEO " + (i + 1));
            if (Objects.equals(trophyGroup[i].getFigure(), "")) {
                System.out.println("Ya adquirido");
            } else {
                BetMenu.trophyPrint(trophyGroup[i].getFigure());
                System.out.println("Trofeo de " + trophyGroup[i].getValue() + " puntos");
            }
            UI.pressEnter();
        }
    }

    /**
     * Este método recibe un array de trofeos del jugador y los muestra,
     * si no tiene ningún trofeo indica que no posee ninguno
     * @param trophyGroup Recibe un array de trofeos
     */
    public static void listPlayerTrophies(Trophy[] trophyGroup) {
        boolean comp = false;
        for (int i = 0; i < trophyGroup.length; i++) {
            if (!Objects.equals(trophyGroup[i].getFigure(), "")) {
                BetMenu.trophyPrint(trophyGroup[i].getFigure());
                System.out.println("Trofeo de " + trophyGroup[i].getValue() + " puntos");
                comp = true;
                UI.pressEnter();
            }
        }
        if (!comp) {
            System.out.println("No tienes ningún premio aún");
            UI.pressEnter();
        }
    }

}
