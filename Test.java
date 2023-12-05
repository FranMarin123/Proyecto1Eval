import Model.Card;
import Model.Desk;
import Model.Player;

public class Test {
    public static void main(String[] args) {
        Desk fDesk = new Desk(new Card[1]);
        fDesk.frenchDesk();
        System.out.println(fDesk);
        System.out.println(fDesk.pickARandomCard());
        Player player1 = new Player(new Card[1], "Francisco", 0);
        player1.addCard(fDesk.pickARandomCard());
        System.out.println(player1);
        System.out.println(player1.getCards()[0]);
    }
}
