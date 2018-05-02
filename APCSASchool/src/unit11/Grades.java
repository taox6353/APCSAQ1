package unit11;

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;

public class Grades
{
	private Grade[] gradeList;
	//constructors
	public Grades(){
		gradeList = new Grade[0];
	}
	public Grades(String grades){
		setGrades(grades);
	}

	public void setGrades(String values){
		Scanner scan = new Scanner(values);
		int numGrades = scan.nextInt();
		
		gradeList = new Grade[numGrades];
		
		for(int i=0;i<=numGrades;i++){
			Grade g = new Grade(scan.nextDouble());
			gradeList[i]=g;
		}
		
	}
	public void setGrade(int spot, double gr){
		
		Grade g = new Grade(gr);
		gradeList[spot]=g;
		
	}
	public double getSum(){
		//for(int i=0;i<gradeList.length;i++){
			//sum = 
		//}
		
		return 0.0;
	}
	public double getLowGrade(){
		return 0;
	}
	public double getHighGrade(){
		return 0;
	}
	public int getNumGrades(){
		return gradeList.length;
	}
	//toString method
	public String toString(){
		String output = "";
	
		return output;
	}




}