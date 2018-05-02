package unit10;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

//import sun.awt.SunHints.Value;

import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class Histogram
{
	private ArrayList<Integer> count;
	private ArrayList<Character> letters;
	private String fileName;

	public Histogram()
	{
		count = new ArrayList<Integer>();
		letters = new ArrayList<Character>();
		fileName = "";
	}

	public Histogram(char[] values, String fName)
	{
		count = new ArrayList<Integer>();
		letters = new ArrayList<Character>();
		
		for(int i=0;i<values.length;i++){
			letters.add(values[i]);
		}
		for(int i=0;i<values.length;i++){
			count.add(0);
		}
		fileName = fName;

		out.println("search letters = "+letters);
	}

	public void loadAndAnalyzeFile() throws IOException
	{
		ArrayList<String> temp = new ArrayList<String>();
		
		Scanner file = new Scanner(new File(fileName));
		while(file.hasNext()){
			temp.add(file.next().trim());
		}
		for(int i=0;i<temp.size();i++){
			for(int j=0;j<temp.get(i).length();j++){
				for(int k=0;k<letters.size();k++){
					if(temp.get(i).charAt(j)==(char)(letters.get(k))){
					count.set(k, count.get(k)+1);
				}
				}	
			}
		}
	}

	public char mostFrequent()
	{
		if((count.get(0)>count.get(1))&&(count.get(0)>count.get(2)))
			return (char)letters.get(0);
		
		if((count.get(1)>count.get(0))&&(count.get(1)>count.get(2)))
			return (char)letters.get(1);
		
		else
			return (char)letters.get(2);
	}

	public char leastFrequent()
	{
		if((count.get(0)<count.get(1))&&(count.get(0)<count.get(2)))
			return (char)letters.get(0);
	
		if((count.get(1)<count.get(0))&&(count.get(1)<count.get(2)))
			return (char)letters.get(1);
	
		else
			return (char)letters.get(2);
	}

	public String toString()
	{
	   return fileName
	   + "\n" + letters
	   + "\n" + count + "\n\n\n";
	}
}