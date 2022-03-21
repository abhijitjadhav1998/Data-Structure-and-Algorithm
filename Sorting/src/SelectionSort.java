import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int arr[] = {1,56,49,85,37,2,64,98,56};
		int unsorted_index = arr.length - 1;
		for(int i = unsorted_index ; i >= 0;i--) {
			int largest = 0;
			for(int j=1;j<=i;j++) {
				if(arr[largest] < arr[j])
					largest = j;
			}
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
		}
		System.out.println(Arrays.toString(arr));
	}

}
