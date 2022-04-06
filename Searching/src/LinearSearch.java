/*
 * O(n)
 */
public class LinearSearch {

	public static void main(String[] args) {
		int[] array = { -21, 54, 23, 1, 64, 8, 90 };
		int search_value = 89;
		for (int i = 0; i < array.length; i++) {
			if(search_value == array[i]) {
				System.out.println("Element " + search_value + " found at " + i + " location");
				return;
			}
		}
		System.out.println("Element not found in the array");
	}

}
