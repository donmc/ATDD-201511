package com.tddair;

public enum Status {
	RED(0, 10000, 100), GREEN(25000, 9000, 90),  BLUE(50000, 8000, 75), GOLD(75000, 7000, 60);
	
	private int milesThreshold;
	private int upgradeCostMileage;
	private int upgradeCostDollars;

	private Status(int milesThreshold, int upgradeCostMileage, int upgradeCostDollars) {
		this.milesThreshold = milesThreshold;
		this.upgradeCostMileage = upgradeCostMileage;
		this.upgradeCostDollars = upgradeCostDollars;
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

	public int getUpgradeCostMileage() {
		return this.upgradeCostMileage;
	}

	public int getUpgradeCostDollars() {
		return this.upgradeCostDollars;
	}

}
