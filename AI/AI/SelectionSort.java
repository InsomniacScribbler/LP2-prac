package AI;
import java.util.*;
public class SelectionSort {
	public static void selectionsort(int[] arr){

		int n = arr.length;

		for(int i = 0 ; i<n ; i++){
			int minIdx =  i;
			for(int j = i+1; j<n; j++){

				if(arr[j]<arr[minIdx]){
					minIdx = j;
				}

			}
			int temp = arr[minIdx];
			arr[minIdx] = arr[i];
			arr[i] = arr[minIdx];
		}
	}

	public static void main(String[] args) {
		int [] arr = {12,45,46,13,64,123};
		selectionsort(arr);
		for(int x: arr){
			System.out.print(x+" ");
		}
	}
}
