//***********************************************
//Zachary Mosley                                *
//Login ID: mosl8748                            *
//CS203, Summer 2017                            *
//Programming Assignment 1                      *
//Execute: Running method                       *
//***********************************************

import java.util.*;
import java.io.*;

public class Execute
{
   private Prog1 main = new Prog1();
   //private Queen queen = new Queen();
   private boolean solved = false;

   //while(not solved)
   //   Step 1: Compare the queens conflicts
   //   Step 2: Compare the slots in that column
   //   Step 3: Move that Queen to that Slot
   //   Step 4: Call check()
   //   Step 5: Check if solved
   public void cycle(int size, Queen[]queens, int[][]board)
   {
      // while(not solved)
      while(solved == false)
      {
         // Step 1: Compare the queens conflicts
         int highQueen = 0;
         int highConflict = queens[highQueen].getConflict();
         for(int i=1; i<size; i++)
         {
            int currentQueen = queens[i].getConflict();
            if( currentQueen >= highConflict )                    //ERROR HERE
            {
               highConflict = currentQueen;
               highQueen = i;
            }
         }
      
         //Check the column's conflicts
         for(int i=0;i<size;i++)
         {
            check(size,board,queens,i,highQueen);
         }
         //---------------------
         // Step 2: Compare the slots in that column
         int lowSlot = 0;
         int lowConflict = board[0][highQueen];
         for(int i=1; i<size; i++)
         {
            int currentSlot = board[i][highQueen];
            if( currentSlot <= lowConflict )                      //AND SAME ERROR HERE
            {
               lowConflict = currentSlot;
               lowSlot = i;
            }
         }
      
         // Step 3: Move the Queen to that slot
         queens[highQueen].setRow(lowSlot);
      
         // Step 4: Reassign queen conflict data
         for(int i=0;i<size;i++)
         {
            check(size,board,queens,queens[i].getRow(),i);
         }
      
         // Step 5: Check is board is solved
         solved = true;
         for(int i=0; i<size; i++)
         {
            if(queens[i].getConflict() != 0)
               solved = false;
         }
      
      }
   
   }
   
   public void check(int size,int[][] board, Queen[] queens, int row, int column)
   {
   	
   	//run a horizontal and diagonal check for the given spot
   	//returns True if puzzle is solved
   	
      
      int conflicts = 0;
      //horizontal check   
      for(int i=0;i<size;i++)
      {                  
         if(queens[i].getRow() == row && i != column)
            conflicts++;
      }   
   
      //------------------
   
      // Diagonal Check
      int rise = 0;
      int run = 0;
      int i = 0;
      for(int j=0;j<size;j++)
      {
         i = queens[j].getRow();
         if(j != column)
         {
            rise = row - i;
            run = column - j;
            if((rise/run) == 1 || (rise/run) == -1)
               conflicts++;
         }   
      }
   
      board[row][column] = conflicts;
      if(queens[column].getRow() == row)
         queens[column].setConflict(conflicts);
   
   }//check()
   
}//execute()