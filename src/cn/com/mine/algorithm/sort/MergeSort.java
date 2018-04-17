package cn.com.mine.algorithm.sort;

import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
		int[] array = {3,6,1,0,-2,7,2,3};
		mergeSort(array,0,array.length-1);
		System.out.println(Arrays.toString(array));
	}

	public static void mergeSort(int[] a, int low, int high) {
		if (low < high) {
			int middle = (low + high)/2;
			mergeSort(a, low, middle);
			mergeSort(a, middle + 1, high);
			merge(a, low, middle, high);
		}
	}

	public static void merge(int[] a, int low, int middle, int high) {
		int i = low;
		int j = middle + 1;
		int[] temp = new int[high - low + 1];
		int k = 0;
		while (i <= middle && j <= high) {
			if (a[i] < a[j]) {
				temp[k++] = a[i++];
			}else {
				temp[k++] = a[j++];
			}
		}
		while (i <= middle) {
			temp[k++] = a[i++];
		}
		while (j <= high) {
			temp[k++] = a[j++];
		}
		for (int k2 = 0; k2 < temp.length; k2++) {
			a[k2 + low] = temp[k2];
		}
	}
}
