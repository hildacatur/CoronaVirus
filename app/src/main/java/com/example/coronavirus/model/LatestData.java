package com.example.coronavirus.model;

import com.google.gson.annotations.SerializedName;

public class LatestData{

	@SerializedName("recovered")
	private int recovered;

	@SerializedName("critical")
	private int critical;

	@SerializedName("confirmed")
	private int confirmed;

	@SerializedName("calculated")
	private Calculated calculated;

	@SerializedName("deaths")
	private int deaths;

	public void setRecovered(int recovered){
		this.recovered = recovered;
	}

	public int getRecovered(){
		return recovered;
	}

	public void setCritical(int critical){
		this.critical = critical;
	}

	public int getCritical(){
		return critical;
	}

	public void setConfirmed(int confirmed){
		this.confirmed = confirmed;
	}

	public int getConfirmed(){
		return confirmed;
	}

	public void setCalculated(Calculated calculated){
		this.calculated = calculated;
	}

	public Calculated getCalculated(){
		return calculated;
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
			"LatestData{" + 
			"recovered = '" + recovered + '\'' + 
			",critical = '" + critical + '\'' + 
			",confirmed = '" + confirmed + '\'' + 
			",calculated = '" + calculated + '\'' + 
			",deaths = '" + deaths + '\'' + 
			"}";
		}
}