package model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

// Represents a player having cards, the total point of the cards, money (in dollars)
public class Player {

    static final int INITIAL_FUND = 100;
    private List<String> cards;
    private int totalPoint;
    private int money;

    //Effects: has initial fund and contains list of cards
    public Player() {
        money = INITIAL_FUND;
        cards = new ArrayList<>();
        totalPoint = 0;
    }

    //Modifies: this
    //Effects: draw a new card in the list
    public void hitCard() {
        List<String> givenList = Arrays.asList("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K");
        Random rand = new Random();
        int randIndex = rand.nextInt(givenList.size());
        String newCard = givenList.get(randIndex);

        cards.add(newCard);
    }

    //Modifies: this
    //Effects: calculate the total point of the cards we draw
    public int calculate(List<String> cards) {
        int point = 0;
        boolean isA = false;

        for (String card: cards) {
            if (cardSize(card) == 1) {
                isA = true;
            } else {
                point += cardSize(card);
            }
        }

        if (isA) {
            if ((point + 11) <= 21) {
                point += 11;
            } else {
                point += 1;
            }
        }

        totalPoint = point;
        return point;
    }

    //EFFECTS: get the card value
    public int cardSize(String card) {
        int value;
        if (card == "A") {
            value = 1;
        } else if (card == "2") {
            value = 2;
        } else if (card == "3") {
            value = 3;
        } else if (card == "4") {
            value = 4;
        } else if (card == "5") {
            value = 5;
        } else if (card == "6") {
            value = 6;
        } else if (card == "7") {
            value = 7;
        } else if (card == "8") {
            value = 8;
        } else if (card == "9") {
            value = 9;
        } else {
            value = 10;
        }

        return value;
    }

    public void moneyAddMins(int times, int bid) {
        money += times * bid;
    }

    public int getMoney() {
        return money;
    }

    public void clearCards() {
        cards.clear();
    }

    public int getTotalPoint() {
        calculate(cards);
        return totalPoint;
    }

    //REQUIRED: 0 <= index <= cards.size
    public String getCard(int index) {
        return cards.get(index);
    }

    public int getCardsSize() {
        return cards.size();
    }
}
