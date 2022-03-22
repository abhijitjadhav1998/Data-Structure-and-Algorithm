import java.util.Arrays;

public class ShellSort {

	public static void main(String[] args) {
		int arr[] = { 1, 43, 67, 90, 12, 45, 67 };

		System.out.println(Arrays.toString(arr));

		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < arr.length; i++) {
				int new_value = arr[i];
				int j = i;
				
				for (j = i; j >= gap && arr[j - gap] > new_value; j -= gap) {
					arr[j] = arr[j - gap];  
				}
				arr[j] = new_value;

			}

		}

		System.out.println(Arrays.toString(arr));

	}

}
