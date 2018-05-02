package unit1012labasses;

import java.util.*;

public class AirlineCorp
{
	private String myCorp;
	private Airline myAirlines;
	
	public AirlineCorp(){
		setName("");
		setAirlines("");
	}
	public AirlineCorp(String name,String flightinfo){
		setName(name);
		setAirlines(flightinfo);
	}
	public void setName(String name){
		myCorp = name;
	}
	public void setAirlines(String flightinfo){
		myAirlines = new Airline(flightinfo);
	}
	public void setFlight(int location, int flight){
		myAirlines.setFlight(location,flight);
	}
	public String getCorp()
	{
		return myCorp;
	}
	public int getNumFlights(){
		
		return myAirlines.getNumFlights();
	}
	public String getCommonType(){
		
		return myAirlines.commonType();
	}
	public String toString(){
		String output = myCorp + " = " + myAirlines.toString();
		
		return output;
	}
}