package unit13turnin;

import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

class InsertionSort
{
	private ArrayList<String> list;

	public InsertionSort()
	{
		list = new ArrayList<String>();
	}

	//modfiers
	public void add(String  word)
	{
		int loc = 0;
		char compare = word.charAt(0);
		
		if(list.size()==0)
			list.add(word);
		
		else if(list.size()>=2&&compare > list.get(0).charAt(0)&&compare < list.get(1).charAt(0)){
			String temp = list.get(1);
			list.set(1,word);
			list.add(temp);
		}
		else if(list.size()>=1&&compare<list.get(0).charAt(0)){
			list.add(0,word);
		}
		else
			list.add(word);
	}


	public void remove(String word)
	{
		for(int i=0;i<list.size();i++){
			if(word.charAt(0)==list.get(i).charAt(0)){
				list.remove(i);
			}
		}
	}

	public String toString()
	{
		String output = " ";
		for(int i=0;i<list.size();i++){
			output = output + list.get(i) + " ";
		}
		return output;
	}
}