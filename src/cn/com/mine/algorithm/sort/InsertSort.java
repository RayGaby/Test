package cn.com.mine.algorithm.sort;

import java.util.Arrays;

import cn.com.mine.algorithm.sort.summary.ProduceRandomNum;

/**
 * 平均O(n^2),最好O(n),最坏O(n^2);空间复杂度O(1);稳定;简单
 * 
 * @author Ray
 *
 */
public class InsertSort {
	public static void main(String[] args) {
		int[] numbers = ProduceRandomNum.RandomArray(50000, 4);
		long s1 = System.currentTimeMillis();
		insertSort(numbers);
		System.out.println(System.currentTimeMillis() - s1);
		//System.out.println(Arrays.toString(numbers));
		
		int[] numbers2 = ProduceRandomNum.RandomArray(50000, 4);
		long s2 = System.currentTimeMillis();
		DirectInsertSort(numbers2);
		System.out.println(System.currentTimeMillis() - s2);
		//System.out.println(Arrays.toString(numbers2));
	}

	public static void insertSort(int[] a) {
        int tmp;
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    tmp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }
	
	public static void DirectInsertSort(int[] array){
		for (int i = 0; i < array.length - 1; i++) {
			int temp = array[i + 1];
			if (array[i] > array[i + 1]) {
				int j = i;
				while(j >= 0 && array[j] > temp){
					array[j + 1] = array[j];
					j--;
				}
				array[j + 1] = temp;
			}
		}
	}
}
