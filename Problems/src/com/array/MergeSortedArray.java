package com.array;

import java.util.Arrays;

public class MergeSortedArray {

	public static void main(String[] args) {
		int[] firstArray = new int[] { 1 };
		int[] secondArray = new int[] { 2, 3, 5, 6, 10, 11, 12 };
		int result[] = mergeSortedArray(firstArray, secondArray);
		System.out.println(Arrays.toString(result));
	}

	public static int[] mergeSortedArray(int array1[], int array2[]) {
		int firstIndex = 0;
		int secondIndex = 0;
		int mergedIndex = 0;
		int finalArray[] = new int[array1.length + array2.length];
		// adding array till the length is equal.
		while (firstIndex < array1.length && secondIndex < array2.length) {
			if (array1[firstIndex] >= array2[secondIndex]) {
				finalArray[mergedIndex++] = array2[secondIndex++];
			} else {
				finalArray[mergedIndex++] = array1[firstIndex++];
			}
		}

		while (firstIndex < array1.length) {
			finalArray[mergedIndex++] = array1[firstIndex++];
		}
		while (secondIndex < array2.length) {
			finalArray[mergedIndex++] = array2[secondIndex++];
		}
		return finalArray;
	}

}
