package unit12;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
import static java.lang.System.*;

public class Lab18d
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File("lab18d.dat"));

		int size = file.nextInt();
		file.nextLine();
		
		Word[] wordlist = new Word[size];
		
		for(int i=0;i<size;i++){
			wordlist[i] = new Word(file.nextLine());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		for(int j=0;j<size;j++){
			System.out.println(wordlist[j].toString()+"\n");
		}
		
	}
}