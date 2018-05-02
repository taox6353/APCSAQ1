package unit1012labasses;

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;

public class AllianceTester
{
   public static void main( String args[] )
   {
		Alliance test = new Alliance("Star Alliance",3);
		test.addAirlineCorp(0,new AirlineCorp("American Airlines","4 - 121 501 1200 1201"));
		test.addAirlineCorp(1,new AirlineCorp("United Airlines","5 - 400 1001 1200 1201 9000"));
		test.addAirlineCorp(2,new AirlineCorp("Delta Air Lines","2 - 9000 8201"));
		out.println(test);
		
		out.println(test.getLeastFlights()+" has the least number of flights. ");
		out.println(test.getMostFlights()+ " has the greatest number of flights. ");
		
		out.println("Losing Money = " + test.notProfitable(3));	
	}		
}