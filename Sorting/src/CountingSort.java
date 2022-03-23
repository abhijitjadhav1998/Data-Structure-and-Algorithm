import java.util.Arrays;
import java.util.Collections;

/*
 * Counting Sort
 * 
 * 
 */
public class CountingSort {

	public static void main(String[] args) {
		Integer array[] = {5,3,2,1,4,6,7,8,9,0};
		int max = Collections.max(Arrays.asList(array));
		int min = Collections.min(Arrays.asList(array));
		System.out.println(Arrays.toString(array));
		countingSort(array,max+1,min);
		System.out.println(Arrays.toString(array));

	}

	private static void countingSort(Integer[] array, int max, int min) {
		int countArray[] = new int[max - min];
		int index = 0;
		for(int i=0;i<array.length;i++) {
			countArray[array[i] - min]++;
		}
		System.out.println(Arrays.toString(countArray));

		for(int i=0;i<countArray.length;i++) {
			if(countArray[i] != 0) {
				int value = i + min;
				countArray[i]--;
				array[index++] = value;
			}
		}
		
	}

}
    
