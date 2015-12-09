package com.tddair;

public class Member {
	private static final int BONUS_MILES = 10000;
	private String userName;
	private Status status;
	private int ytdMiles;
	private int balanceMiles;
	
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
	
}
