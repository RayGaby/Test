package cn.com.mine.algorithm.backtracking;

/* 
 * 该代码通过回溯法实现了最优装载问题。 
 * 算法思想：要想让最终所有的箱子能够装上船，只需要尽可能将第一艘船装满(贪心选择性质)。 
 * 所以问题转化为在不超载的情况下第一艘船的最大载重量可以达到多少。在第一艘船达到 
 * 最优的情况下，如果剩余箱子重量总和小于第二艘船的载重量，则可以装载。反之，则不能装载。 
 * 将该数学模型转化为一棵子集树，每一个箱子可以选择上1船，或不上1船。因此每个节点都包含有 
 * 2个叶子节点。依次对每个叶子节点进行搜索，统计出最优的装载路径。 
 *  
 * 剪枝函数： 
 * 对于左节点，则计算该箱子装上1船后1船是否会超载，如果超载，则该节点置为死节点， 
 * 该节点之后的节点全部不用再进行搜索。  
 * 对于右节点，则计算当这个箱子不上1船之后，1船已有货物的质量加上后面剩余箱子的质量能否 
 * 超过已经找到的最优解，如果不能超过，则后面的搜索也是无意义的。将该右节点置为死节点。 
 * */

public class BestOverload {
	int sumWeight = 160;
	int n = 5;
	int[] w = { 0, 20, 40, 50, 20, 30 };
	int c1 = 70, c2 = 100;
	int[] bestLoad = new int[n + 1];
	int[] nowLoad = new int[n + 1];
	int tempWeight;
	int bestWeight;
	int redundent = sumWeight;

	public void BackTrack(int t) {
		if (t > n) {
			for (int i = 1; i < n; i++)
				bestLoad[i] = nowLoad[i];
			bestWeight = tempWeight;
			return;
		}
		// 如果没有到达叶子节点，则开始对该节点子树进行搜索，先搜索其左子树，再搜索其右子树。
		redundent -= w[t];
		if (tempWeight + w[t] <= c1) { // 搜索左子树
			tempWeight += w[t];
			nowLoad[t] = 1;
			BackTrack(t + 1);
			tempWeight -= w[t];
		}
		if (redundent + tempWeight > bestWeight) { // 搜索右子树
			nowLoad[t] = 0;
			BackTrack(t + 1);
		}
		redundent += w[t];
	}

	public static void main(String[] args) {
		BestOverload bo = new BestOverload();
		bo.BackTrack(1);
		if (bo.c2 >= bo.sumWeight - bo.bestWeight) {
			System.out.println("可以成功装载，装载方法为:");
			for (int i : bo.bestLoad)
				System.out.print(i + "  ");
		}
		else {
			System.out.println("无法成功装载");
		}
	}
}
