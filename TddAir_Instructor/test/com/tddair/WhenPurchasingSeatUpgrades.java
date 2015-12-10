package com.tddair;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class WhenPurchasingSeatUpgrades {

	@Test
	public void shouldPurchaseASeatUpgradeWithMiles() {
		int quantity = 1;
		Member member = new Member("don");
		
		member.purchaseSeatUpgradesWithMiles(quantity);

		assertEquals(quantity, member.getSeatUpgrades());
		assertEquals(0, member.getBalanceMiles()); 
	}
	
	@Test
	public void shouldPurchaseASeatUpgradeWithMiles_Green() {
		int quantity = 1;
		Member member = new Member("don");
		member.registerFlownMiles(25000);
		
		member.purchaseSeatUpgradesWithMiles(quantity);

		assertEquals(35000-9000, member.getBalanceMiles()); 
	}
	
	
	@Test
	public void shouldPurchase2SeatUpgradeWithMiles() {
		int quantity = 2;
		Member member = new Member("don");
		member.registerFlownMiles(15000);
		
		member.purchaseSeatUpgradesWithMiles(quantity);

		assertEquals(quantity, member.getSeatUpgrades());
		assertEquals(5000, member.getBalanceMiles()); 
	}
	
	@Test
	public void shouldPurchaseASeatUpgradeWithCreditCard() {
		int quantity = 1;
		Member member = new Member("don");
		SpyCreditAuthorizationService cas = new SpyCreditAuthorizationService();
		member.setCas(cas);
		
		String goodCC = SpyCreditAuthorizationService.GOOD_CC;
		member.purchaseSeatUpgradesWithCreditCard(quantity, goodCC);

		assertEquals(quantity, member.getSeatUpgrades());
		assertEquals(100, cas.getAmountCharged());
	}
	
	@Test
	public void shouldPurchase3SeatUpgradeWithCreditCard() {
		int quantity = 3;
		Member member = new Member("don");
		SpyCreditAuthorizationService cas = new SpyCreditAuthorizationService();
		member.setCas(cas);
		
		String goodCC = SpyCreditAuthorizationService.GOOD_CC;
		member.purchaseSeatUpgradesWithCreditCard(quantity, goodCC);

		assertEquals(quantity, member.getSeatUpgrades());
		assertEquals(300, cas.getAmountCharged());
	}
	
	@Test
	public void shouldNotPurchaseASeatUpgradeWithInvalidCreditCard() {
		int quantity = 1;
		Member member = new Member("don");
		SpyCreditAuthorizationService cas = new SpyCreditAuthorizationService();
		member.setCas(cas);
		
		String badCC = SpyCreditAuthorizationService.BAD_CC;
		member.purchaseSeatUpgradesWithCreditCard(quantity, badCC);

		assertEquals(0, member.getSeatUpgrades());
	}
	

}
