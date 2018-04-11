package cn.com.mine.algorithm.dynamicprogramming;

/**
 * 0-1背包问题
 * 
 * @author Ray
 *
 */
public class BackPack {
	public static void main(String[] args) {
		// 所有的物品
	    Knapsack[] bags = new Knapsack[] { new Knapsack(2, 13),
            new Knapsack(1, 10), new Knapsack(3, 24), new Knapsack(2, 15),
            new Knapsack(4, 28), new Knapsack(5, 33), new Knapsack(3, 20),
            new Knapsack(1, 8) };
	    // 物品的数量
	    int n = bags.length;
	    // 背包总承重
	    int totalWeight = 12;
	    // 第一维：当前第几个物品；第二维：当前的背包承重；值：当前背包最大价值
	    int[][] bestValues = new int[n + 1][totalWeight + 1]; // 考虑0的状态+1，防止数组角标越界
	    // 最终背包中最大价值
	    int bestValue;	    
	    System.out.println("最大价值:"+backPack(bags, n, totalWeight, bestValues));
	}

	public static int backPack(Knapsack[] bags, int n, int totalWeight, int[][] bestValues) {
	    for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= totalWeight; j++) {
				if (i == 0 || j == 0) {
					bestValues[i][j] = 0;//初始化状态
				}
				else {
					if (bags[i-1].getWeight() > j) {
						bestValues[i][j] = bestValues[i-1][j];
					}
					else {
						int plusCurrent = bestValues[i-1][j-bags[i-1].getWeight()] + bags[i-1].getValue();
						bestValues[i][j] = plusCurrent > bestValues[i-1][j]? plusCurrent:bestValues[i-1][j];
					}
				}
				System.out.print(bestValues[i][j] + " ");
			}
			System.out.println();
		}
	    return bestValues[n][totalWeight];
	}

}
