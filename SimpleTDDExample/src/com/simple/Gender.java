package com.simple;

public enum Gender {
	MALE("Mr."), FEMALE("Ms."), UNKNOWN("Mr. or Ms.");

	private String salutation;
	
	private Gender(String salutation) {
		this.salutation = salutation;
	}
	
	public String getSalutation() {
		return salutation;
	}

}
