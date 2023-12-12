import Model.Card;
import Model.Deck;
import Model.Player;

public class Test {
    public static void main(String[] args) {
        Deck fDeck = new Deck(new Card[1]);
        fDeck.frenchDeck();
        System.out.println(fDeck);
        System.out.println(fDeck.pickARandomCard());
        Player player1 = new Player(new Card[1], "Francisco", 0);
        player1.addCard(fDeck.pickARandomCard());
        System.out.println(player1);
        System.out.println(player1.getCards()[0]);
    }
}
