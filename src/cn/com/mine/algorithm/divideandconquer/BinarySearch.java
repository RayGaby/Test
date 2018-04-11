package cn.com.mine.algorithm.divideandconquer;

/**
 * 二分查找有序数组
 * 
 * @author Ray
 *
 */
public class BinarySearch {
	public static void main(String[] args) {
		int[] array = {1,3,4,6,7,8,9,12,35};
		System.out.println(binarySearch(array, 9));
	}

	public static int binarySearch(int[] array, int res) {
		return binarySearch(array, 0, array.length - 1, res);
	}

	public static int binarySearch(int[] array, int low, int high, int res) {
		if (low > high) {
			return -1;
		}
		int mid = (low + high)/2;
		if (array[mid] == res) {
			return mid;
		}else if (array[mid] < res) {
			return binarySearch(array, mid+1, high, res);
		}else {
			return binarySearch(array, 0, mid-1, res);
		}	
	}
}
