package com.example.coronavirus.model;

import com.google.gson.annotations.SerializedName;

public class Coordinates{

	@SerializedName("latitude")
	private int latitude;

	@SerializedName("longitude")
	private int longitude;

	public void setLatitude(int latitude){
		this.latitude = latitude;
	}

	public int getLatitude(){
		return latitude;
	}

	public void setLongitude(int longitude){
		this.longitude = longitude;
	}

	public int getLongitude(){
		return longitude;
	}

	@Override
 	public String toString(){
		return 
			"Coordinates{" + 
			"latitude = '" + latitude + '\'' + 
			",longitude = '" + longitude + '\'' + 
			"}";
		}
}