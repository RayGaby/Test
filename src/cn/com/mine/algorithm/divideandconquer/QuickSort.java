package cn.com.mine.algorithm.divideandconquer;

import java.util.Arrays;
import java.util.Stack;

public class QuickSort {
	public static void main(String[] args) {
		int[] array = {3,6,1,0,-2,7,2,3};
		quickSortRecursion(array, 0, array.length-1);
		System.out.println(Arrays.toString(array));
//		Arrays.sort(array);
//		System.out.println(Arrays.toString(array));
//		quickSort(array, 0, array.length-1);
		
	}
	/**
	 * 递归实现
	 * 
	 * @param array
	 * @param low
	 * @param high
	 */
	public static void quickSortRecursion(int[] array, int low, int high) {
		if (low < high) {
			int mid = partition(array, low, high);
			quickSortRecursion(array, low, mid - 1);
			quickSortRecursion(array, mid + 1, high);
		}
	}
	/**
	 * 非递归实现
	 * 
	 * @param array
	 * @param low
	 * @param high
	 */
	public static void quickSort(int[] array, int low, int high) {
		if (low >= high) {
			return;
		}
		Stack<Integer> indexStack = new Stack<>();
		indexStack.push(high);
		indexStack.push(low);
		while (!indexStack.isEmpty()) {
			int i = indexStack.pop();
			int j = indexStack.pop();
			if (i < j) {
				int mid = partition(array, i, j);
				if (mid > i) {
					indexStack.push(mid - 1);
					indexStack.push(i);
				}
				if (mid < j) {
					indexStack.push(j);
					indexStack.push(mid + 1);
				}
			}
		}
	}
	public static int partition(int[] array, int low, int high) {
		int priot = array[low];
		int i = low + 1;
		int j = high;
		while (true) {
			// 从左边起第一个大于priot的数
			while (array[i] < priot && i < high) {
				i++;
			}
			// 从右边起第一个小于priot的数
			while (array[j] > priot && j > low) {
				j--;
			}
			if (i >= j) {
				break;
			}
			swap(array, i, j);
		}
		swap(array, low, j);
		return j;
	}
	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
