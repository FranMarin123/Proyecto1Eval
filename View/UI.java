package View;

import java.util.Scanner;

public class UI {
    /**
     * Este método recibe un String con un mensaje que muestra por pantalla
     * y devuelve un entero, comprobando que sea un número entero correcto
     * @param msg Recibe un String con el mensaje que queremos mostrar pon pantalla
     * @return Devuelve un entero
     */
    public static int readInt(String msg){
        Scanner keyboard = new Scanner(System.in);
        int num=0;
        boolean comp=false;

        do {
            System.out.println(msg);
            try {
                num = keyboard.nextInt();
                comp = true;
            } catch (Exception e) {
                System.out.println("Error: El numero no es un entero");
                keyboard.nextLine();
            }
        } while (!comp);
        return num;
    }

    /**
     * Este método recibe un String y devuelve un String pedido por pantalla
     * @param msg Recibe un String que representa por pantalla
     * @return Devuelve un String
     */
    public static String readString(String msg){
        Scanner keyboard=new Scanner(System.in);
        System.out.print(msg+": ");
        return keyboard.nextLine();
    }

    /**
     * Este método pide al usuario que inserte un intro para continuar
     */
    public static void pressEnter(){
        Scanner keyboard=new Scanner(System.in);
        System.out.println("Pulse enter para continuar ...");
        keyboard.nextLine();
    }
}

