package Controller;

import View.MainMenu;

public class MainController {
    public static void programExecute(){
        typeGameSelect();
        //WithoutBetController.withoutBetController();
    }

    public static void typeGameSelect(){
        int option=-1;
        do {
            option = MainMenu.mainMenu();
            switch (option) {
                case 1:
                    WithoutBetController.withoutBetController();
                    break;
                case 2:
                    BetController.betController();
                    break;
                case 3:
                    System.out.println("Gracias por usar este programa!");
                    break;
                default:
                    System.out.println("Opción incorrecta");
                    break;
            }
        }while (option!=3);
    }
}
