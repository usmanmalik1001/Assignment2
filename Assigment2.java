/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;
import java.util.*;
import java.lang.*;

/**
 *
 * @author Usman
 */

public class Assignment2 {
    static int []total = new int[100]; 
    static int rounds = 0;
    static int sum = 0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for (int i=0; i<100; i++) 
        {
            rounds = 0;
            snakeGame();
            total[i] = rounds;
            sum += rounds;
        }
        for (int i=0; i<100; i++)
            System.out.println(total[i]); //Printing the number of rounds per game
        
        Arrays.sort(total);
        System.out.println("Average number of rounds per game: " + ((float)sum/(float)100));
        System.out.println("Maximum number of rounds per game: " + total[99]);
        System.out.println("Minimum number of rounds per game: " + total[0]);
    }
    public static void snakeGame()
    {
        int [] board = new int[101];
        Random randomGenerator = new Random();
        int numOfPlayers = randomGenerator.nextInt(5-2) + 2; //Random number generator from 2 to 4 players
        int dice = 0;
        // TODO code application logic here
        for (int i=1; i<101; i++)
        {
            board[i]=i;
            if (i==18 || i==50 || i==69) //The indices which will be used as ladders
                board[i]=i+18; 
            if (i==25 || i==40 || i==98) //The indices which will be used as snakes
                board[i]=i-20;
        }   
        int [] players = new int [numOfPlayers];
        int [] isBitten = new int [numOfPlayers];
        for (int i=0; i<numOfPlayers; i++)
        {
            players[i] = 0; //Starting position of all the players
            isBitten[i] = 0; //A boolean array to check if the player is bitten or not
        }
        while (true)
        {
            for (int i=0; i<numOfPlayers; i++)
            {
                dice = randomGenerator.nextInt(6)+1; //Random output of throwing the dice, 1-6
                if (outOfBoard(players[i]+dice)) //If any player gets an output of more than a 100
                    continue;
                if (isBitten[i] == 1 && dice == 6) //If bitten player gets a 6, it continues
                    isBitten[i] = 0;
                else //If bitten player gets something other than a 6
                    continue; 
                System.out.println("Player " + (i+1) + " throws " + dice + "");
                if (isWinner(players[i]+dice)) //If any player reaches 100 the game ends
                {
                    System.out.println("Player " + (i+1) + " on " + (players[i]+dice) + " position.");
                    System.out.println("Player " + (i+1) + " has won the game.");
                    return;
                }   
                if (sameTurn(dice)) //If the turn has to be repeated
                {
                    players[i] += dice;
                    i--;
                    continue;
                }
                players[i] = board[players[i]+dice];
                if (players[i] == 18 || players[i] == 50 || players[i] == 69) //If player arrives on a ladder it gets a turn again
                {
                    i--;
                    continue;
                }
                if (players[i] == 25 || players[i] == 40 || players[i] == 98) //If player arrives on a snake it gets a bitten value
                {
                    isBitten[i] = 1;
                }
                System.out.println("Player " + (i+1) + " on " + players[i] + " position.");
            }
            rounds++;
        }
    }
    public static boolean isWinner(int player)
    {
        if (player == 100)
            return true;
        else
            return false;
    }
    
    public static boolean sameTurn (int dice)
    {
        if (dice == 6)
            return true;
        else 
            return false;
    }
    
    public static boolean outOfBoard(int value)
    {
        if(value > 100)
            return true;
        else
            return false;
    }
}
