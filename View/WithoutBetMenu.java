package View;

public class WithoutBetMenu {
    /**
     * Este método devuelve un entero entre el 1 y 4 pedido por pantalla
     * @return Devuelve un entero
     */
    public static int numberPlayers(){
        int numPlayers=-1;
        System.out.println("Estas en el modo sin apuesta");
        while(numPlayers<1 || numPlayers>4){
            numPlayers=UI.readInt("Introduce el número de jugadores (si eliges 1 jugarás contra la IA)");
        }
        return numPlayers;
    }
}
