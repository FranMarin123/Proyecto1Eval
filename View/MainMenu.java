package View;

import Model.Card;
import Model.Player;

import java.io.IOException;
import java.util.Objects;

public class MainMenu {
    /**
     * Este método devuelve un entero que es la opción que seleccionamos
     * @return Devuelve un entero que es la opción deseada
     */
    public static int mainMenu() {
        System.out.println("Bienvenido al Casino v1.0 \n" +
                "1-BlackJack sin apuesta\n" +
                "2-Entrar al modo apuesta\n" +
                "3-Salir");
        return UI.readInt("Elija una opción");
    }

    /**
     * Este método devuelve un String que sería un nombre
     * @return Devuelve un String introducido por pantalla
     */
    public static String readName() {
        return UI.readString("Introduce el nombre");
    }

    /**
     * Este método recibe un array de jugadores y pide por pantalla un nombre, comprueba si el nombre está repetido
     * @param players Recibe un array de players
     * @return Devuelve un String que es el nombre comprobado
     */
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

    /**
     * Recibe un String con el ganador e imprime por pantalla un mensaje determinado según el resultado de la partida
     * @param winner
     */
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

    /**
     * Este método recibe una carta y la representa por pantalla
     * @param cardToPrint Recibe la carta a representar
     * @return Devuelve un String con la representación de la carta
     */
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
}