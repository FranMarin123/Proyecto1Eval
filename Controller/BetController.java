package Controller;

import Model.Card;
import Model.Deck;
import Model.Game;
import Model.Player;
import View.BetMenu;
import View.MainMenu;
import View.UI;

public class BetController {
    public static void betController() {
        Player[] gamePlayers=new Player[2];
        gamePlayers[0]= new Player(new Card[52],MainMenu.readName(),500);
        gamePlayers[1]=new Player(new Card[52],"",0);
        Deck fDeck = new Deck(new Card[1]);
        fDeck.frenchDeck();
        Game betGame = new Game(0, gamePlayers, fDeck);
        WithoutBetController.fillAllPlayerCards(betGame);
        optionSelection(betGame);
    }

    public static void optionSelection(Game betGame) {
        int option = -1;
        while (option != 6) {
            int moneyToBet = 0;
            option = BetMenu.optionsMenu();
            Deck fDeck = new Deck(new Card[1]);
            fDeck.frenchDeck();
            betGame.setDesk(fDeck);
            WithoutBetController.fillAllPlayerCards(betGame);
            switch (option) {
                case 1:
                    moneyToBet = UI.readInt("Inserte la cantidad a apostar");
                    if (moneyToBet <= betGame.getPlayers()[0].getMoney() || moneyToBet<=0) {
                        createIA(betGame);
                        WithoutBetController.playerPlay(betGame.getPlayers()[0], betGame.getDesk(), betGame);
                        WithoutBetController.IA(betGame);
                        String result = betGame.calculateWinner();
                        MainMenu.winnerResolution(result);
                        if (result.equals(betGame.getPlayers()[0].getName())){
                            betGame.getPlayers()[0].setMoney(betGame.getPlayers()[0].getMoney()+moneyToBet);
                            BetMenu.moneyWinMessage(betGame.getPlayers()[0].getMoney(), moneyToBet);
                        } else if (result.equals("empate")) {
                            BetMenu.moneyDrawMessage();
                        } else {
                            betGame.getPlayers()[0].setMoney(betGame.getPlayers()[0].getMoney()-moneyToBet);
                            BetMenu.moneyLoseMessage(betGame.getPlayers()[0].getMoney(), moneyToBet);
                        }
                    } else {
                        BetMenu.moneyError();
                    }
                    UI.pressSpace();
                    break;
                case 2:
                    moneyToBet = UI.readInt("Inserte la cantidad a apostar");
                    if (moneyToBet <= betGame.getPlayers()[0].getMoney() || moneyToBet<=0) {
                        createSecondPlayer(betGame);
                        WithoutBetController.playerPlay(betGame.getPlayers()[0], betGame.getDesk(), betGame);
                        WithoutBetController.playerPlay(betGame.getPlayers()[1], betGame.getDesk(), betGame);
                        String result = betGame.calculateWinner();
                        MainMenu.winnerResolution(result);
                        if (result.equals(betGame.getPlayers()[0].getName())){
                            betGame.getPlayers()[0].setMoney(betGame.getPlayers()[0].getMoney()+moneyToBet);
                            BetMenu.moneyWinMessage(betGame.getPlayers()[0].getMoney(), moneyToBet);
                        } else if (result.equals("empate")) {
                            BetMenu.moneyDrawMessage();
                        } else {
                            betGame.getPlayers()[0].setMoney(betGame.getPlayers()[0].getMoney()-moneyToBet);
                            BetMenu.moneyLoseMessage(betGame.getPlayers()[0].getMoney(), moneyToBet);
                        }
                    } else {
                        BetMenu.moneyError();
                    }
                    UI.pressSpace();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    BetMenu.checkBalance(betGame.getPlayers()[0].getMoney());
                    UI.pressSpace();
                case 6:
                    BetMenu.bye();
            }
        }
    }

    public static void createIA(Game betGame) {
        betGame.getPlayers()[1].setName("IA");
    }

    public static void createSecondPlayer(Game betGame){
        betGame.getPlayers()[1].setName(MainMenu.readName());
    }
}
