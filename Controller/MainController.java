package Controller;

import View.MainMenu;

public class MainController {
    public static void programExecute(){
        typeGameSelect();
        //WithoutBetController.withoutBetController();
    }

    public static void typeGameSelect(){
        int option=MainMenu.mainMenu();
        switch (option){
            case 1:
                WithoutBetController.withoutBetController();
                break;
            case 2:
                BetController.betController();
            default:
                break;
        }
    }
}
