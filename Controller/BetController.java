package Controller;

import Model.*;
import View.BetMenu;
import View.MainMenu;
import View.UI;

import java.util.Objects;

public class BetController {
    public static void betController() {
        Player[] gamePlayers = new Player[2];
        gamePlayers[0] = new Player(new Card[52], MainMenu.readName(), 500, new Trophy[5]);
        gamePlayers[1] = new Player(new Card[52], "", 0);
        Deck fDeck = new Deck(new Card[1]);
        fDeck.frenchDeck();
        Game betGame = new Game(0, gamePlayers, fDeck);
        WithoutBetController.fillAllPlayerCards(betGame);
        betGame.getPlayers()[0].fillPlayerTrophy();
        optionSelection(betGame);
    }

    public static void optionSelection(Game betGame) {
        Awards betGameAwards = new Awards(new Trophy[5]);
        betGameAwards.createTrophies();
        int option = -1;
        while (option != 6 && betGame.getPlayers()[0].getMoney() > 0) {
            int moneyToBet = 0;
            option = BetMenu.optionsMenu();
            Deck fDeck = new Deck(new Card[1]);
            fDeck.frenchDeck();
            betGame.setDesk(fDeck);
            WithoutBetController.fillAllPlayerCards(betGame);
            switch (option) {
                case 1:
                    moneyToBet = UI.readInt("Inserte la cantidad a apostar");
                    if (moneyToBet <= betGame.getPlayers()[0].getMoney() || moneyToBet <= 0) {
                        createIA(betGame);
                        WithoutBetController.playerPlay(betGame.getPlayers()[0], betGame.getDesk(), betGame);
                        WithoutBetController.IA(betGame);
                        String result = betGame.calculateWinner();
                        MainMenu.winnerResolution(result);
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
                    if (moneyToBet <= betGame.getPlayers()[0].getMoney() || moneyToBet <= 0) {
                        createSecondPlayer(betGame);
                        WithoutBetController.playerPlay(betGame.getPlayers()[0], betGame.getDesk(), betGame);
                        WithoutBetController.playerPlay(betGame.getPlayers()[1], betGame.getDesk(), betGame);
                        String result = betGame.calculateWinner();
                        MainMenu.winnerResolution(result);
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
                    int trophyOption = (BetMenu.thophyOptionCheck("¿Que trofeo desea adquirir?(Pulse 6 para salir)")) - 1;
                    if (trophyOption == 5) {
                        System.out.println("Vuelva a comprar cuando quiera");
                    } else if (betGameAwards.getTrophies()[trophyOption].getValue() >= betGame.getPlayers()[0].getMoney()) {
                        System.out.println("No tienes el saldo suficiente o tienes el justo");
                    } else if (Objects.equals(betGameAwards.getTrophies()[trophyOption].getFigure(), "")) {
                        System.out.println("Ya posees este trofeo");
                    } else {
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
            if (betGame.getPlayers()[0].getMoney() <= 0) {
                System.out.println("Te quedaste sin dinero");
            }
        }
        BetMenu.bye();
    }

    public static void createIA(Game betGame) {
        betGame.getPlayers()[1].setName("IA");
    }

    public static void createSecondPlayer(Game betGame) {
        betGame.getPlayers()[1].setName(MainMenu.readName());
    }

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
