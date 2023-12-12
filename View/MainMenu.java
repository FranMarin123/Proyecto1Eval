package View;

import Model.Card;
import Model.Player;

import java.io.IOException;
import java.util.Objects;

public class MainMenu {
    public static int mainMenu() {
        System.out.println("Bienvenido al Casino v1.0 \n" +
                "1-BlackJack sin apuesta\n" +
                "2-Entrar al modo apuesta\n" +
                "3-Salir");
        return UI.readInt("Elija una opción");
    }

    public static String readName() {
        return UI.readString("Introduce el nombre");
    }

    public static String nameCheck(Player[] players) {
        String name = "";
        boolean comp = true;
        do {
            name = MainMenu.readName();
            for (int i = 0; i < players.length && comp; i++) {
                if (players[i] != null) {
                    if (Objects.equals(name, players[i].getName().toLowerCase().replaceAll(" ", ""))) {
                        comp = false;
                    }
                }
            }
        } while (!comp);
        return name;
    }

    public static void winnerResolution(String winner){
        switch (winner){
            case "empate":
                System.out.println("Habéis empatado");
                break;
            case "ninguno":
                System.out.println("No ha ganado ninguno");
                break;
            default:
                System.out.println("Ha ganado el jugador " + winner);
                break;
        }
    }

    public static String printCard(Card cardToPrint){
        String suit=cardToPrint.getSuit();
        String toPrint="";
        String number= String.valueOf(cardToPrint.getValue());
        switch (number){
            case "11":
                number="J";
                break;
            case "12":
                number="Q";
                break;
            case "13":
                number="K";
                break;
            case "1":
                number="A";
                break;
        }

        if (number.equals("10")){
            toPrint="-------------\n" +
                    "| "+number+"        |\n" +
                    "|           |\n" +
                    "|     "+suit+"     |\n" +
                    "|           |\n" +
                    "|        "+number+" |\n" +
                    "-------------";
        }else {
            toPrint="-------------\n" +
                    "| "+number+"         |\n" +
                    "|           |\n" +
                    "|     "+suit+"     |\n" +
                    "|           |\n" +
                    "|         "+number+" |\n" +
                    "-------------";
        }

        return toPrint;
    }

    /*public static void clearScreen(){
        try {
            Runtime.getRuntime().exec("cls");
        } catch (final Exception e) {

        }
    }*/

}