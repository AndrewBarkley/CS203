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
   static Check verify = new Check();
   private Random random;
   static int[][] board;
   static int size = 1;
   static long startTime = 0;
   static long endTime = 0; 
   
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
      
   	//intialize board
      board = new int[size][size];
      for(int i=0; i<size; i++)
      {
         for(int j=0; j<size; j++)
         {
            board[i][j] = 0;
         }	
      }
   
   	// Place Queens
      cycle(1,0,0);
      
      //End Timer
      endTime = System.nanoTime();
   
      System.out.print("The puzzle was solved in: ");
      System.out.println((endTime - startTime) + " nanoSeconds");
      for(int i=0; i<size; i++)
      {
         for(int j=0; j<size; j++)
         {
            System.out.print(board[j][i]);
            System.out.print(" ");
         }	
         System.out.println("");
      }
   }




		//-------------------------------------------------------------
		// Make this a recursive method:
		// After placing a queen call method with x & y being the next line
		// Repeat until solved or a dead end
		//	If dead end, return false
		//-------------------------------------------------------------
   public static boolean cycle(int queen, int x, int y)
   {
      while(y < size)
      {
      	//if board space is open
         if(board[x][y] == 0)
         {
         	//and if there are no conflicting pieces
            if(verify.check(size,board,x,y) == true)
            {
            	//place the queen in this spot
               board[x][y] = 1;
            	//if it is the last queen, collapse the method
               if(queen == size)
               {
                  return true;
               }
               //call next instance and collapse method if solution is found
               else if(cycle(queen+1,0,y+1) == true)
               {
                  return true;
               }
               //if solution was not found reset spot to empty and continue
               else
               {
                  board[x][y] = 0;
               }
            }
         }
      	//cycle through each spot
         x++;
         if(x >= size)
         {
            x=0;
            y++;
         }
      }
   	//you have exceeded the board, solution was not found, collapse instance
      return false;
   }

}








