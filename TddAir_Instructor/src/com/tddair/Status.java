package com.tddair;

public enum Status {
	RED(0), GREEN(25000),  BLUE(50000), GOLD(75000);
	
	private int milesThreshold;

	private Status(int milesThreshold) {
		this.milesThreshold = milesThreshold;
	}

	public static Status calculateStatusFor(int ytdMiles) {
		Status chosenStatus = Status.RED;
		for (Status status : Status.values()) {
			if (ytdMiles >= status.getMilesThreshold()) {
				chosenStatus = status;
			}
		}
		
		return chosenStatus;
	}
	
	public int getMilesThreshold() {
		return milesThreshold;
	}

}
