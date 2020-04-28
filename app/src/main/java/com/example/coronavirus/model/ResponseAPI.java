package com.example.coronavirus.model;

import com.google.gson.annotations.SerializedName;

public class ResponseAPI{

	@SerializedName("data")
	private Data data;

	@SerializedName("_cacheHit")
	private boolean cacheHit;

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}

	public void setCacheHit(boolean cacheHit){
		this.cacheHit = cacheHit;
	}

	public boolean isCacheHit(){
		return cacheHit;
	}

	@Override
 	public String toString(){
		return 
			"ResponseAPI{" + 
			"data = '" + data + '\'' + 
			",_cacheHit = '" + cacheHit + '\'' + 
			"}";
		}
}