package com.nokorweb.phoneshop.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class GeneralutilsTest {

	@Test
	public void testToIntegerList() {
		//Give
		List<String> listString = List.of("Mang", "Sokha", "Dollar");
		//When
		List<Integer> integerList = Generalutils.toIntegerList(listString);
		//Then
		assertEquals(3, integerList.size());
		assertEquals(4, integerList.get(0));
		assertEquals(5, integerList.get(1));
		assertEquals(6, integerList.get(2));
	}
	
	@Test
	public void testGetEvenNumber() {
		//Give
		List<Integer> listI = List.of(2,3,4,5,6);
		//When
		List<Integer> evenNumber = Generalutils.getEvenNumber(listI);	//result 2,4,6
		//Then
		assertEquals(3, evenNumber.size());
		assertEquals(4, evenNumber.get(1));
	}
}
