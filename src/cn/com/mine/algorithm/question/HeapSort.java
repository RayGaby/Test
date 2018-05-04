package cn.com.mine.algorithm.question;

/**
 * 从N个（百万以上）数中选取最大的前M个（1000个以下）
 * 
 * @author guanrui
 *
 */
public class HeapSort {

	/**
	 * 从数组data中返回最大的m个数
	 * 
	 * @param m
	 *            指定数量
	 * @param data
	 *            指定数组
	 * @return
	 */
	public static float[] getMaxNumbers(int m, float[] data) {
		float[] maxNubmerArr = new float[m];
		// 遍历数组元素，比较数组的元素和最小堆的根。如果比根大，则替换根，重新维护新堆
		for (int i = 0; i < data.length; i++) {
			if (data[i] > maxNubmerArr[0]) {
				maxNubmerArr[0] = data[i];
				adjustLittleHeap(maxNubmerArr, m - 1);
			}
		}
		return maxNubmerArr;
	}

	/**
	 * 使用堆排对数组进行排序
	 * 
	 * @param data
	 *            指定数组
	 * @return
	 */
	public static float[] heapSort(float[] data) {
		for (int i = 0; i < data.length - 1; i++) {
			adjustLittleHeap(data, data.length - 1 - i);
			// 每次都将最小的数字放到最后，然后用剩下的数组继续排序
			swap(data, 0, data.length - 1 - i);
		}
		return data;
	}

	/**
	 *
	 * 维护最小堆，保证每个子树的根节点为最小值
	 * 
	 * @param data
	 *            最小堆对应的数组
	 * @param lastIndex
	 *            最后一个节点位置
	 */
	private static void adjustLittleHeap(float[] data, int lastIndex) {
		// 从最后一个非叶子节点开始
		for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
			// 记录当前节点，根据当前节点进行判断操作
			int k = i;
			// 判断左子节点是否存在，如果小于等于最大节点数则存在
			while (2 * k + 1 <= lastIndex) {
				// 最小子节点初始化为左子节点
				int smallIndex = 2 * k + 1;
				if (smallIndex + 1 <= lastIndex) {
					// 如果右子节点存在，判断左右子节点的大小
					if (data[smallIndex] > data[smallIndex + 1]) {
						// 若右子节点值比左子节点值小，则samllIndex设为右子节点
						smallIndex++;
					}
				}
				if (data[k] <= data[smallIndex]) {
					// 若当前节点值小于等于子节点最小值，说明该节点不符合筛选条件
					break;
				}
				else {
					// 若当前节点值大于子节点最小值，则交换二者的值
					swap(data, k, smallIndex);
					// 交换后维护该节点为根节点所在的树
					k = smallIndex;
				}
			}
		}
	}
	
	/**
	 * 交换数组元素
	 * 
	 * @param data
	 *            指定数组
	 * @param i
	 *            数组位置下标i
	 * @param j
	 *            数组位置下标j
	 */
	private static void swap(float[] data, int i, int j) {
		if (i == j) {
			return;
		}
		float temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
}