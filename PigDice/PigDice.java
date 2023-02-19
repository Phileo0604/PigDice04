package PigDice;

import java.util.Random;
import java.util.Scanner;

public class PigDice {

    public static void main(String[] args) {

        // Create Player objects
        Player A = new Player();
        Player B = new Player();
        int currentTurn = 1;

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Select gamemode
        int goal = 20;
        int totalDice = 1;
        System.out.println("----- Choose gamemode -----");
        System.out.println("[1] Maxscore = 20 | 1 Die");
        System.out.println("[2] Maxscore = 80 | 2 Dice");
        if (input.nextInt() == 2) {
            goal = 80;
            totalDice = 2;
        }

        // Set dice range and dice roll
        int max = 6;
        int min = 1;
        Random rand = new Random();
        int diceRoll = 0;
        int diceRoll2 = 0;
        int pointsGained = 0;

        // Loops turns
        while (A.getTotalPoints() < goal && B.getTotalPoints() < goal) {
            // Player 1's turn
            if (currentTurn == 1) {
                // Prompt selection of move (roll/hold)
                System.out.println("Current turn: " + A.getTurn() + " | Player " + currentTurn + "'s move");
                System.out.println("[1] to roll");
                System.out.println("[2] to hold");
                switch (input.nextInt()) {
                    case 1:
                        // Roll die/dice
                        diceRoll = rand.nextInt(max - min) + min;
                        diceRoll2 = rand.nextInt(max - min) + min;

                        // Dice roll on gamemode 1
                        if (totalDice == 1) {
                            pointsGained = diceRoll;
                            A.setDiceRoll(pointsGained);
                            System.out.println("You rolled a " + diceRoll);
                            // Dice roll on gamemode 2
                        } else if (totalDice == 2) {
                            pointsGained = diceRoll + diceRoll2;
                            A.setDiceRoll(pointsGained);
                            System.out.println("You rolled a " + diceRoll + " and a " + diceRoll2);
                        }

                        // If player rolls all 1s
                        if (diceRoll == 1 && totalDice == 1 || diceRoll == 1 && diceRoll2 == 1 && totalDice == 2) {
                            pointsGained = 0;
                            System.out.println("lol noob");
                        } else
                            // Add points based on dice roll
                            A.addPoints();

                        break;

                    case 2:
                        // Add points based on turn number
                        pointsGained = A.getTurn();
                        A.setTotalPoints(A.getTotalPoints() + pointsGained);
                        break;
                    default:
                        break;
                }

                // Show Scoreboard
                System.out.println();
                System.out.println("----- Scoreboard -----");
                System.out.println("Player 1's score: " + A.getTotalPoints() + "(+" + pointsGained + ")");
                System.out.println("Player 2's score: " + B.getTotalPoints());
                // Increment turn number
                A.setTurn(A.getTurn() + 1);
                currentTurn = 2;
                // Player 2's turn
            } else {
                // Prompt selection of move (roll/hold)
                System.out.println("Current turn: " + B.getTurn() + " | Player " + currentTurn + " 's move");
                System.out.println("[1] to roll");
                System.out.println("[2] to hold");
                switch (input.nextInt()) {
                    case 1:
                        // Roll die/dice
                        diceRoll = rand.nextInt(max - min) + min;
                        diceRoll2 = rand.nextInt(max - min) + min;
                        // Dice roll on gamemode 1
                        if (totalDice == 1) {
                            pointsGained = diceRoll;
                            B.setDiceRoll(pointsGained);
                            System.out.println("You rolled a " + diceRoll);
                            // Dice roll on gamemode 2
                        } else if (totalDice == 2) {
                            pointsGained = diceRoll + diceRoll2;
                            B.setDiceRoll(pointsGained);
                            System.out.println("You rolled a " + diceRoll + " and a " + diceRoll2);
                        }

                        // If player rolls all 1s
                        if (diceRoll == 1 && totalDice == 1 || diceRoll == 1 && diceRoll2 == 1 && totalDice == 2) {
                            pointsGained = 0;
                            System.out.println("lol noob");
                        } else
                            // Add points based on dice roll
                            B.addPoints();
                        break;

                    case 2:
                        // Add points based on turn number
                        pointsGained = B.getTurn();
                        B.setTotalPoints(B.getTotalPoints() + pointsGained);
                        break;
                    default:
                        break;
                }

                // Show Scoreboard
                System.out.println();
                System.out.println("----- Scoreboard -----");
                System.out.println("Player 1's score: " + A.getTotalPoints());
                System.out.println("Player 2's score: " + B.getTotalPoints() + "(+" + pointsGained + ")");
                // Increment turn number
                B.setTurn(B.getTurn() + 1);
                currentTurn = 1;
            }
            System.out.println("__________________________________________________________________________________");
        }

        // Announce winner
        System.out.println();
        if (A.getTotalPoints() >= goal) {
            System.out.println("Congratulations! Player 1 Wins!\n");
        } else if (B.getTotalPoints() >= goal) {
            System.out.println("Congratulations! Player 2 Wins!\n");
        } else {
            System.out.println("something is wrong...");
        }
    }
}
