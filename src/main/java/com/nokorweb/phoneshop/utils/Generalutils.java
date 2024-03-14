package com.nokorweb.phoneshop.utils;

import java.util.List;
import java.util.stream.Collectors;

//https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
public class Generalutils {
	
	public static List<Integer> toIntegerList(List<String> listString){
		return listString.stream()
					.map(listS -> listS.length())
					.collect(Collectors.toList());
	}
	
	public static List<Integer> getEvenNumber(List<Integer> listInteger ){
		return listInteger.stream()
					.filter(x -> x % 2 == 0)
					.toList();
	}
	
}
