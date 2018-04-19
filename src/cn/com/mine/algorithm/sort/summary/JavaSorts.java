package cn.com.mine.algorithm.sort.summary;

/**  
 * Package: sort  
 *  
 * File: JavaSorts.java   
 *  
 * Copyright @ 2015 Corpration Name  
 *   
 */
public class JavaSorts {

	/**
	 * 希尔排序
	 * @param array
	 */
	public static void ShellSort(int[] array){
		int d = array.length;
		do {
			d /= 2;   //设置增量,通过设置增量来进行分组，分组后，每一组内采用直接插入排序
			OneShell(array, d);//一个增量对应一趟希尔排序
		} while (d > 1);
	}
	
	/**
	 * 一趟希尔排序
	 * @param array
	 * @param d
	 */
	public static void OneShell(int[] array,int d){
		
		for (int i = 0; i < array.length - d; i++) {
			int temp = array[i+d]; //array[i+d]的拷贝，每一次插入操作所以插入的值
			if (array[i] > array[i + d]) {
				int j = i;
				//此时分组为：j,j+d,j+2d,j+3d····,组内采用直接插入排序
				while(j >= 0 && array[j] > temp){
					array[j + d] = array[j];    //使用while循环寻找temp能够插入的位置，从右往左寻找，大于temp的往后移动
					j -= d;
				}
				array[j + d] = temp;   //插入数据
			}
		}	
	}
	
	/**
	 * 快速排序
	 * @param array
	 * @param l
	 * @param r
	 */
	public static void QuickSort(int[] array,int l,int r){
		if (l < r) {
			int i = l,j = r,temp = array[l];
			while(i < j){
				while(i < j && array[j] > temp){
					j--;         //从右边开始寻找比temp小的数
				}
				if(i < j){
					array[i++] = array[j]; //找到后，将这个数赋值到i位置上,然后i+1,因为下一轮寻找比temp大的数，从i+1位置开始
				}
				while(i < j && array[i] < temp){
					i++;          //从左边寻找比temp大的数
				}
				if(i < j){
					array[j--] = array[i]; //找到后，将这个数赋值到j位置上，然后j-1,因为下一轮寻找比temp小的数从j-1位置开始
				}
			}
			array[i] = temp;  //此时比temp小的数都移动到左边，比temp大的数都移动到了右边，最后将temp赋值到中间位置
			
			QuickSort(array, l, i - 1); //对temp左边的数进行递归
			QuickSort(array, i + 1, r); //对temp右边的数进行递归
		}
	}
	
	/**
	 * 堆排序
	 * @param array
	 */
	public static void HeapSort(int[] array){
		for (int i = 0; i < array.length; i++) {
			BuildMaxHeap(array, array.length - 1 - i);
			Swap(array, 0, array.length - 1 - i);
		}
	}
	/**
	 * 创建最大堆
	 * @param array
	 * @param lastOneIndex
	 */
	public static void BuildMaxHeap(int[] array,int lastOneIndex){
		
		for (int i = (lastOneIndex - 1)/2; i >= 0; i--) {
			int k = i;
			while(2*k + 1 <= lastOneIndex){
				int bigIndex = 2*k + 1;   //bigIndex用于记录一个节点树中最大数的索引
				if (bigIndex < lastOneIndex) {  //满足这个条件，说明堆中有array[2*k+2]这个节点
					if (array[bigIndex] < array[bigIndex + 1]) {
						bigIndex++;      //若满足这个条件，说明k节点下的右子节点大于左子结点，因而bigIndex加1
					}
				}
				
				if (array[k] < array[bigIndex]) {
					Swap(array, bigIndex, k); //若k节点小于它其中一个子节点，则与这个子节点交换值
					k = bigIndex;  //交换完值后，此时k节点下面的bigIndex节点可能不满足堆的性质，所以赋值给k,重新进入下一轮while循环
				}else {
					break;//若k节点满足堆的性质，则直接跳出循环
				}
			}
		}
		
	}
	
	/**
	 * 交换array中array[a]、array[b]
	 * @param array
	 * @param a
	 * @param b
	 */
	public static void Swap(int[] array,int a,int b){
		if (a < array.length && b < array.length) {
			int temp = array[a];
			array[a] = array[b];
			array[b] = temp;
		}
	}
	
	/**
	 * 直接插入排序
	 * @param array
	 */
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
	
	/**
	 * 二分插入排序
	 * @param array
	 */
	public static void BinaryInsertSort(int[] array){
		for (int i = 0; i < array.length - 1; i++) {
			int temp = array[i + 1];  //需要插入的数
			if(array[i] > array[i + 1]){
				int l = 0;   //有序队列中左边标识
				int r = i;   //有序队列中右边标识
				while(l < r){
					int mid = (l + r) / 2; //永远指向l->r中间的那个值，中间值与temp(需要插入的值)比较
					if (array[mid] > temp) {
						r--;              //通过while循环，二分折半搜索temp应该插入的位置
					}else {
						l++;
					}
				}
				//运行到这里，l==r,即是temp应该插入的位置是array[l](或者array[r])
				for (int j = i + 1; j > l; j--) {   
					array[j] = array[j - 1];  //将l -> i的数都往后移动一位
				}
				array[l] = temp;  //将temp插入到l位置
				
			}
				
			}
	}
	/**
	 * 直接选择排序
	 * @param array
	 */
	public static void DirectSelectSort(int[] array){
		for (int i = 0; i < array.length - 1; i++) {
			int min = array[i];
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < min) {
					min = array[j];
					array[j] = array[i];
					array[i] = min;
				}
			}
		}
	}
	/**
	 * 冒泡排序
	 * @param array
	 */
	public static void BubbleSort(int[] array){
		int temp = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1; j++) {
				if (array[j] > array[j+1]) {
					temp = array[j];
					array[j] = array[j+1];	
					array[j+1] = temp;
				}
			}
		}
	}
	
	/**
	 * 归并排序
	 * @param array
	 */
	public static void MergeSort(int[] array){
		int left = 0;
		int right = array.length - 1;
		MergeSortRecursive(array, left, right);
	}
	/**
	 * 归并排序的递归方法
	 * @param array
	 * @param left
	 * @param right
	 */
	public static void MergeSortRecursive(int[] array,int left,int right){
		if (left >= right) {
			return;  //递归的停止判断，没有这个判断会报StackOverflowError
		}
		int mid = (left + right)/2;
		MergeSortRecursive(array, left, mid);
		MergeSortRecursive(array, mid+1, right);
		Merge(array, left, mid, right);
	}
	
	/**
	 * 归并排序中合并方法
	 * @param array
	 * @param left
	 * @param mid
	 * @param right
	 */
	public static void Merge(int[] array,int left,int mid,int right){
		int r_left = mid + 1; //需要合并数组中右边数组第一个数索引
		int[] tempArray = new int[array.length];//一个临时数组，用于合并时暂时存储
		int newIndex = left;   //临时数组索引
		int tempLeft = left;   //合并完了以后，用于复制数组的索引
		while(left <= mid && r_left <= right){   //将部分的数放入到临时数组中
			if (array[left] < array[r_left]) {
				tempArray[newIndex++] = array[left++];
			}else {
				tempArray[newIndex++] = array[r_left++];
			}
		}
		while (left <= mid) {
			tempArray[newIndex++] = array[left++];  //将左边还剩余的数放入临时数组(若需要合并的左边还剩余数)
		}
		
		while(r_left <= right){
			tempArray[newIndex++] = array[r_left++];//将右边还剩余的数放入临时数组(若需要和并的右边还剩余数)
		}
		while(tempLeft <= right){
			array[tempLeft] = tempArray[tempLeft++];  //将临时数组复制到array
		}
	}
	
	/**
	 * 基数排序
	 * @param array
	 */
	public static void RadixSort(int[] array){
		int bits = FindMaxBit(array);  //得到数组中最大的那个数的位数
		for (int i = 0; i < bits; i++) {
			OneBitSort(array, i+1);  //一位基数的排序
		}
	}
	/**
	 * 一位基数的排序
	 * @param array
	 * @param bit
	 */
	public static void OneBitSort(int[] array,int bit){
		int[] tempArray = new int[array.length];
		int index = 0;
		int tempIndex = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < array.length; j++) {
				if (FindBitNum(array[j], bit) == i) {
					tempArray[index++] = array[j];
				}
			}
		}
		while(tempIndex < array.length){
			array[tempIndex] = tempArray[tempIndex++]; //复制数组
		}
	}
	/**
	 * 得到某个数某一位的数(例如：num=1234,n=2,FindBitNum(1234,2)=3)
	 * @param num
	 * @param n
	 * @return
	 */
	public static int FindBitNum(int num,int n){
		int key1 = (int)Math.pow(10, n);
		int key2 = (int)Math.pow(10, n-1);
		num %= key1;
		num /= key2;
		return num;
	}
	/**
	 * 得到一个数组中最大数的位数
	 * @param array
	 * @return
	 */
	public static int FindMaxBit(int[] array){
		
		if (array == null || array.length ==0) {
			return 0;
		}
		int max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		int bit = 0;
		while(max / 10 != 0 || max % 10 != 0){
			max /= 10;
			bit++;
		}
		return bit;
		
	}
	public static void main(String[] args) {
		
		System.out.println("冒泡排序："+SortThreads.getBubbleSortTime());
		System.out.println("直接选择排序："+SortThreads.getDirSelectSortTime());
		System.out.println("直接插入排序："+SortThreads.getDirInsertSortTime());
		System.out.println("二分插入排序："+SortThreads.getBinaryInsertSortTime());
		System.out.println("快速排序："+SortThreads.getQuickSortTime());
		System.out.println("希尔排序："+SortThreads.getShellSortTime());
		System.out.println("归并排序："+SortThreads.getMergeSortTime());
		System.out.println("基数排序："+SortThreads.getRadixSortTime());
		System.out.println("堆排序："+SortThreads.getHeapSortTime());
		
		
	}
}
