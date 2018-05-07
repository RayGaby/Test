package cn.com.mine.basic.extend;

/**
 * 只要是new子类，无论是调用子类的有参构造还是无参构造都会执行父类的无参构造。
 * 当子类和父类有同一个变量名字的变量时，如果是使用了多态则调用的是父类的变量。否则调用的是子类的变量。
 * 
 * @author Ray
 *
 */
class SuperClass {
	public int a;
	public SuperClass() {
		a = 1;
		System.out.println("a is" + a);
	}
	public int getA() {
		return a;
	}
}
public class SubClass extends SuperClass{
	public int a = 2;
	public SubClass() {
		System.out.println("a is" + a);
	}
	public int getA() {
		return a;
	}
	public static void main(String[] args) {
		SuperClass aClass = new SuperClass();
		//SubClass bClass = new SubClass();
		SuperClass bClass = new SubClass();
		System.out.println(aClass.a);
		System.out.println(aClass.getA());
		System.out.println(bClass.a);
		System.out.println(bClass.getA());
	}
}
