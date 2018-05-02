package unit10;

import static java.lang.System.*;

public class Lab16d
{
	public static void main( String args[] )
	{
		System.out.println(System.getProperty("user.dir"));
		//make a new MadLib
		String madLibFile = "src\\unit10\\madlib.dat";
		MadLib mad = new MadLib(madLibFile);
		
		mad.loadNouns();
		mad.loadVerbs();
		mad.loadAdjectives();
		
		out.println(mad);
		out.println("\n");
	}
}