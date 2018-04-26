package cn.com.mine.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * try catch finally 执行顺序
 * 
 * 1、finally语句总会执行
 * 
 * 2、如果try、catch中有return语句，finally中没有return，那么在finally中修改除包装类型和静态变量、全局变量以外的数据都不会对try、catch中返回的变量有任何的影响（包装类型、静态变量会改变、全局变量）
 * 
 * 3、尽量不要在finally中使用return语句，如果使用的话，会忽略try、catch中的返回语句，也会忽略try、catch中的异常，屏蔽了错误的发生
 * 
 * 4、finally中避免再次抛出异常，一旦finally中发生异常，代码执行将会抛出finally中的异常信息，try、catch中的异常将被忽略
 * 
 * 所以在实际项目中，finally常常是用来关闭流或者数据库资源的，并不额外做其他操作。
 * 
 * @author Ray
 *
 */
public class TCFExcuteOrders {
	
	public static void main(String[] args) {
		System.out.println(testBasic2());
	}

	public static int testBasic1() {
		int i = 1;
		try {
			i++;
			System.out.println("try block, i = " + i);
		}
		catch (Exception e) {
			i++;
			System.out.println("catch block i = " + i);
		}
		finally {
			i = 10;
			System.out.println("finally block i = " + i);
		}
		return i;
	}

	public static int testBasic2() {
		int i = 1;
		try {
			i++;
			System.out.println("try block, i = " + i);
			return i;
		}
		catch (Exception e) {
			i++;
			System.out.println("catch block i = " + i);
			return i;
		}
		finally {
			i = 10;
			System.out.println("finally block i = " + i);
		}
	}

	public static List<Object> testBasic3() {
		List<Object> list = new ArrayList<>();
		try {
			list.add("try");
			System.out.println("try block");
			return list;
		}
		catch (Exception e) {
			list.add("catch");
			System.out.println("catch block");
			return list;
		}
		finally {
			list.add("finally");
			System.out.println("finally block ");
		}
	}
	
	public static  int testBasic4(){
        int i = 1; 
        try{
            i++;
            System.out.println("try block, i = "+i);
            return i;
        }catch(Exception e){
            i ++;
            System.out.println("catch block i = "+i);
            return i;
        }finally{
            i = 10;
            System.out.println("finally block i = "+i);
            return i;
        }
	}
	public static  int testBasic5(){
        int i = 1; 
        try{
            i++;
            int m = i / 0 ;
            System.out.println("try block, i = "+i);
            return i;
        }catch(Exception e){
            i ++;
            System.out.println("catch block i = "+i);
            return i;
        }finally{
            i = 10;
            System.out.println("finally block i = "+i);
            return i;
        }
	}
	public static  int testBasic6(){
        int i = 1; 
        try{
            i++;
            Integer.parseInt(null);
            System.out.println("try block, i = "+i);
            return i;
        }catch(Exception e){
            String.valueOf(null);
            System.out.println("catch block i = "+i);
            return i;
        }finally{
            i = 10;
            int m = i / 0;
            System.out.println("finally block i = "+i);
        }
}
}
