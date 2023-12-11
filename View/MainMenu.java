package View;

import Model.Player;

import java.util.Objects;

public class MainMenu {
    public static int mainMenu(){
        System.out.println("Bienvenido al Casino v1.0 \n" +
                "1-BlackJack sin apuesta\n" +
                "2-Entrar al modo apuesta\n" +
                "3-Salir");
        return UI.readInt("Elija una opción");
    }

    public static String readName(){
        return UI.readString("Introduce el nombre");
    }

    public static String nameCheck(Player[] players){
        String name="";
        boolean comp=true;
        do {
            name=MainMenu.readName();
            for (int i=0;i<players.length && comp;i++){
                if (Objects.equals(name, players[i].getName().toLowerCase().replaceAll(" ", ""))){
                    comp=false;
                }
            }
        }while (!comp);
        return name;
    }

}