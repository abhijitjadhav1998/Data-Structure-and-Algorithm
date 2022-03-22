import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int arr[] = {1,5,9,3,5,0,3,6};
		System.out.println(Arrays.toString(arr));
		mergeSort(arr, 0, arr.length);
		System.out.println(Arrays.toString(arr));
	}

	public static void mergeSort(int arr[], int start, int end) {
		if(end - start < 2) {
			return;
		}
		int mid = (start + end)/2;
		mergeSort(arr, start, mid);
		mergeSort(arr, mid, end);
		merge(arr,start,mid,end);
	}
	
	public static void merge(int arr[], int start, int mid, int end) {
		//System.out.println("start : "+ start + " mid : " + mid + " end : " + end);
		//optimization 1 
	    // if mid-1 < mid then it is sorted array no need of sorting array , i.e is we can return.
		if(arr[mid-1] <= arr[mid]) {
			return;
		}
		int i = start;
		int j = mid;
		int tempIndex = 0;
		int tempArray[] = new int[end - start];
		while(i<mid && j<end) {
			if(arr[i] < arr[j]) {
				tempArray[tempIndex++] = arr[i++];
			}else {
				tempArray[tempIndex++] = arr[j++];
			}
		}
		
		while(i<mid) {
			tempArray[tempIndex++] = arr[i++];
		}
		while(j<end) {
			tempArray[tempIndex++] = arr[j++];
		}
		tempIndex = 0;
		for(int k=start;k<end;k++) {
			arr[k] = tempArray[tempIndex++];
		}
	}

}
