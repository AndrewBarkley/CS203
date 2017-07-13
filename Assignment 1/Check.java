//***********************************************
//Zachary Mosley                                *
//Login ID: mosl8748                            *
//CS203, Summer 2017                            *
//Programming Assignment 1                      *
//Prog1: Checking method                        *
//***********************************************

import java.util.*;
import java.io.*;

public class Check
{
	public boolean check(int size,int[][] board, int x, int y)
	{
		/*
		run a vertical, horizontal, and diagonal check for the given spot
		returns True if puzzle is solved
		*/

		//horizontal check
		for(int i=0; i<size; i++)
		{
			if(board[i][y] != 0)
				return false;
		}
		
		//vertical check
		for(int i=0; i<size; i++)
		{
			if(board[x][i] != 0)
				return false;
		}

		//4 diagonal checks
		int i = x;
		int j = y;
		
		//upper left check
		while(i>=0 && j>=0)
		{
			if(board[i][j] != 0)
				return false;
			i--;
			j--;
		}
		i = x;
		j = y;

		//lower left check
		while(i>=0 && j<size)
		{
			if(board[i][j] != 0)
				return false;
			i--;
			j++;
		}
		i = x;
		j = y;

		//upper left check
		while(i<size && j>=0)
		{
			if(board[i][j] != 0)
				return false;
			i++;
			j--;
		}
		i = x;
		j = y;

		//upper left check
		while(i<size && j<size)
		{
			if(board[i][j] != 0)
				return false;
			i++;
			j++;
		}

		return true;
	}
}