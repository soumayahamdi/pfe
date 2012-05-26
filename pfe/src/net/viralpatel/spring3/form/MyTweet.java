package net.viralpatel.spring3.form;

public class MyTweet {

	private String userName;
	private String  text ;
	private double longitude ;
	private double altitude;
	
	
public MyTweet(){
		
	} 
	
public MyTweet(String userName,String text,double longitude,double altitude ) {
    this.userName = userName;
    this.text = text;
    this.longitude = longitude;
    this.altitude = altitude;
    
}
	
	
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getAltitude() {
		return altitude;
	}
	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}
	
	
	
	
}
