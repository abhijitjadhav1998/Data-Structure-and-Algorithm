import java.util.Arrays;

public class RadixSort {

	public static void main(String[] args) {
		int array[] = {1432,1800,3530,9000,8088};
		System.out.println(Arrays.toString(array));
		int radix = 10;
		int width = 4;
		radixSort(array,radix,width);
		System.out.println(Arrays.toString(array));
	}

	private static void radixSort(int[] array, int radix, int width) {
		
		for(int i=0;i<width;i++) {
			stableRadixSort(array,radix,i);
		}
		
	}

	private static void stableRadixSort(int[] array, int radix, int position) {
		int countArray[] = new int[radix];
		int nos = array.length;
		for(int i=0;i<nos;i++) {
			countArray[getDigit(position,array[i],radix)]++;
		}
		System.out.println(Arrays.toString(countArray));
		for(int i=1;i<radix;i++) {
			countArray[i] = countArray[i] + countArray[i-1];
		}
		
		int tempArr[] = new int[nos];
		for(int i=nos-1;i>=0;i--) {
			tempArr[--countArray[getDigit(position, array[i], radix)]] = array[i];
		}
		
		System.out.println(Arrays.toString(tempArr));

		for(int i = 0;i<nos;i++) {
			array[i] = tempArr[i];
		}
	}
	
	private static int getDigit(int position, int value, int radix) {
		return value/(int)Math.pow(radix,position) % radix;
	}

}
