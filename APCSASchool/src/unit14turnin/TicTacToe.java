package unit14turnin;

import java.util.Scanner;
import static java.lang.System.*;

public class TicTacToe
{
	private char[][] mat;

	public TicTacToe()
	{
		mat = new char[3][3];
	}

	public TicTacToe(String game)
	{
		mat = new char[3][3];
		
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				mat[i][j]=game.charAt(3*i+j);
			}
		}
		
	}

	public String getWinner()
	{
		//checks horizontal wins
		for(int i=0;i<3;i++){
			char c=mat[i][0];
			int cnt = 0;
			for(int j=0;j<3;j++){
				if(mat[i][j]==c)
					cnt++;
			}
			if(cnt==3)
				return Character.toString(c)+"h";
			else
				cnt = 0;
		}
		//checks vertical wins
		for(int i=0;i<3;i++){
			char c=mat[0][i];
			int cnt = 0;
			for(int j=0;j<3;j++){
				if(mat[j][i]==c)
					cnt++;
			}
			if(cnt==3)
				return Character.toString(c)+"v";
			else
				cnt = 0;	
		}
		//checks diagonal wins
			char c=mat[0][0];
			int cnt = 0;
			for(int j=0;j<3;j++){
				if(mat[j][j]==c)
					cnt++;
			}
			if(cnt==3)
				return Character.toString(c)+"d";
			else
				cnt = 0;
			c=mat[0][2];
			if(mat[1][1]==c&&mat[2][0]==c)
				return Character.toString(c)+"d";
			
		return "cats";
	}

	public String toString()
	{
		String output="";
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				output = output + mat[i][j];
			}
			output = output + "\n";
		}
		if(getWinner().equals("Xh"))
			output = output + "X wins horizontally!";
		else if(getWinner().equals("Oh"))
			output = output + "O wins horizontally!";
		else if(getWinner().equals("Xv"))
			output = output + "X wins vertically!";
		else if(getWinner().equals("Ov"))
			output = output + "O wins vertically!";
		else if(getWinner().equals("Xd"))
			output = output + "X wins diagonally!";
		else if(getWinner().equals("Od"))
			output = output + "O wins diagonally!";
		else if(getWinner().equals("cats"))
			output = output + "cat's game - no winner!";

		return output+"\n\n";
	}
}