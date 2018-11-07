// Assignment: A03_AUTOCOMPLETE
// program:    BinarySearchTest
// Created:    Oct 11, 2017
// Author:     Seth & Tenzin
package test;

import static org.junit.Assert.*;
import org.junit.Test;
import a03.BinarySearchDeluxe;

public class BinarySearchTest {
	
	@Test
	public void test() {
		
	}
	
	@Test
	public void testUniqueWithGetFirst() {
		Integer[] list = new Integer[]{0,1,2,3,4,5,6,7,8};
		for (int i = 0; i < 9; i++) { assertTrue(i == BinarySearchDeluxe.<Integer>firstIndexOf(list, i, Integer::compareTo));	}
	
	}
	
	@Test
	public void testUniqueWithGetLast() {
		Integer[] list = new Integer[]{0,1,2,3,4,5,6,7,8};
		for (int i = 0; i < 9; i++) { assertTrue(i == BinarySearchDeluxe.<Integer>lastIndexOf(list, i, Integer::compareTo));	}
	}
	
	@Test
	public void testFullWithGetFirst() {
		Integer[] list = new Integer[]{0,0,0,0,0,0,8,9};
		assertTrue(0 == BinarySearchDeluxe.<Integer>firstIndexOf(list, 0, Integer::compareTo));	
		
		list = new Integer[]{0,4,4,4,4,7,8,9};
		assertTrue(1 == BinarySearchDeluxe.<Integer>firstIndexOf(list, 4, Integer::compareTo));	
		
		list = new Integer[]{0,4,4,4,4,7,8};
		assertTrue(1 == BinarySearchDeluxe.<Integer>firstIndexOf(list, 4, Integer::compareTo));	
		
		list = new Integer[]{0,0,0,0,0,0,8,9};
		assertTrue(6 == BinarySearchDeluxe.<Integer>firstIndexOf(list, 8, Integer::compareTo));	
	}
	
	@Test
	public void testFullWithGetLast() {
		Integer[] list = new Integer[]{0,0,0,0,0,0,8,9};
		for (int i = 0; i < 9; i++) { assertTrue(5 == BinarySearchDeluxe.<Integer>lastIndexOf(list, 0, Integer::compareTo));	}
	}
	
	@Test(expected = NullPointerException.class)
		public void testCornerCase() {
		Integer[] list = new Integer[]{0,1,2,3,4};
		assertTrue(0 == BinarySearchDeluxe.<Integer>firstIndexOf(list, null, Integer::compareTo));		
	}
}

