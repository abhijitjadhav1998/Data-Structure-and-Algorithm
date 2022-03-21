import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int arr[] = {  32, 89, 03, 43 };
		System.out.println(Arrays.toString(arr));
		for (int i = 1; i < arr.length; i++) {
			int new_element = arr[i];
			int j;
			for (j = i; j > 0 && arr[j - 1] > new_element; j--) {
				arr[j] = arr[j - 1];
				System.out.println(Arrays.toString(arr));
			}
			arr[j] = new_element;
			System.out.println(Arrays.toString(arr));
		}
		System.out.println(Arrays.toString(arr));
	}

}
