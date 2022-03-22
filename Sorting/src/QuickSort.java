import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int arr[] = { 1, 5, 9, 3, 5, 3, 6 };
		System.out.println(Arrays.toString(arr));
		quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

	public static void quickSort(int arr[], int start, int end) {
		if (end > start) {
			int pivotIndex = partition(arr, start, end);
			quickSort(arr, start, pivotIndex - 1);
			quickSort(arr, pivotIndex + 1, end);
		}
	}

	public static int partition(int arr[], int start, int end) {

		int pivot = arr[start];
		int pivotIndex = start;

		while (end > start) {
			while (arr[start] <= pivot && start < arr.length) {
				if((end > start))
					start++;
			}
			while (arr[end] > pivot && end < arr.length) {
				if((end > start))
					end--;
			}
			if (end > start) {
				swap(arr, end, start);
			}
		}
		swap(arr, end, pivotIndex);
		return end;
	}

	public static void swap(int arr[], int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}

}
