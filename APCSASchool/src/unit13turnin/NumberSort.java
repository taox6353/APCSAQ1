package unit13turnin;

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberSort
{
	//instance variables and other methods not shown

	private static int getNumDigits(int number)
	{
		int count = 0;
		
		while(number>0){
			number = number/10;
			count++;
		}
		return count;
	}
	
	public static int[] getSortedDigitArray(int number)
	{
		
		int numDigits = getNumDigits(number);
		int[] sorted = new int[numDigits];
		
		for(int i=0;i<numDigits;i++){
			sorted[i] = number%10;
			number = number/10;
		}
		
		for(int i=0;i<numDigits;i++){
			for(int j=0;j<numDigits-1;j++){
				if(sorted[j]>sorted[j+1]){
					int temp = sorted[j];
					sorted[j]=sorted[j+1];
					sorted[j+1]=temp;
				}
			}
		}

		return sorted;
	}
}