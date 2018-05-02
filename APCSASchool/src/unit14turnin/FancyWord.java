package unit14turnin;

import java.util.Scanner;

//import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import static java.lang.System.*;

public class FancyWord
{
	private char[][] mat;

	public FancyWord()
	{
		mat = new char[0][0];
	}

   public FancyWord(String s)
	{
	   mat = new char[s.length()][s.length()];
	   
	   for(int i=0;i<s.length();i++){
		   mat[0][i]=s.charAt(i);
		   mat[i][i]=s.charAt(i);
		   mat[s.length()-(i+1)][i]=s.charAt(i);		   
		   mat[s.length()-1][i]=s.charAt(i);
	   }
	}

	public String toString()
	{
		String output="";
		
		for(int i=0;i<mat.length;i++){
			for(int j=0;j<mat.length;j++){
				output = output+mat[i][j];
			}
			output = output + "\n";
		}
		
		
		
		
		return output+"\n\n";
	}
}