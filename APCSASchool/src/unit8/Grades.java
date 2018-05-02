package unit8;

import java.lang.*;
import java.util.*;

public class Grades
{
	//instance variables

	static int arraySize;
	static String passedGrds;
	static double[] grades;

	//constructor
	public Grades()
	{
		arraySize = 0;
		passedGrds = "";
	}
	//set method
	public void setGrades(int num, String grd)
	{
	  arraySize = num;
	  passedGrds = grd;
	  double[] grades = new double[arraySize];
	  passedGrds = passedGrds.trim();
	  
	  Scanner scan = new Scanner(grd);
	  int i=0;
	  while(scan.hasNextDouble()){
	    System.out.println(Arrays.toString(grades));
	    grades[i] = scan.nextDouble();
	    i++;
	  }
	  
	}
	private double getSum()
	{
		double sum=0.0;
		
		for(int i=0;i<grades.length;i++){
			sum = sum + grades[i];
		}

		return sum;
	}

	public double getAverage()
	{
		double average=0.0;
		average = getSum()/arraySize;
		
		return average;
	}
	public String toString()//toString method
	{
		String print = "";
		
		for(double i=0;i<arraySize;i++){
			print = print + "grade "+ (int)i +" :: "+ grades[(int)i-1]+"\n";
		}
		print = print + "\naverage = " + getAverage();
		
		return print;
	}


}