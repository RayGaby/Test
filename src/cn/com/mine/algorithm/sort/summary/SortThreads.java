package cn.com.mine.algorithm.sort.summary;
/**  
 * Package: sort  
 *  
 * File: SortThreads.java   
 *  
 * Copyright @ 2015 Corpration Name  
 *   
 */
public class SortThreads {

	private static final int arrayNum = 50000;
	private static final int bit = 4;
	public static long getBubbleSortTime(){
		long oldTime = System.currentTimeMillis();
		JavaSorts.BubbleSort(ProduceRandomNum.RandomArray(arrayNum, bit));
		long newTime = System.currentTimeMillis();
		return newTime - oldTime;
	}
	public static long getQuickSortTime(){
		int[] array = ProduceRandomNum.RandomArray(arrayNum, bit);
		long oldTime = System.currentTimeMillis();
		JavaSorts.QuickSort(array, 0, array.length - 1);
		long newTime = System.currentTimeMillis();
		return newTime - oldTime;
	}
	public static long getDirSelectSortTime(){
		long oldTime = System.currentTimeMillis();
		JavaSorts.DirectSelectSort(ProduceRandomNum.RandomArray(arrayNum, bit));
		long newTime = System.currentTimeMillis();
		return newTime - oldTime;
	}
	public static long getDirInsertSortTime(){
		long oldTime = System.currentTimeMillis();
		JavaSorts.DirectInsertSort(ProduceRandomNum.RandomArray(arrayNum, bit));
		long newTime = System.currentTimeMillis();
		return newTime - oldTime;
	}
	
	public static long getBinaryInsertSortTime(){
		long oldTime = System.currentTimeMillis();
		JavaSorts.BinaryInsertSort(ProduceRandomNum.RandomArray(arrayNum, bit));
		long newTime = System.currentTimeMillis();
		return newTime - oldTime;
	}
	
	public static long getShellSortTime(){
		long oldTime = System.currentTimeMillis();
		JavaSorts.ShellSort(ProduceRandomNum.RandomArray(arrayNum, bit));
		long newTime = System.currentTimeMillis();
		return newTime - oldTime;
	}
	public static long getMergeSortTime(){
		long oldTime = System.currentTimeMillis();
		JavaSorts.MergeSort(ProduceRandomNum.RandomArray(arrayNum, bit));
		long newTime = System.currentTimeMillis();
		return newTime - oldTime;
	}
	public static long getRadixSortTime(){
		long oldTime = System.currentTimeMillis();
		JavaSorts.RadixSort(ProduceRandomNum.RandomArray(arrayNum, bit));
		long newTime = System.currentTimeMillis();
		return newTime - oldTime;
	}
	public static long getHeapSortTime(){
		long oldTime = System.currentTimeMillis();
		JavaSorts.HeapSort(ProduceRandomNum.RandomArray(arrayNum, bit));
		long newTime = System.currentTimeMillis();
		return newTime - oldTime;
	}
}