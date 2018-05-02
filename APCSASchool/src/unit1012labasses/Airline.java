package unit1012labasses;

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;

public class Airline {
	
		private Flight[] flightList;

		public Airline(){
			flightList = new Flight[0];
		}
		public Airline(String flightInfo){
			setFlightInfo(flightInfo);
		}

		public void setFlightInfo(String flightInfo){
			Scanner scan = new Scanner(flightInfo);
			int flights = scan.nextInt();
			
			flightList = new Flight[flights];
			
			scan.next();
			
			for(int i=0;i<flights;i++){
				flightList[i]=new Flight(Integer.parseInt(scan.next()));
			}
			
		}
		public void setFlight(int location, int flightNum){
			
			Flight f = new Flight(flightNum);
			flightList[location]=f;
			
		}
		public String commonType(){
			int b777 = 0;
			int b737 = 0;
			for(int i=0;i<flightList.length;i++){
				if(flightList[i].getType() == "B777")
					b777++;
				else
					b737++;
			}
			
			if(b777>b737)
				return "B777";
			else if(b777<b737)
				return "B737";
			else
				return "Equally common.";

		}
		
		public int getNumFlights(){
			return flightList.length;
		}
		public String toString(){
			String output = "";
			
			for(int i=0;i<flightList.length;i++){
				output = output + flightList[i].getFlightNum() + " ";
			}
			return output;
		}

	}