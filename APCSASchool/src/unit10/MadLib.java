package unit10;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;
import java.lang.Math;
import java.util.Random;

public class MadLib
{
	private ArrayList<String> verbs;
	private ArrayList<String> nouns;
	private ArrayList<String> adjectives;
	private String madlib;
	
	public MadLib()
	{
		verbs = new ArrayList<String>();
		nouns = new ArrayList<String>();
		adjectives = new ArrayList<String>();
	}

	public MadLib(String fileName)
	{
		//load stuff
		
		try{
			Scanner file = new Scanner(new File(fileName));

	
		
		}
		catch(Exception e)
		{
			out.println("Houston we have a problem!");
		}
		
	}

	public void loadNouns()
	{
		try{
			nouns = new ArrayList<String>();
			
		Scanner file = new Scanner(new File("src\\unit10\\nouns.dat"));
		while(file.hasNextLine()){
			nouns.add(file.nextLine().trim());
			}
		
		
		}
		catch(Exception e)
		{
			out.println("Houston we have a problem!");

		}	
		
	}
	
	public void loadVerbs()
	{
		try{
			verbs = new ArrayList<String>();
			Scanner file = new Scanner(new File("src\\unit10\\verbs.dat"));
			while(file.hasNextLine()){
				   verbs.add(file.nextLine().trim());
				}

	
		}
		catch(Exception e)
		{
			out.println("Houston we have a problem!");

		}
	}

	public void loadAdjectives()
	{
		try{
			adjectives = new ArrayList<String>();
			Scanner file = new Scanner(new File("src\\unit10\\adjectives.dat"));
			while(file.hasNextLine()){
				   adjectives.add(file.nextLine().trim());
			}
	
		}
		catch(Exception e)
		{
			out.println("Houston we have a problem!");

		}
	}

	public String getRandomVerb()
	{
		Random rng = new Random();
		return verbs.get(rng.nextInt(verbs.size()));
	}
	
	public String getRandomNoun()
	{
		Random rng = new Random();
		return nouns.get(rng.nextInt(nouns.size()));
	}
	
	public String getRandomAdjective()
	{
		Random rng = new Random();
		return adjectives.get(rng.nextInt(adjectives.size()));
	}		

	public String toString()
	{
		try{
			Scanner scan = new Scanner(new File("src\\unit10\\story.dat"));
			madlib = scan.nextLine();
			}
		catch(Exception e)
		{
			out.println("Houston we have a problem!");
		}
		
		for(int i=0; i<madlib.length() ;i++ ){
			if(madlib.charAt(i)=='#')
				madlib = madlib.substring(0, i)+getRandomNoun()+madlib.substring(i);
			if(madlib.charAt(i)=='@')
				madlib = madlib.substring(0, i)+getRandomVerb()+madlib.substring(i);
			if(madlib.charAt(i)=='&')
				madlib = madlib.substring(0, i)+getRandomAdjective()+madlib.substring(i);
		}
		
		
		
	   return "\nThe "+getRandomNoun()+" "+ getRandomNoun()+" after the "+getRandomAdjective()+" "+getRandomAdjective()+" "+ getRandomNoun()+ " while the "+getRandomNoun()+" "+getRandomVerb()+" the "+getRandomNoun();
	}
}