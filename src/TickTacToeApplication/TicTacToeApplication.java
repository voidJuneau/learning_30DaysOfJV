/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TickTacToeApplication;

import java.util.Scanner;

/**
 *
 * @author juneau
 */
public class TicTacToeApplication {
    
    
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean doYouWantToPlay = true;
        while (doYouWantToPlay) {
            // Setting up our tocken and AI
            System.out.println("Welcome to Tic Tac Toe! You are about to go against"
                    + "the master of Tic Tac Toe. Are you ready? I hope so!\n BUT FIRST, you"
                    + "must pick what character you want to be and which character I will be");
            System.out.println();
            System.out.println("Enter a single character that will represent you on the board");
            char playerToken = sc.next().charAt(0);
            System.out.println("Enter a single character that will represent your opponent on the board");
            char opponentToken = sc.next().charAt(0);
            TicTacToe game = new TicTacToe(playerToken, opponentToken);
            AI ai = new AI();
            // Set up the game
            System.out.println();
            System.out.println("Now we can start the game. To play, enter a numebr and your token shall be put "
                    + "in its place.\nThe numbers go from 1-9, left to right. We shall see who will win this round.");
            TicTacToe.printIndexBoard();
            System.out.println();
            
            // Let's play!
            while (game.gameOver().equals("not Over")) {
                if (game.currentMarker == game.userMarker) {
                    // USER TURN
                    System.out.println("It's your turn! Enter a spot for your token");
                    int spot = sc.nextInt();
                    while (!game.playTurn(spot)) {
                        System.out.println("Try again. " + spot + " it is invalid. This spot is already taken "
                                + "or it is out or range");
                        spot = sc.nextInt();
                    }
                    System.out.println("You picked " + spot + "!");
                } else {
                    // AI turn
                    System.out.println("It's my turn!");
                    // Pick spot
                    int aiSpot = ai.pickSpot(game);
                    game.playTurn(aiSpot);
                    System.out.println("I picked " + aiSpot + "!");
                }
                // Print out new board
                System.out.println();
                game.printBoard();
            }
            System.out.println(game.gameOver());
            System.out.println();
            // Set up a new game... or not depending on the response
            System.out.println("Do you want to play again? Enter Y if you do. "
                    + "Enter anything else if you are tired of me.");
            char response = sc.next().charAt(0);
            doYouWantToPlay = (response == 'y');
            System.out.println();
            System.out.println();
        }
    }
}
