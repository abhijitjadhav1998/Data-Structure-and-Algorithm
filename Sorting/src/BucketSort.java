import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * This sorting algorithm works on Hashing technique
 */
public class BucketSort {

	public static void main(String[] args) {
		int array[] = { 12, 45, 36, 10, 45, -21 };
		buckedSort(array);
		System.out.println(Arrays.toString(array));

	}

	private static void buckedSort(int[] array) {
		List<Integer> hashtable[] = new List[10];
		for (int i = 0; i < hashtable.length; i++) {
			hashtable[i] = new ArrayList<Integer>();
		}

		// Hashing the value

		for (int i = 0; i < array.length; i++) {
			int hashedIndex = hashvalue(array[i]);
			hashtable[hashedIndex].add(array[i]);
		}

		// Sorting individual buckets

		for (List<Integer> list : hashtable) {
			Collections.sort(list);
		}

		// rewireing data to the array

		int j = 0;
		for (int i = 0; i < hashtable.length; i++) {
			for (int value : hashtable[i]) {
				array[j++] = value;
			}
		}
	}

	private static int hashvalue(int key) {
		/* Hashing the negative value to 0 */
		if (key < 0) {
			return 0;
		}
		return key / 10;
	}

}
