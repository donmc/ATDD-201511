package com.tddair;

public class SpyCreditAuthorizationService implements CreditAuthorizationService {

	
	private int amountCharged;
	public static final String GOOD_CC = "111111111111111";
	public static final String BAD_CC = "999999999999999";

	/* (non-Javadoc)
	 * @see com.tddair.CreditAuthorizationService#authorize(int, java.lang.String)
	 */
	@Override
	public boolean authorize(int amount, String ccNum) {
		this.amountCharged = amount;
		
		return ccNum.equals(GOOD_CC);
	}
	
	public int getAmountCharged() {
		return amountCharged;
	}

}
