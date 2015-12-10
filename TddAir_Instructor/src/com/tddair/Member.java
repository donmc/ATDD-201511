package com.tddair;

public class Member {
	private static final int BONUS_MILES = 10000;
	private String userName;
	private Status status;
	private int ytdMiles;
	private int balanceMiles;
	private int seatUpgrades;
	private CreditAuthorizationService cas;
	
	public Member(String userName) { 
		this.userName = userName;
		this.status = Status.RED;
		this.ytdMiles = 0;
		this.balanceMiles = BONUS_MILES;
	}

	public String getUserName() {
		return userName;
	}

	public Status getStatus() {
		return status;
	}
	
	public int getBalanceMiles() {
		return balanceMiles;
	}
	
	public int getYtdMiles() {
		return ytdMiles;
	}

	public void registerFlownMiles(int milesFlown) {
		ytdMiles += milesFlown;
		balanceMiles += milesFlown;
		status = Status.calculateStatusFor(ytdMiles);
	
		
	}

	public void purchaseSeatUpgradesWithMiles(int quantity) {
		seatUpgrades += quantity;
		balanceMiles -= status.getUpgradeCostMileage() * quantity;
	}

	public int getSeatUpgrades() {
		return this.seatUpgrades;
	}

	public void setCas(CreditAuthorizationService cas) {
		this.cas = cas;
	}

	public void purchaseSeatUpgradesWithCreditCard(int quantity, String ccNum) {
		int amount = status.getUpgradeCostDollars() * quantity;
		boolean isValid = cas.authorize(amount, ccNum);
		if (isValid)
			seatUpgrades += quantity;
	}
	
}
