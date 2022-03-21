import java.util.Arrays;
/*
 * Optimized Bubble Sort
 * 
 * Best Case : n
 * Average Case : n^2
 * Worst Case : n^2
 * 
 */

public class BubbleSort {

	public static void main(String[] args) {
		
		int arr[] = {1,65,49,35,86,79,62,46,35,65,46};
		int unsorted_index = arr.length -1;
		/*
		 * Does not look for all locations , iterate over n - 1 indexes in every iteration.
		 */
		for(int i = unsorted_index; i>= 0; i--) {
			for(int j = 0;j<i;j++) {
				if(arr[i] < arr[j]) {
					/*
					 * Swap
					 */
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(arr));

	}

}
