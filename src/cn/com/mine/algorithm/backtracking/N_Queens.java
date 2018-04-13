package cn.com.mine.algorithm.backtracking;

import java.util.Date;

/**
 *  在8×8格的国际象棋上摆放八个皇后，使其不能互相攻击，
 *  即任意两个皇后都不能处于同一行、同一列或同一斜线上，问有多少种摆法。 
 *  下面使用递归方法解决
 *
 */
public class N_Queens {
	private static final short N = 13; // 使用常量来定义，方便之后解N皇后问题
	private static int count = 0; // 结果计数器

	public static void main(String[] args) {
		// 初始化棋盘，全部置0
		short chess[] = new short[N];
		for (int i = 0; i < N; i++) {
			chess[i] = 0;
		}
		Date begin = new Date();		
		putQueenAtRow(chess, (short)0);
		Date end = new Date();
		System.out.println("解决 " + N + " 皇后问题，用时：" + String.valueOf(end.getTime() - begin.getTime()) + "毫秒，计算结果：" + count);
	}

	private static void putQueenAtRow(short[] chess, short row) {
		/**
		 * 递归终止判断：如果row==N，则说明已经成功摆放了8个皇后 输出结果，终止递归
		 */
		if (row == N) {
			count++;
			// System.out.println("第 "+ count +" 种解：");
			// for(int i=0;i<N;i++){
			// for(int j=0;j<N;j++){
			// System.out.print(chess[i][j]+" ");
			// }
			// System.out.println();
			// }
			return;
		}

		short[] chessTemp = chess.clone();

		/**
		 * 向这一行的每一个位置尝试排放皇后 然后检测状态，如果安全则继续执行递归函数摆放下一行皇后
		 */
		for (short i = 0; i < N; i++) {
			chessTemp[row] = i;
			if (isSafety(chessTemp, row, i)) {
				putQueenAtRow(chessTemp, (short)(row + 1));
			}
		}
	}

	private static boolean isSafety(short[] chess, short row, short col) {
		// 判断中上、左上、右上是否安全
		short step=1;
        for(short i=(short) (row-1);i>=0;i--){
            if(chess[i] == col)   //中上
                return false;
            if(chess[i]==col-step)  //左上
                return false;
            if(chess[i]==col+step)  //右上
                return false;
            step++;
        }
		return true;
	}
}
