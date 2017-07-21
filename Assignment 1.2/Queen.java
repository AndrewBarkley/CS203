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
	private int column;
	private int conflict;

	public Queen()
	{
		row = 0;
		column = 0;
		//have a base conflict of 1 to ensure at least one instance of testing
		conflict = 1;
	}

	public setRow(int row)
	{
		this = row;
	}
	public setRow(int column)
	{
		this = column;
	}
	public setRow(int conflict)
	{
		this = conflict;
	}
	
}
