package cn.com.mine.algorithm;

public class test {
	public static void main(String[] args) {
		int a = 1;
		int b = 2;
		System.out.println(add(a, b));
	}

	public static int add(int a, int b) { // +
		int s = a ^ b; // s为结果
		int t = a & b; // t为进位
		while (t != 0) {
			int tempA = s;
			int tempB = t << 1;
			s = tempA ^ tempB;
			t = tempA & tempB;
		}

		return s;
	}
}
