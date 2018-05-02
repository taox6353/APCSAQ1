package unit1012labasses;

public class Flight
{
	private int flightnum;

	public Flight()
	{
		flightnum = 0;
	}
	public Flight(int num)
	{
		setFlightNum(num);
	}
	public void setFlightNum(int num){
		flightnum = num;
	}
	public double getFlightNum(){
		return flightnum;
	}
	public void setType(){
		String type = " ";
	}
	public String getType(){
		String type = "";
		if(flightnum > 500)
			type = "B-777";
		else
			type = "B-737";
		return type;
		
	}
	public String toString(){
		return getFlightNum()+"\n"+getType();		
	}
}