package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static jdk.nashorn.internal.runtime.JSType.isString;
import static model.Player.INITIAL_FUND;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlayerTest {
    private Player player;

    @BeforeEach
    public void setup() {
        player = new Player();
    }

    @Test
    public void testConstructor() {
        assertEquals(INITIAL_FUND, player.getMoney());
        assertEquals(0, player.getTotalPoint());
        assertEquals(0, player.getCardsSize());
    }

    @Test
    public void testHitCards() {
        player.hitCard();
        player.hitCard();
        player.hitCard();
        assertTrue(isString(player.getCard(2)));
        player.hitCard();
        player.hitCard();
        assertTrue(isString(player.getCard(4)));

    }

    @Test
    public void testCalculate() {
        int point;
        point = player.calculate(Arrays.asList("A", "2"));
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
}