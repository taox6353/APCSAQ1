package unit12;

import static java.lang.System.*;

public class Word implements Comparable<Word>
{
	private String word;

	public Word( String s )
	{
		word = s;
	}

	public int compareTo( Word rhs )
	{
		if(word.length()>rhs.toString().length())
			return 1;
		
		else if(word.length()==rhs.toString().length()){
			if(word.charAt(0)>rhs.toString().charAt(0))
				return 1;
			else if(word.charAt(0)==rhs.toString().charAt(0)){
				if(word.charAt(1)>rhs.toString().charAt(1))
					return 1;
				if(word.charAt(1)==rhs.toString().charAt(1))
					return 0;
				else
					return -1;
			}
			return -1;
		}
		return -1;
	}

	public String toString()
	{
		return word;
	}
}