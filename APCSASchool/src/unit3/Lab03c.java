package unit3;

import java.util.Scanner;
import static java.lang.System.*;
import static java.lang.Math.*;

public class Lab03c
{
	public static void main( String[] args )
 {
		Quadratic quad = new Quadratic(); 
		
		quad.setEquation(1,-2,1);
		quad.calcRoots(); 
		quad.print();
	}
}