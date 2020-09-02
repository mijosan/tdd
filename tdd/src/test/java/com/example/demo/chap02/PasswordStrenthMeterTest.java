package com.example.demo.chap02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PasswordStrenthMeterTest {

	private PasswordStrengthMeter meter = new PasswordStrengthMeter();
	
	private void assertStrength(String password, PasswordStrength expStr) {
		PasswordStrength result = meter.meter(password);
		assertEquals(expStr, result);
	}
	
	/*
	 * 이렇게 메서드를 이용해 깔끔하게 리팩토링 할수도 있다.
	 */
	@Test
	void meetsAllCriteria_Then_String() {
		assertStrength("ab12!@AB", PasswordStrength.STRONG);
		assertStrength("abc1!Add", PasswordStrength.STRONG);
	}
	
	@Test
	void nullInput_Then_Invalid() {
		assertStrength(null, PasswordStrength.INVALID);
	}
	
	@Test
	void emptyinput_Then_Invalid() {
		assertStrength("", PasswordStrength.INVALID);
	}
	
	@Test
	void meetsOtherCriteria_except_for_Uppercase_Then_Normal() {
		assertStrength("ab12!@df", PasswordStrength.NORMAL);
	}
	
	@Test
	void meetsOnlyLengthCriteria_Then_Weak() {
		assertStrength("abdefghi", PasswordStrength.WEAK);
	}
	
	@Test
	void meetsOnlyNumCriteria_Then_Weak() {
		assertStrength("12345", PasswordStrength.WEAK);
	}
	
	@Test
	void meetsOnlyUpperCriteria_Then_Weak() {
		assertStrength("ABZEF", PasswordStrength.WEAK);
	}
	
	@Test
	void meetsNoCriteria_Then_Weak() {
		assertStrength("abc", PasswordStrength.WEAK);
	}
	
	@Test
	void meetsOtherCriteria_except_for_Length_Then_Normal() {
		PasswordStrength result = meter.meter("ab12!@A");
		assertEquals(PasswordStrength.NORMAL, result);
		
		PasswordStrength result2 = meter.meter("Ab12!c");
		assertEquals(PasswordStrength.NORMAL, result2);
	}
	
	@Test
	void meetsOtherCriteria_except_for_Number_Then_Normal() {
		PasswordStrength result = meter.meter("ab!@ABqwer");
		assertEquals(PasswordStrength.NORMAL, result);
	}

}
