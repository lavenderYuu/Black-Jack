package model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

// Represents a player having cards, the total point of the cards, money (in dollars)
public class Player {

    private static final int INITIAL_FUND = 1000;
    private static final List<String> givenList =
            Arrays.asList("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K");
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
    //Effects: draw a new card in the given list
    public void hitCard() {
        Random rand = new Random();
        int randIndex = rand.nextInt(givenList.size());
        String newCard = givenList.get(randIndex);

        cards.add(newCard);
    }


    //Effects: calculate the total point of the cards we given
    public int calculate(List<String> cards) {
        int point = 0;
        int numA = 0;

        for (String card: cards) {
            if (cardSize(card) == 1) {
                numA++;
            } else {
                point += cardSize(card);
            }
        }

        for (int i = 0; i < numA; i++) {
            if ((point + 11) <= 21) {
                point += 11;
            } else {
                point += 1;
            }
        }

        return point;
    }

    //EFFECTS: get each card value
    public int cardSize(String card) {
        int value;
        if (card.equals("A")) {
            value = 1;
        } else if (card.equals("2")) {
            value = 2;
        } else if (card.equals("3")) {
            value = 3;
        } else if (card.equals("4")) {
            value = 4;
        } else if (card.equals("5")) {
            value = 5;
        } else if (card.equals("6")) {
            value = 6;
        } else if (card.equals("7")) {
            value = 7;
        } else if (card.equals("8")) {
            value = 8;
        } else if (card.equals("9")) {
            value = 9;
        } else {
            value = 10;
        }

        return value;
    }

    //REQUIRES: times is an integer, money >= bid > 0
    //MODIFIES: this
    //EFFECTS: get or lose the money according the result of the game
    public void moneyAddMins(int times, int bid) {
        money += times * bid;
    }

    //MODIFIES: this
    //EFFECTS: get the total point for the set of card player have now
    public int getTotalPoint() {
        totalPoint = calculate(cards);
        return totalPoint;
    }

    //EFFECTS: get the money player have
    public int getMoney() {
        return money;
    }

    //EFFECTS: get the card set player have now
    public List<String> getCards() {
        return cards;
    }
}
