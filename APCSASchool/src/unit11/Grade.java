package unit11;

public class Grade
{
	private static double value;
	//add in two constructors
	public Grade()
	{
		value = 0;
	}
	public Grade(double grade)
	{
		setLetter(grade);
	}
	//add in set and get methods
	public static void setLetter(double grade){
		value = grade;
	}
	public static double getLetter(){
		return value;
	}
	
	//String getLetterGrade()
	public static String getLetterGrade(){
		String LetterGrade = "";
		if(value>=90.0)
			LetterGrade = "A";
		else if(value>=80.0&&value<=89.99)
			LetterGrade = "B";
		else if(value>=70.0&&value<=79.99)
			LetterGrade = "C";
		else if(value>=60.0&&value<=69.99)
			LetterGrade = "D";
		else
			LetterGrade = "F";
		return LetterGrade;
		
	}
	//double getNumericGrade()
	public double getNumericGrade(){
		return value;
	}
	//toString method
	public String toString(){
		String string = getNumericGrade()+"\n"+getLetterGrade();
		
		return string;
		
		
	}
}