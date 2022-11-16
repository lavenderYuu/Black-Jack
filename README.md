# Black Jack

## Introduction
A poker game - The Player attempts to beat the 
dealer by getting a count as close to 21 as possible, 
without going over 21.

### Card Values
It is up to each player if an ace is worth 1 or 11. 
Face cards are 10 and any other card is its value 
shown on the card.

### Rule
Each player has **100** for the initial fund. In each round, before the deal begins, each player places a bet.
After the player has placed their bets, they will receive two cards. The player decides whether to "**stand**"
(not ask for another card) or "**hit**" (ask for another card in an attempt to get closer to a count of 21, 
or even hit 21 exactly). Thus, a player may stand on the two cards originally dealt to them, 
or they may ask the dealer for additional cards, one at a time, until deciding to stand on the total 
(if it is 21 or under), or goes "**bust**" (if it is over 21). 

- If the player goes over 21, they have already lost their wager, even if the dealer goes bust as well.
- If the dealer goes over 21, the dealer pays the player who has stood the amount of that player's bet.
- If the dealer and player stand at 21 or less, the dealer pays the bet of the player having a 
higher total (not exceeding 21) and collects the bet of the player having a lower total. 
- If there is a stand-off (a player having the same total as the dealer), no chips are paid out or collected.

### Restriction

- The dealer needs to draw the cards until the total is 17 or more.
- Each person can have up to five cards

## Target Market
This application is designed for board game enthusiasts and players looking to pass the time.

## Reason for my interest
Black Jack is one of my favourite board games. I play it for the first time on the airline seat screen.
Without internet access on the airline, this game becomes the sole source of entertainment for the 15-hour flight. 
This game grew on me after that.
I remember once I had passed through all the game levels and earned 2,000,000 points from the initial 1,000 points. 
I even bragged about it to my friend who travelled with me.

The game is a lot of fun, and the rules are straightforward. 
We can play whenever there are more than two people. Therefore, I always play this game 
with my friends when we get together

## User Stories

- As a user, I want to be able to add a bet.
- As a user, I want to be able to view the card I had.
- As a user, I want to be able to hit a new card.
- As a user, I want to be able to stand for compare.
- As a user, I want to be able to start a new round.
- As a user, I want to be able to view the fund I had.
- As a user, I want to be able to save my fund.
- As a user, I want to be able to be able to load my fund.
- 
# Instructions for Grader

- You can generate the first required event related to adding Xs to a Y by click the draw button
- You can generate the second required event related to adding Xs to a Y by click the stand button
- You can locate my visual component by see the card drew by player
- You can save the state of my application by click the save and quit button
- You can reload the state of my application by click the yes in the load window (first window)