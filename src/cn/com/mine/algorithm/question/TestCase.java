package cn.com.mine.algorithm.question;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

/**
 * 测试：堆选排序
 * 
 * @author guanrui
 *
 */
public class TestCase {

	@Test
	public void test() {
		final int n = 1000000;
		final int m = 100;
		// 生成一个包括 N个0~100的随机数的数组
		float arr[] = new float[n];
		for (int i = 0; i < n; i++) {
			Random random = new Random();
			float num = random.nextFloat() * 100f;
			arr[i] = num;
		}
		// 调用堆选排序方法
		long start = System.currentTimeMillis();
		float[] maxNumber = HeapSort.getMaxNumbers(m, arr);
		System.out.println("时间消耗 "+(System.currentTimeMillis() - start)+" ms");
		// 将所得到的 M个最大数进行排序并且输出
		HeapSort.heapSort(maxNumber);
		System.out.println(Arrays.toString(maxNumber));
	}

}
