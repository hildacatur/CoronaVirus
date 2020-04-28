package com.example.coronavirus.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("latest_data")
	private LatestData latestData;

	@SerializedName("code")
	private String code;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("today")
	private Today today;

	@SerializedName("coordinates")
	private Coordinates coordinates;

	@SerializedName("name")
	private String name;

	@SerializedName("timeline")
	private List<TimelineItem> timeline;

	@SerializedName("population")
	private int population;

	public void setLatestData(LatestData latestData){
		this.latestData = latestData;
	}

	public LatestData getLatestData(){
		return latestData;
	}

	public void setCode(String code){
		this.code = code;
	}

	public String getCode(){
		return code;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setToday(Today today){
		this.today = today;
	}

	public Today getToday(){
		return today;
	}

	public void setCoordinates(Coordinates coordinates){
		this.coordinates = coordinates;
	}

	public Coordinates getCoordinates(){
		return coordinates;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setTimeline(List<TimelineItem> timeline){
		this.timeline = timeline;
	}

	public List<TimelineItem> getTimeline(){
		return timeline;
	}

	public void setPopulation(int population){
		this.population = population;
	}

	public int getPopulation(){
		return population;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"latest_data = '" + latestData + '\'' + 
			",code = '" + code + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",today = '" + today + '\'' + 
			",coordinates = '" + coordinates + '\'' + 
			",name = '" + name + '\'' + 
			",timeline = '" + timeline + '\'' + 
			",population = '" + population + '\'' + 
			"}";
		}
}