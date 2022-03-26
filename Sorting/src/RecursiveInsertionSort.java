import java.util.Arrays;

public class RecursiveInsertionSort {

	public static void main(String[] args) {
		int arr[] = {38,27,43,3,9,82,10};
		System.out.println(Arrays.toString(arr));
		insertionSort(arr, arr.length);
		System.out.println(Arrays.toString(arr));
	}
	public static void insertionSort(int arr[],int items){
	    if(items == 1){
	        return;
	    }
	    insertionSort(arr,items-1);
	    int new_element = arr[items-1];
	    int j =0;
	    for(j=items-1;j>0 && arr[j-1] > new_element;j--){
	        arr[j] = arr[j-1];
	    }
	    arr[j] = new_element;
		
	}

}


