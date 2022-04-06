import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {
		int[] array = { -21, 54, 23, 1, 64, 8, 90 };
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
		//System.out.println(iterativeBinarySearch(array, -21));
		System.out.println(recursiveBinarySearch(array, -21));
		System.out.println(recursiveBinarySearch(array, 90));
	}

	private static int iterativeBinarySearch(int[] array, int searchValue) {
		int start = 0;
		int end = array.length;
		while (end > start) {
			int midpoint = (end + start) / 2;
			if (array[midpoint] == searchValue) {
				return midpoint;
			} else if (array[midpoint] < searchValue) {
				start = midpoint + 1;
			} else {
				end = midpoint;
			}
		}
		return -1;
	}

	private static int recursiveBinarySearch(int[] array, int searchValue) {
		return recursiveBinarySearch(array, 0, array.length, searchValue);
	}

	private static int recursiveBinarySearch(int[] array, int start, int end, int searchValue) {
		if (start >= end) {
			return -1;
		}
		int midpoint = (start + end) / 2;
		if (array[midpoint] == searchValue) {
			return midpoint;
		} else if (array[midpoint] < searchValue) {
			return recursiveBinarySearch(array, midpoint + 1, end, searchValue);
		} else {
			return recursiveBinarySearch(array, start, midpoint, searchValue);
		}
	}

}
