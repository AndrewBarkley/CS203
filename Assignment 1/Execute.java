//***********************************************
//Zachary Mosley                                *
//Login ID: mosl8748                            *
//CS203, Summer 2017                            *
//Programming Assignment 1                      *
//Execute: Checking method                          *
//***********************************************

import java.util.*;
import java.io.*;

public class Execute
{
   private Prog1 main = new Prog1();
   private int size = main.getSize();
   private int[][] board; 

   public boolean cycle(int queen, int x, int y)
   {
      size = main.getSize();
      board = main.getBoard();
      //if it is the last queen, collapse the method
      if(queen > size)
      {
         return check(size,board);
      }
      if(x >= size)
      {
         x=0;
         y++;
      }
      while(y < size)
      {
         //place the queen in this spot
         board[x][y] = 1;
            
            //call next instance and collapse method if solution is found
         if(cycle(queen+1,x+1,y) == true)
            return true;
         else//if solution was not found reset spot to empty and continue
            board[x][y] = 0;
            
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