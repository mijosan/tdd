package com.example.demo.chap02;

public class PasswordStrengthMeter {

	public PasswordStrength meter(String s) {
		if(s == null || s.isEmpty()) return PasswordStrength.INVALID;
			
		if(s.length() < 8) {
			return PasswordStrength.NORMAL;
		}
		
		boolean containsNum = meetsContainingNumberCriteria(s);
		
		if(!containsNum) return PasswordStrength.NORMAL;
		
		return PasswordStrength.STRONG;
	}
	
	/*
	 * 메서드를 이용해 깔끔하게 리팩토링
	 */
	private boolean meetsContainingNumberCriteria(String s) {
		for(char ch : s.toCharArray()) {
			if(ch >= '0' && ch <= '9') {
				return true;
			}
		}
		return false;
	}
	
}
