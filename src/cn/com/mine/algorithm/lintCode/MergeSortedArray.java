package cn.com.mine.algorithm.lintCode;

import java.util.Arrays;

import cn.com.mine.basic.lintCode;

public class MergeSortedArray {
	public static void main(String[] args) {
		MergeSortedArray testCase = new MergeSortedArray();
		int[] nums = { -1, 0, 1, 0, 0, 0};
		int[] b = {-5, 0, 2};
		testCase.mergeSortedArray(nums, 3, b, 3);
		// System.out.println(Arrays.toString(testCase.threeSum(nums)));
	}
    /*
     * @param A: sorted integer array A which has m elements, but size of A is m+n
     * @param m: An integer
     * @param B: sorted integer array B which has n elements
     * @param n: An integer
     * @return: nothing
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
    	/********** A的空间 m+n 空间复杂度 O(1) *************/
    	/********** 思路：倒过来进行添加，正着添加可能需要移位，会比较麻烦  ***********/
    	int i = m-1, j = n-1, k = m+n-1;
    	while (i >= 0 && j >= 0) {
			if (A[i] <= B[j]) {
				A[k--] = B[j--];
			} else {
				A[k--] = A[i--];
			}
		}
    	while (i >= 0) {
    		A[k--] = A[i--];
		}
    	while (j >= 0) {
    		A[k--] = B[j--];
		}
    	System.out.println(Arrays.toString(A));
    }
}
