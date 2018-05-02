package unit7;

import static java.lang.System.*;

public class TriangleThree
{
   private int size;
   private String letter;

	public TriangleThree()
	{
		size = 0;
		letter = "";
	}

	public TriangleThree(int count, String let)
	{
		size = count;
		letter = let;
	}

	public void setTriangle( String let, int sz )
	{
		size = sz;
		letter = let;
		getLetter();
	}

	public String getLetter()
	{
		return toString();
	}

	public String toString()
	{
		String output="";
		for (int i=size;i==0;i--){
				for (int k=size;k>=0;k--){
					output = output + " ";
					k++;
				}
				for (int l=0;l<=size;l++){
					output = output + letter;
					l++;
				}
			System.out.println();
				
			}
		
		System.out.println(output);
		return output+"\n";
	}
}