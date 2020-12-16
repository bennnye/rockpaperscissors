package rockpaperscisors;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class Rockpaperscisors {

    static String[] choices = {"rock", "paper", "scissors"};
    static String playerChoice = "a";
    static String computerChoice = "b";
    static String winner = "c";
    static int playerScore = 0;
    static int computerScore = 0;

    public static void main(String[] args) {
        System.out.println("welcome to rock paper scissors");
        System.out.println("the rules are rock beats scissors, scissors beat paper and paper beats rock");
 
        play();
    }

    public static void play() {
        playerScore = 0;
        computerScore = 0;
        for (int i = 0; i < 4; i++) {
            getPlayerChoice();
            playerChoiceValid();
            getComputerChoice();
            decideWinner();
            changeScore();
            printScore();
        }

        System.out.println("this is the final round it is worth 2 points. you can't tie in this round.");
        getPlayerChoice();
        playerChoiceValid();
        getComputerChoiceFinal();
        decideWinner();
        changeScoreFinal();
        printScore();

        playAgain();
    }

    public static String getPlayerChoice() {
        Scanner scan = new Scanner(System.in);
        System.out.println("player make your choise");
        playerChoice = scan.next();
        return playerChoice;
    }

    public static String playerChoiceValid() {
        ArrayList<String> choicesList = new ArrayList<>();
        choicesList.addAll(Arrays.asList(choices));
        if (choicesList.contains(playerChoice)) {
            System.out.println("choice valid");
        } else {
            getPlayerChoice();
        }
        return playerChoice;
    }

    public static String getComputerChoice() {
        Random random = new Random();
        int computerInt = random.nextInt(3);
        for (int i = 0; i < choices.length; i++) {
            if (i == computerInt) {
                computerChoice = choices[i];
            }
        }
        return computerChoice;
    }

    public static String decideWinner() {
        if (playerChoice.equals("rock") && computerChoice.equals("scissors")) {
            winner = "player";
        } else if (playerChoice.equals("scissors") && computerChoice.equals("paper")) {
            winner = "player";
        } else if (playerChoice.equals("paper") && computerChoice.equals("rock")) {
            winner = "player";
        } else if (playerChoice.equals(computerChoice)) {
            winner = "no winner";
        } else {
            winner = "computer";
        }
        System.out.println("the winner is " + winner);
        System.out.println("the computer picked " + computerChoice);
        return winner;
    }

    public static void changeScore() {
        if (winner.equals("player")) {
            playerScore = playerScore + 1;
        }
        if (winner.equals("computer")) {
            computerScore = computerScore + 1;
        }
    }

    public static void printScore() {
        System.out.println("the score is: " + playerScore + " - " + computerScore);
    }

    public static String getComputerChoiceFinal() {
        getComputerChoice();
        while (computerChoice.equals(playerChoice)) {
            getComputerChoice();
        }
        return computerChoice;
    }

    public static void changeScoreFinal() {
        if (winner.equals("player")) {
            playerScore = playerScore + 2;
        }
        if (winner.equals("computer")) {
            computerScore = computerScore + 2;
        }
    }

    public static void playAgain() {
        Scanner scan = new Scanner(System.in);
        System.out.println("would you like to play again? (yes/no)");
        String playAgain = scan.next();
        if (playAgain.equals("yes")) {
            play();
        } else {
            System.out.println("thank you for playing");
        }
    }
}
