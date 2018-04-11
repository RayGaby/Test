package cn.com.mine.basic;

import java.util.ArrayList;
import java.util.List;

public class NewTest {
	public static void main(String[] args) {
		byte a = 127;
		byte b = 127;
		//b = a + b; // error : cannot convert from int to byte
		//b += a; // ok
		System.out.println(3*0.1 == 0.3);
		switch ("qw") {
		case "ws":
			System.out.println("1");
			break;
		default:
			System.out.println("default");
			break;
		}
		//
		String str = "helloworld";
        char[] data = str.toCharArray();// 将字符串转为数组
        for (int x = 0; x < data.length; x++) {
            System.out.print(data[x] + "  ");
            data[x] -= 32;
            System.out.print(data[x] + "  ");
        }
        System.out.println(new String(data));
        
        String str1 = "www.runoob.com";
        String[] temp1;
        String delimeter1 = "\\.";  // 指定分割字符， . 号需要转义
        temp1 = str1.split(delimeter1); // 分割字符串
        for(String x :  temp1){
           System.out.println(x);
           System.out.println("");
        }
        
        //hashcode
        ArrayList list1 = new ArrayList<>();
        ArrayList list2 = new ArrayList<>();
        list1.add(1);
        list2.add(1);
        System.out.println(list1.equals(list2));
        System.out.println(list1.hashCode()==list2.hashCode());
        System.out.println(list1==list2);
        System.out.println("car");
        String s1 = "abc";
        String s2 = new String("abc");
        System.out.println(s1==s2);
        Car c1 = new Car("1", s1);
        Car c2 = new Car("1", s2);
        System.out.println(c1.hashCode()==c2.hashCode());
        System.out.println(c1.equals(c2));
        System.out.println(c1==c2);
	}
}
