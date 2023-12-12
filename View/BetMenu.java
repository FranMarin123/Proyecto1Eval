package View;

public class BetMenu {
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

    public static void bye(){
        System.out.println("Gracias por usar el programa");
    }

    public static void moneyError(){
        System.out.println("La cantidad introducida es errónea");
    }

    public static void moneyWinMessage(int balance,int moneyEarned){
        System.out.println("Felicidades, has ganado: "+moneyEarned+" puntos.\n" +
                "Tienes actualmente "+balance+" puntos de saldo.");
    }
    public static void moneyDrawMessage(){
        System.out.println("Habéis empatado, tu saldo se queda igual");
    }
    public static void moneyLoseMessage(int balance,int moneyEarned){
        System.out.println("Felicidades, has perdido: "+moneyEarned+" puntos.\n" +
                "Tienes actualmente "+balance+" puntos de saldo.");
    }
    public static void checkBalance(int balance){
        System.out.println("Tu saldo actual es de "+balance+" puntos");
    }

    public static void trophyPrint(String figure){
        System.out.println(figure);
    }

    public static int thophyOptionCheck(String msg){
        int result=-1;
        while (result<1 || result>6){
            result=UI.readInt(msg);
        }
        return result;
    }

}
