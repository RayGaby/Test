package cn.com.mine.basic;

public class BitOperation {
	public static void main(String[] args) {
		int a = 12;//1100
		int b = 5;//0101
		System.out.println("a的值为：" + a + ",b的值为：" + b);
		System.out.println("a与b按位与的值为：" + (a & b));//0100
		System.out.println("a与b按位或的值为：" + (a | b));//1101
		System.out.println("a与b按位异或的值为：" + (a ^ b));//1001
		System.out.println("a左移2位后的值为：" + (a<<2));//110000
		System.out.println("a右移2位后的值为：" + (a>>2));//0011
		System.out.println("a按位非的值为：" + (~a));//0011
		System.out.println("********** 应用 *********");
		System.out.println("a加b的值为： " + addition(a, b));
	}
	public static int addition(int a, int b) {
		int t = a&b; //进位
		int sum = a^b; //相加结果（不计进位）
		while (t != 0) {
			int tempT = t<<1;
			int tempSum = sum;
			sum = tempT^tempSum;
			t = tempT&tempSum;
		}
		return sum;
	}
}
