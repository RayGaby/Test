package cn.com.mine.classloader;

/**
 * 如果类还没有被加载：
 * 
 * 1、先执行父类的静态代码块和静态变量初始化，并且静态代码块和静态变量的执行顺序只跟代码中出现的顺序有关。
 * 2、执行子类的静态代码块和静态变量初始化。
 * 3、执行父类的实例变量初始化
 * 4、执行父类的构造函数
 * 5、执行子类的实例变量初始化
 * 6、执行子类的构造函数
 * 
 * 如果类已经被加载：
 * 则静态代码块和静态变量就不用重复执行，再创建类对象时，只执行与实例相关的变量初始化和构造方法。
 * 
 * @author Ray
 *
 */
public class TestLoader {
    public static void main(String [] args){
        Test1 obj1 = new Test2();
        System.out.println("------------");
        Test1 obj2 = new Test2();
    }
}
class Print {

    public Print(String s){
        System.out.println(s);
    }
}
class Test1 {

    public static Print obj1 = new Print("父类的静态变量1");
    
    public Print obj2 = new Print("父类的实例变量2");

    public static Print obj3 = new Print("父类的静态变量3");
    
    static{
        new Print("父类的静态代码块4");
    }
    
    public static Print obj4 = new Print("父类的静态变量5");
    
    public Print obj5 = new Print("父类的实例变量6");
    
    public Test1(){
        new Print("父类的构造函数7");
    }
    
}
class Test2 extends Test1{

    static{
        new Print("子类的静态代码块a");
    }
    
    public static Print obj1 = new Print("子类的静态变量b");
    
    public Print obj2 = new Print("子类的实例变量c");
    
    public Test2(){
        new Print("子类的构造函数d");
    }
    
    public static Print obj3 = new Print("子类的静态变量e");
    
    public Print obj4 = new Print("子类的实例变量f");
    

}
