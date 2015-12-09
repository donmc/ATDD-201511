package com.tddair;

import java.util.HashMap;
import java.util.Map;

public class TddAirApplication {
	
	private Map<String, Member> members = new HashMap<String, Member>();

	public void registerMember(String userName) {
		Member member = new Member(userName);
		members.put(userName, member);
		
	}

	public Member lookupMember(String userName) {
		if(!members.containsKey(userName)) throw new IllegalArgumentException();
		
		return members.get(userName);
	}

}
