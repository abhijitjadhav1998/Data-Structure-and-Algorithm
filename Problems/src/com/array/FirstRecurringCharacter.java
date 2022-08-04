package com.array;

import java.util.HashSet;
import java.util.Set;

public class FirstRecurringCharacter {

	public static void main(String[] args) {
		int array[] = { 2, 3,4,5};
		int result = firstRecurringCharacter(array);
		System.out.println(result);
	}

	private static int firstRecurringCharacter(int[] array) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < array.length; i++) {
			 int value = array[i];
			 if(set.contains(value)) {
				 return value;
			 }else {
				 set.add(value);
			 }
		}
		return -1;
	}

}
