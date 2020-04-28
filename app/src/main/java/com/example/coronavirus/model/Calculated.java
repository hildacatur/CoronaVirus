package com.example.coronavirus.model;

import com.google.gson.annotations.SerializedName;


public class Calculated{

	@SerializedName("recovery_rate")
	private double recoveryRate;

	@SerializedName("cases_per_million_population")
	private int casesPerMillionPopulation;

	@SerializedName("death_rate")
	private double deathRate;

	@SerializedName("recovered_vs_death_ratio")
	private Object recoveredVsDeathRatio;

	public void setRecoveryRate(double recoveryRate){
		this.recoveryRate = recoveryRate;
	}

	public double getRecoveryRate(){
		return recoveryRate;
	}

	public void setCasesPerMillionPopulation(int casesPerMillionPopulation){
		this.casesPerMillionPopulation = casesPerMillionPopulation;
	}

	public int getCasesPerMillionPopulation(){
		return casesPerMillionPopulation;
	}

	public void setDeathRate(double deathRate){
		this.deathRate = deathRate;
	}

	public double getDeathRate(){
		return deathRate;
	}

	public void setRecoveredVsDeathRatio(Object recoveredVsDeathRatio){
		this.recoveredVsDeathRatio = recoveredVsDeathRatio;
	}

	public Object getRecoveredVsDeathRatio(){
		return recoveredVsDeathRatio;
	}

	@Override
 	public String toString(){
		return 
			"Calculated{" + 
			"recovery_rate = '" + recoveryRate + '\'' + 
			",cases_per_million_population = '" + casesPerMillionPopulation + '\'' + 
			",death_rate = '" + deathRate + '\'' + 
			",recovered_vs_death_ratio = '" + recoveredVsDeathRatio + '\'' + 
			"}";
		}
}