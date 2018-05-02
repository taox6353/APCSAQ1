package unit13;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;
import static java.lang.System.*;

import java.io.File;

public class FancyWords
{
	private String[] wordRay;

	public FancyWords(String sentence)
	{
		setWords(sentence);
	}

	public void setWords(String sentence)
	{
		
		wordRay = sentence.split(" ");
		
	}

	public String toString()
	{
		String output="";
		int max = Integer.MIN_VALUE;
		
		Arrays.toString(wordRay);
		
		for(int i=wordRay.length-1;i>=0;i--){
			for(int j=wordRay[i].length()-1;j>=0;j--){
				output = output + wordRay[i].charAt(j);
			}
		}
		
		return output+"\n\n";
	}
}