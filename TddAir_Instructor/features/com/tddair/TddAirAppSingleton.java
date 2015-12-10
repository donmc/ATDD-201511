package com.tddair;

public class TddAirAppSingleton {
	
	private static TddAirApplication instance = new TddAirApplication();
	
	public static TddAirApplication getInstance() {
		return instance;
	}

	public static TddAirApplication newInstance() {
		instance = new TddAirApplication();
		return instance;
	}

}
