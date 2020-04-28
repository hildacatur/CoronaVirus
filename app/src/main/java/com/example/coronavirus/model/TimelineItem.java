package com.example.coronavirus.model;

import com.google.gson.annotations.SerializedName;

public class TimelineItem{

	@SerializedName("date")
	private String date;

	@SerializedName("new_recovered")
	private int newRecovered;

	@SerializedName("recovered")
	private int recovered;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("new_confirmed")
	private int newConfirmed;

	@SerializedName("new_deaths")
	private int newDeaths;

	@SerializedName("active")
	private int active;

	@SerializedName("confirmed")
	private int confirmed;

	@SerializedName("deaths")
	private int deaths;

	@SerializedName("is_in_progress")
	private boolean isInProgress;

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	public void setNewRecovered(int newRecovered){
		this.newRecovered = newRecovered;
	}

	public int getNewRecovered(){
		return newRecovered;
	}

	public void setRecovered(int recovered){
		this.recovered = recovered;
	}

	public int getRecovered(){
		return recovered;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setNewConfirmed(int newConfirmed){
		this.newConfirmed = newConfirmed;
	}

	public int getNewConfirmed(){
		return newConfirmed;
	}

	public void setNewDeaths(int newDeaths){
		this.newDeaths = newDeaths;
	}

	public int getNewDeaths(){
		return newDeaths;
	}

	public void setActive(int active){
		this.active = active;
	}

	public int getActive(){
		return active;
	}

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

	public void setIsInProgress(boolean isInProgress){
		this.isInProgress = isInProgress;
	}

	public boolean isIsInProgress(){
		return isInProgress;
	}

	@Override
 	public String toString(){
		return 
			"TimelineItem{" + 
			"date = '" + date + '\'' + 
			",new_recovered = '" + newRecovered + '\'' + 
			",recovered = '" + recovered + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",new_confirmed = '" + newConfirmed + '\'' + 
			",new_deaths = '" + newDeaths + '\'' + 
			",active = '" + active + '\'' + 
			",confirmed = '" + confirmed + '\'' + 
			",deaths = '" + deaths + '\'' + 
			",is_in_progress = '" + isInProgress + '\'' + 
			"}";
		}
}