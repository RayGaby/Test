package cn.com.mine.algorithm.sort;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] numbers = {2,6,3,6,1,0,-1};
		quickSort(numbers, 0, numbers.length-1);
		System.out.println(Arrays.toString(numbers));
	}

	public static void quickSort(int[] numbers,int low, int high) {
		if (low < high) {			
			int middle = partition(numbers, low, high);
			quickSort(numbers, low, middle - 1);
			quickSort(numbers, middle + 1, high);
		}
	}

	public static int partition(int[] numbers, int low, int high) {
		int i = low + 1;
		int j = high;
		int priot = numbers[low];
		while (true) {
			while (priot > numbers[i] && i < high) {
				i++;
			}
			while (priot < numbers[j] && j > low) {
				j--;
			}
			if (i >= j) {	
				break;
			}
			swap(numbers,i,j);
		}
		swap(numbers,low,j);
		return j;
	}
	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
