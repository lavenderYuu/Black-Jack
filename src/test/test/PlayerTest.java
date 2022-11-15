package test;

import model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Test for the player
class PlayerTest {
    private Player player;
    private static final int INITIAL_FUND = 1000;

    @BeforeEach
    public void setup() {
        player = new Player();
    }

    @Test
    public void testConstructor() {
        assertEquals(INITIAL_FUND, player.getMoney());
        assertEquals(0, player.getTotalPoint());
        assertEquals(0, player.getBet());
        assertEquals(0, player.getCards().size());

        player.placeBet(100);
        assertEquals(100, player.getBet());
    }

    @Test
    public void testHitCard() {
        player.hitCard();
        assertEquals(1, player.getCards().size());
    }


    @Test
    public void testHitMultipleCards() {
        player.hitCard();
        player.hitCard();
        player.hitCard();
        assertEquals(3, player.getCards().size());
        player.hitCard();
        player.hitCard();
        assertEquals(5, player.getCards().size());

    }

    @Test
    public void testCardSize() {
        int i;
        i = player.cardSize("A");
        assertEquals(1, i);

        i = player.cardSize("2");
        assertEquals(2, i);

        i = player.cardSize("3");
        assertEquals(3, i);

        i = player.cardSize("4");
        assertEquals(4, i);

        i = player.cardSize("5");
        assertEquals(5, i);

        i = player.cardSize("6");
        assertEquals(6, i);

        i = player.cardSize("7");
        assertEquals(7, i);

        i = player.cardSize("8");
        assertEquals(8, i);

        i = player.cardSize("9");
        assertEquals(9, i);

        i = player.cardSize("10");
        assertEquals(10, i);

        i = player.cardSize("J");
        assertEquals(10, i);

        i = player.cardSize("Q");
        assertEquals(10, i);

        i = player.cardSize("K");
        assertEquals(10, i);
    }

    @Test
    public void testCalculate() {
        int point;
        point = player.calculate(Arrays.asList("A", "2"));
        assertEquals(13, point);

        point = player.calculate(Arrays.asList("A", "A"));
        assertEquals(12, point);

        point = player.calculate(Arrays.asList("A", "A", "A"));
        assertEquals(13, point);

        point = player.calculate(Arrays.asList("A", "2", "J"));
        assertEquals(13, point);

        point = player.calculate(Arrays.asList("A", "K"));
        assertEquals(21, point);

        point = player.calculate(Arrays.asList("3", "2"));
        assertEquals(5, point);

        point = player.calculate(Arrays.asList("Q", "K"));
        assertEquals(20, point);

        point = player.calculate(Arrays.asList("A", "2", "3", "4", "5"));
        assertEquals(15, point);

        point = player.calculate(Arrays.asList("Q", "K", "J"));
        assertEquals(30, point);
    }

    @Test
    public void testMoneyAddMins() {
        player.moneyAddMins(1, 10);
        assertEquals(INITIAL_FUND + 10, player.getMoney());

        player.moneyAddMins(-1, 100);
        assertEquals(INITIAL_FUND - 90, player.getMoney());
    }
}