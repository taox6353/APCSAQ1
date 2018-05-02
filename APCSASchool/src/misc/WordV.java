package misc;

import static java.lang.System.*;

public class WordV implements Comparable<WordV>
{
	private String word;

	public WordV( String s)
	{
		word = s;
	}

	private int numVowels()
	{
		String vowels = "AEIOUaeiou";
		int vowelCount=0;
		
		for(int i=0;i<word.length();i++){
			for(int j=0;j<vowels.length();j++){
				if(word.charAt(i)==vowels.charAt(j))
					vowelCount++;
			}
		}
		return vowelCount;
	}

	public int compareTo(WordV rhs)
	{
		if(this.numVowels()>rhs.numVowels())
			return 1;
		else if(this.numVowels()==rhs.numVowels()){
			if((int)word.charAt(0) > (int)rhs.toString().charAt(0))
				return 1;
			else if((int)word.charAt(0) == (int)rhs.toString().charAt(0)){
				if((int)word.charAt(1) > (int)rhs.toString().charAt(1))
					return 1;
				if((int)word.charAt(1) == (int)rhs.toString().charAt(1))
					return 0;
				else
					return -1;
			}
			else
				return -1;
		}
		return -1;
	}

	public String toString()
	{
		return word;
	}
}