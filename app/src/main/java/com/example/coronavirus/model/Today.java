package com.example.coronavirus.model;

import com.google.gson.annotations.SerializedName;

public class Today{

	@SerializedName("confirmed")
	private int confirmed;

	@SerializedName("deaths")
	private int deaths;

	public void setConfirmed(int confirmed){
		this.confirmed = confirmed;
	}

	public int getConfirmed(){
		return confirmed;
	}

	public void setDeaths(int deaths){
		this.deaths = deaths;
	}

	public int getDeaths(){
		return deaths;
	}

	@Override
 	public String toString(){
		return 
			"Today{" + 
			"confirmed = '" + confirmed + '\'' + 
			",deaths = '" + deaths + '\'' + 
			"}";
		}
}