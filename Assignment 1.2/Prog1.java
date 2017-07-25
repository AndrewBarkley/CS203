//***********************************************
//Zachary Mosley                                *
//Login ID: mosl8748                            *
//CS203, Summer 2017                            *
//Programming Assignment 1                      *
//Prog1: Main method                            *
//***********************************************

//Current solution is unreliable in that time can vary alot
//and it can take a long time

import java.util.*;
import java.io.*;

public class Prog1
{
   /*
   1 - import libraries and other project files
   2 - Using a scanner recieve the value for 'N'
   3 - initialize the board array
   4 - 
   5 - 
   F - repeat step 4 & 5 until solved 
   */
   private static Execute run = new Execute();
   public static int[][] board;
   public static Queen[] queens;
   private static long startTime = 0;
   private static long endTime = 0; 
   public static int size = 0;
   private static Random random = new Random();
   
   public static void main(String[] args) 
   {
      Scanner user = new Scanner(System.in);
      while( size < 4 )
      {
         System.out.print("Please enter a value for 'N' that is greater than 3: ");
         try
         {
            size = user.nextInt();
         }
         catch(InputMismatchException handeled)
         {
            user = new Scanner(System.in);
         }       
      }
      System.out.println("Your 'N' value is: " + size);
      
      //Start Timer
      startTime = System.nanoTime();
      
      // Intialize arrays
      board = new int[size][size];
      queens = new Queen[size];
      for(int i=0; i<size; i++)
      {
         queens[i] = new Queen(random.nextInt(size));
         for(int j=0; j<size; j++)
         {
            board[i][j] = 0;
         }  
      }
   
      //intialize queen conflict data
      for(int i=0;i<size;i++)
      {
         run.check(size,board,queens,queens[i].getRow(),i);
      }
   
      // Start Sequence
      run.cycle(size,queens,board);
      
      //End Timer
      endTime = System.nanoTime();
   
      System.out.print("The puzzle was solved in: ");
      System.out.println((endTime - startTime) + " nanoSeconds");
      System.out.print("This can also be read as: ");
      System.out.println((endTime - startTime)/(float)(1000000000) + " Seconds");
      for(int j=0; j<size; j++)
      {
         for(int i=0; i<size; i++)
         {
            if(queens[i].getRow() == j)
               System.out.print("1");
            else
               System.out.print("0");
            System.out.print(" ");
         }  
         System.out.println("");
      }
   }


      //-------------------------------------------------------------
      // Make this a recursive method:
      // After placing a queen call method with x & y being the next line
      // Repeat until solved or a dead end
      // If dead end, return false
      //-------------------------------------------------------------
   

}








