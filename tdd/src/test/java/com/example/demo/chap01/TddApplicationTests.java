package com.example.demo.chap01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TddApplicationTests {

	@Test
	void substring() {
		String str = "abcde";
		assertEquals("cd", str.substring(2, 4));
	}

}
