package com.nicholaslocicero.focus;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigInteger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FibonacciTest {
	
	private static final int[] VALUES = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155};

	@Test
	void testLimit() {
		int limit = 100;
		int count = 0;
		for (BigInteger b : new Fibonacci(limit)) {
			count++;
		}
		assertEquals(limit, count, String.format("Expected %d terms, got %d.", limit, count));
	}
	
	@Test
	void testValues() {
		int limit = VALUES.length;
		int[] values = new int[limit];
		int count = 0;
		for (BigInteger b : new Fibonacci(limit)) {
			values[count] = b.intValue();
			count++;
		}
		assertArrayEquals(VALUES, values);
	}
	
	@Test
	void testUnlimited() {
		boolean passed = false;
		for (BigInteger b : new Fibonacci()) {
			if (b.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) > 0) {
				passed = true;
				break;
			}
		}
		if (!passed) {
			fail("Sequence ended prematurely.");
		}
	}

}
