package com.tddair;

public interface CreditAuthorizationService {

	public abstract boolean authorize(int amount, String ccNum);

}