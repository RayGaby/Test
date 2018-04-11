package cn.com.mine.algorithm.divideandconquer;

/**
 * 棋盘覆盖问题
 * 
 * @author Ray
 *
 */
public class ChessBoard {
	static final int size = 4;
	static int title = 1;
	static int Board[][] = new int[size][size];

	public static void main(String args[]) {
		Board[2][2] = 0;
		chessBoard(0, 0, 2, 2, size);
		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < size; j++) {
				System.out.print(Board[i][j] + " ");
			}
			System.out.println();
		}
	}

	/*
	 * tr表示棋盘左上角行号 tc表示棋盘左上角列号 dr表示特殊棋盘的行号 dc表示特殊棋盘的列号
	 */
	public static void chessBoard(int tr, int tc, int dr, int dc, int size) {
		if (size == 1) {
			return;
		}
		int t = title++;
		int s = size / 2;
		// 覆盖左上角子棋盘
		if (dr < tr + s && dc < tc + s) {
			// 特殊方格在此棋盘中
			chessBoard(tr, tc, dr, dc, s);
		}
		else {
			// 此棋盘中无特殊方格，用t号L型骨牌覆盖右下角
			Board[tr + s - 1][tr + s - 1] = t;
			// 覆盖其余方格
			chessBoard(tr, tc, tr + s - 1, tc + s - 1, s);
		}
		// 覆盖右上角子棋盘
		if (dr < tr + s && dc >= tc + s) {
			// 特殊方格在此棋盘中
			chessBoard(tr, tc + s, dr, dc, s);
		}
		else {// 此棋盘中午特殊方格，用t号L型骨牌覆盖左下角
			Board[tr + s - 1][tc + s] = t;
			// 覆盖其余方格
			chessBoard(tr, tc + s, tr + s - 1, tc + s, s);
		}
		// 覆盖左下角子棋盘
		if (dr >= tr + s && dc < tc + s) {
			// 特殊方格在此棋盘中
			chessBoard(tr + s, tc, dr, dc, s);
		}
		else {
			// 此棋盘中无特殊方格，用t号L型骨牌覆盖右上角
			Board[tr + s][tr + s - 1] = t;
			// 覆盖其余方格
			chessBoard(tr, tc, tr + s, tc + s - 1, s);
		}
		// 覆盖右下角子棋盘
		if (dr >= tr + s && dc >= tc + s) {
			// 特殊方格在此棋盘中
			chessBoard(tr + s, tc + s, dr, dc, s);
		}
		else {// 此棋盘中无特殊方格，用t号L型骨牌覆盖左上角
			Board[tr + s][tc + s] = t;
			// 覆盖其余方格
			chessBoard(tr + s, tc + s, tr + s, tc + s, s);
		}
	}
}
