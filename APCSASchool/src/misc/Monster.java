package misc;

import static java.lang.System.*;

public class Monster implements Comparable
{
	private int myWeight;
	private int myHeight;
	private int myAge;

	//write a default Constructor
public Monster()
{
	myWeight=0;
	myHeight=0;
	myAge=0;
}
	//write an initialization constructor with an int parameter ht
public Monster(int ht)
{
	setMyHeight(ht);
}
	//write an initialization constructor with int parameters ht and wt
public Monster(int ht,int wt)
{
	setMyHeight(ht);
	setMyWeight(wt);
}
	//write an initialization constructor with int parameters ht, wt, and age
public Monster(int ht, int wt, int age)
{
	setMyHeight(ht);
	setMyWeight(wt);
	setMyAge(age);
}
	//modifiers - write set methods for height, weight, and age
	//accessors - write get methods for height, weight, and age
public int getMyWeight() 
{
	return myWeight;
}
public void setMyWeight(int myWeight) 
{
	this.myWeight = myWeight;
}
public int getMyHeight() 
{
	return myHeight;
}
public void setMyHeight(int myHeight) 
{
	this.myHeight = myHeight;
}
public int getMyAge() 
{
	return myAge;
}
public void setMyAge(int myAge) 
{
	this.myAge = myAge;
}
	//creates a new copy of this Object
public Object clone()	
{
	return new Monster(getMyHeight(),getMyWeight(),getMyAge());
}

public boolean equals( Object obj )
{
	Monster monster2 = (Monster)obj;
	if(this.myHeight==monster2.getMyHeight()&&this.myWeight==monster2.getMyWeight()&&this.myAge==monster2.getMyAge())
		return true;
	else	
		return false;
}

public int compareTo( Object obj )
{
	Monster rhs = (Monster)obj;
	if(this.myHeight>rhs.getMyHeight())
		return 1;
	else if(this.myHeight==rhs.getMyHeight()){
		if(this.myWeight>rhs.getMyWeight())
			return 1;
		else if(this.myWeight==rhs.getMyWeight()){
			if(this.myAge>rhs.getMyAge())
				return 1;
			else if(this.myAge==rhs.getMyAge())
				return 0;
			return -1;
		}
		return -1;
	}
	return -1;
}

	//write a toString() method
public String toString()
{
	return ""+getMyHeight()+" "+getMyWeight()+" "+getMyAge();
}
	
}