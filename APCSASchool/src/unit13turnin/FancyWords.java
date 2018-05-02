package unit13turnin;

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
		for(int m=0;m<wordRay.length;m++){
			if(wordRay[m].length()>max)
				max = wordRay[m].length();
		}
		for(int j=0;j<max;j++){
			for(int i=wordRay.length-1;i>=0;i--){
				if(1+j>wordRay[i].length())
					output = output + " ";
				else
					output = output + wordRay[i].charAt(wordRay[i].length()-(1+j));
			}
			output = output + "\n";
		}
		return output+"\n\n";
	}
}