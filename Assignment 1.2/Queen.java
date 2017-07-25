//***********************************************
//Zachary Mosley                                *
//Login ID: mosl8748                            *
//CS203, Summer 2017                            *
//Programming Assignment 1                      *
//Execute: Running method                       *
//***********************************************

import java.util.*;
import java.io.*;

public class Queen
{
	private int row;
	private int conflict;

	public Queen()
	{
		row = 0;
		//have a base conflict of 1 to ensure at least one instance of testing
		conflict = 1;
	}

	public Queen(int row)
	{
		this.row = row;
		conflict = 1;
	}

	public void setRow(int row)
	{
		this.row = row;
	}
	public void setConflict(int conflict)
	{
		this.conflict = conflict;
	}

	public int getRow()
	{
		return row;
	}
	public int getConflict()
	{
		return conflict;
	}
	
}
