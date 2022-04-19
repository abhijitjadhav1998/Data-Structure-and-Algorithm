import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		int input[] = {15,5,20,1,17,10,30};
		System.out.println(Arrays.toString(input));
		heapSort(input,input.length);
		System.out.println(Arrays.toString(input));
	}

	private static void heapSort(int[] input, int length) {
		// To Build a heap Sort
		for(int i=(length/2)-1;i>=0;i--) {
			heapify(input,length,i);
		}
		
		// delete the root node and heapify
		for(int i=length-1;i> 0;i--) {
			swap(input,0,i);
			//Call this heapify method in i not on length
			heapify(input, i, 0);
		}
	}

	private static void heapify(int[] input, int length, int i) {
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		
		if(left<length && input[left] > input[largest])
			largest = left;
		if(right < length && input[right] > input[largest])
			largest = right;
		if(largest != i) {
			swap(input,largest,i);
			heapify(input, length, largest);
		}
	}
	
	private static void swap(int input[],int index1, int index2) {
		int temp = input[index1];
		input[index1] = input[index2];
		input[index2] = temp;
	}

}
