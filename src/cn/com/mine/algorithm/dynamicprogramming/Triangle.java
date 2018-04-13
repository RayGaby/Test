package cn.com.mine.algorithm.dynamicprogramming;

/**
 * 三角形找一条从顶到底的最大路径
 * 
 * 状态转移方程
 * 
 * 1)r == N时， MaxSum(r,j) = D(r,j) 
 * 2)r < N时，MaxSum(r, j) = Max{ MaxSum(r＋1,j), MaxSum(r+1,j+1) } + D(r,j)
 * 
 * @author Ray
 *
 */
public class Triangle {
	static int D[][] = {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};//数字三角形
	static int[][] MaxSum = {{-1},{-1,-1},{-1,-1,-1},{-1,-1,-1,-1},{-1,-1,-1,-1,-1}};//最大值三角形
	
	public static void main(String[] args) {
		System.out.println(function3());
	}
	/**
	 * 递归式（重复计算，时间复杂度O(2的n次方)）
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	public static int function1(int i, int j) {
		return i<D.length-1 ? Math.max(function1(i+1, j), function1(i+1, j+1)) + D[i][j] : D[i][j];
	}
	/**
	 * 递归式（无重复计算，但消耗大量堆栈空间，易造成栈溢出）
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	public static int function2(int i, int j) {
		if(MaxSum[i][j] != -1) return MaxSum[i][j];
		if (i<D.length-1) {
			MaxSum[i][j] = Math.max(function2(i+1, j), function2(i+1, j+1)) + D[i][j];
		}
		else {
			MaxSum[i][j] = D[i][j];
		}
		return MaxSum[i][j];
	}
	/**
	 * 递推式（时间复杂度O(n的2次方)）
	 * 
	 * @return
	 */
	public static int function3() {
		for (int i = D.length - 1; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				MaxSum[i][j] = (i!=D.length - 1) ? Math.max(MaxSum[i+1][j], MaxSum[i+1][j+1]) + D[i][j] : D[i][j];
				System.out.print(MaxSum[i][j] + " ");
			}
			System.out.println();
		}
		return MaxSum[0][0];
	}
	/**
	 * 递推式（空间优化O(1)）
	 * @return
	 */
	public static int function4() {
		for (int i = D.length - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				D[i][j] = Math.max(D[i+1][j], D[i+1][j+1]) + D[i][j];
				System.out.print(D[i][j] + " ");
			}
			System.out.println();
		}
		return D[D.length-1][0];
	}
}
