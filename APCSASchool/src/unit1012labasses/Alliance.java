package unit1012labasses;

public class Alliance {
	private String name;
	private AirlineCorp[] airlineCorpList;
	
	public Alliance()
	{
		name="";
		airlineCorpList=new AirlineCorp[0];
	}
	
	public Alliance(String name, int airlineCorpCount)
	{
		this.name = name;
		airlineCorpList=new AirlineCorp[airlineCorpCount];
	}
	
	public void addAirlineCorp(int acNum, AirlineCorp s)
	{
		airlineCorpList[acNum]=s;
	}
	
	public String getAllianceName()
	{
	   return name;	
	}
	
	public String mostCommonType()
	{
		String commonType= " ";
		
		int b777 = 0;
		int b737 = 0;
		
		for(int i=0;i<airlineCorpList.length;i++){
			if(airlineCorpList[i].getCommonType() == "B777")
				b777++;
			else if(airlineCorpList[i].getCommonType() == "B737")
				b737++;
		}
		
		if(b777 > b737)
			return "B777";
		else if(b737 > b777)
			return "B737";
		else
			return "Both the B737 and B777 are equally common. ";
	}
	
	public String getMostFlights()
	{
		int mostflights = 0;
		String busyAirline = "";
		for(int i=0;i<airlineCorpList.length;i++){
			if(airlineCorpList[i].getNumFlights() > mostflights){
				busyAirline = airlineCorpList[i].getCorp();
				mostflights = airlineCorpList[i].getNumFlights();
			}
		}
		
		return busyAirline;
	}
	public String getLeastFlights()
	{
		int leastflights = 10000;
		String lazyAirline = "";
		for(int i=0;i<airlineCorpList.length;i++){
			if(airlineCorpList[i].getNumFlights() < leastflights){
				lazyAirline = airlineCorpList[i].getCorp();
				leastflights = airlineCorpList[i].getNumFlights();
			}
		}
		
		return lazyAirline;
	}
	public String getAirlineCorpName(int corpNum)
	{
		return airlineCorpList[corpNum].getCorp();
	}
	public String notProfitable(int breakeven)
	{
		String output="";
		for(int i=0;i<airlineCorpList.length;i++){
			if(airlineCorpList[i].getNumFlights()<breakeven){
				output = output + airlineCorpList[i].getCorp()+ " ";
			}
		}

		return output;
	}
	public String toString()
	{
		String output=getAllianceName()+"\n";
		for(int i=0;i<airlineCorpList.length;i++){
			output = output + airlineCorpList[i].toString() + "\t"+ airlineCorpList[i].getNumFlights() +"\n";
		}

		return output;
	}  	
}
