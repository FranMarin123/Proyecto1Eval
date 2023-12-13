package View;

public class BetMenu {
    /**
     * Este método devuelve un número entero que es la opción seleccionada en el menú
     * @return
     */
    public static int optionsMenu(){
        int option=-1;
        while(option<1 || option>6) {
            option = UI.readInt("Bienvenido a la parte de apuestas, selecciona la opción que quieres ejecutar\n" +
                    "1-BlackJack contra IA\n" +
                    "2-BlackJack contra otro jugador\n" +
                    "3-Comprar trofeos\n" +
                    "4-Mostrar trofeos obtenidos\n" +
                    "5-Consultar saldo\n" +
                    "6-Salir");
        }
        return option;
    }

    /**
     * Este método imprime una despedida
     */
    public static void bye(){
        System.out.println("Gracias por usar el programa");
    }

    /**
     * Este método imprime un error de dinero
     */
    public static void moneyError(){
        System.out.println("La cantidad introducida es errónea");
    }

    /**
     * Este método recibe 2 enteros, uno es el balance del jugador
     * y el otro el dinero ganado por el jugador
     * @param balance Recibe el dinero total que posee el jugador
     * @param moneyEarned Recibe el dinero que ha ganado el jugador en esta ronda
     */
    public static void moneyWinMessage(int balance,int moneyEarned){
        System.out.println("Felicidades, has ganado: "+moneyEarned+" puntos.\n" +
                "Tienes actualmente "+balance+" puntos de saldo.");
    }

    /**
     * Este método indica que ha habido un empate
     */
    public static void moneyDrawMessage(){
        System.out.println("Habéis empatado, tu saldo se queda igual");
    }

    /**
     * Este método recibe 2 enteros, uno es el saldo del jugador y
     * el otro el dinero que ha perdido el jugador en esta ronda
     * @param balance Recibe el dinero total que posee el jugador
     * @param moneyEarned Recibe el dinero que ha perdido el jugador en esta ronda
     */
    public static void moneyLoseMessage(int balance,int moneyEarned){
        System.out.println("Has perdido: "+moneyEarned+" puntos.\n" +
                "Tienes actualmente "+balance+" puntos de saldo.");
    }

    /**
     * Este método recibe el saldo del jugador e imprime el saldo que tiene el mismo
     * @param balance Recibe el dinero total que posee el jugador
     */
    public static void checkBalance(int balance){
        System.out.println("Tu saldo actual es de "+balance+" puntos");
    }

    /**
     * Este método recibe un String con la figura de un trofeo y la imprime
     * @param figure Recibe la figura que queremos representar.
     */
    public static void trophyPrint(String figure){
        System.out.println(figure);
    }

    /**
     * Este método recibe un mensaje para imprimir y devuelve un entero
     * que es una opción para seleccionar el trofeo deseado
     * @param msg Recibe un String para representar por pantalla
     * @return Devuelve un entero
     */
    public static int thophyOptionCheck(String msg){
        int result=-1;
        while (result<1 || result>6){
            result=UI.readInt(msg);
        }
        return result;
    }

}
