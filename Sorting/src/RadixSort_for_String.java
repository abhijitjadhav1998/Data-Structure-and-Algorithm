import java.util.Arrays;

public class RadixSort_for_String
{
	   
    // Driver Code
	public static void main(String[] args) {
		String arr[] = { "BCDEF", "dbaqc", "abcde", "bbbbb" };
		System.out.println(Arrays.toString(arr));
		/*
		 * Radix is the maximum value from the input array
		 * for String maximum value is 26
		 * 
		 */
		radixSort(arr,26,arr[0].length());
		System.out.println(Arrays.toString(arr));
	}
	
	public static void radixSort(String input[], int radix, int width){
	    for(int i=0;i<width;i++){
	        performRadixSort(input,i,radix);
	    }
	}
	
	public static void performRadixSort(String input[], int position, int radix){
		//creating a temporary count array
	    int countArray[] = new int[radix];
	    int nos = input.length;
	    // populating the count array
	    for(String value : input){
	        countArray[getDigit(position,value,radix)]++;
	    }
	    //Normalizing count array
	    for(int i=1;i<radix;i++){
	        countArray[i] = countArray[i] + countArray[i-1];
	    }
	    String tempArray[] = new String[nos];
	    //Building the final temporary array
	    for(int i=nos-1;i>=0;i--){
	        tempArray[--countArray[getDigit(position,input[i],radix)]] = input[i];
	    }
	    // copying into the actual array
	    for(int i=0;i<nos;i++){
	        input[i] = tempArray[i];
	    }
	    
	}
	// Hashing the input value
	// position =0 value = bcdef radix = 26
	// It takes the character at length - position location and convert it to ascii value 
	// and return the ascii value
	// return 5
	public static int getDigit(int position, String value, int radix){
	    int nos = value.length() - 1;
	    char c  = value.toLowerCase().charAt(nos - position);
	    return (int)c-97;
	}
}