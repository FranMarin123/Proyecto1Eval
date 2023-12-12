package View;

import java.util.Scanner;

public class UI {
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

    public static String readString(String msg){
        Scanner keyboard=new Scanner(System.in);
        System.out.print(msg+": ");
        return keyboard.nextLine();
    }

    public static void pressSpace(){
        Scanner keyboard=new Scanner(System.in);
        System.out.println("Pulse enter para continuar ...");
        keyboard.nextLine();
    }
}

