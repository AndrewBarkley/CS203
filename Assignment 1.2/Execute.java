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
   private boolean solved = false;

   public boolean cycle(int size, int[][]queens, int[][]board)
   {
      //while(not solved)
      //   Step 1: Compare the queens conflicts
      //   Step 2: Compare the slots in that column
      //   Step 3: Move that Queen to that Slot
      //   Step 4: Call check()
      while(solved == false)
      {
         int highQueen = 0;
         for(int i=0; i<size; i++)
         {
            currentQueen = board[queens[][]][queens[][]]
            if( )
         }

      }

   }

   private boolean check(int size,int[][] board)
   {
   	/*
   	run a vertical, horizontal, and diagonal check for the given spot
   	returns True if puzzle is solved
   	*/
      
      int conflicts = 0;
      //vertical check
      for(int x=0;x<size;x++)
      {
         for(int y=0;y<size;y++)
         {                     
            if(board[x][y] != 0)
               conflicts++;
         }
         if (conflicts > 1)
            return false;
         else
            conflicts = 0;
      }
      
            	
      //-----------------

      //horizontal check   
      for(int y=0;y<size;y++)
      {
         for(int x=0;x<size;x++)
         {                  
            if(board[x][y] != 0)
               conflicts++;
         }
         if (conflicts > 1)
            return false;
         else
            conflicts = 0;
      }
      

      //------------------

      // Diagonal Check #1
      for(int x=0;x<size;x++)
      {
         int i = x;
         int j = 0;
         while( i>0 )
         {
            if(board[i--][j++] != 0)
               conflicts++;
         }

         if (conflicts > 1)
            return false;
         else
            conflicts = 0;
      }

      for(int y=0;y<size;y++)
      {
         int i = size-1;
         int j = y;
         while( j<size )
         {
            if(board[i--][j++] != 0)
               conflicts++;
         }
         
         if (conflicts > 1)
            return false;
         else
            conflicts = 0;
      }      

      // Diagonal Check #2
      for(int x=size-1;x>=0;x--)
      {
         int i = x;
         int j = 0;
         while( i<size )
         {
            if(board[i++][j++] != 0)
               conflicts++;
         }

         if (conflicts > 1)
            return false;
         else
            conflicts = 0;
      }

      for(int y=0;y<size;y++)
      {
         int i = 0;
         int j = y;
         while( j<size )
         {
            if(board[i++][j++] != 0)
               conflicts++;
         }
         
         if (conflicts > 1)
            return false;
         else
            conflicts = 0;
      }
      
   	//The entire puzzle has passed checks
      return true;
   
   }
}