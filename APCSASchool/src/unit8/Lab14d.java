package unit8;

public class Lab14d
{
	public static void main( String args[] )
	{
		Grades gd = new Grades();
		
		//add test cases
		int cnt = 5;
		String grad = "100 90 85 72.5 95.6";
		gd.setGrades(cnt, grad);
		System.out.println(gd);
		
		
	}
}