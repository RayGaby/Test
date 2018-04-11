package cn.com.mine.classloader;

public class CodeExcuteOrders {
	   
    public static void main(String[] args) {  
        new ExB();  
        }  
}

class ExA {  
    static {  
        System.out.println("父类--静态代码块");  
    }  
    public ExA() {  
        System.out.println("父类--构造函数");  
    }  
   
    {  
        System.out.println("父类--非静态代码块");  
    }  

}  
   
class ExB extends ExA {  
    static {  
        System.out.println("子类--静态代码块");  
    }  
   
    public ExB() {  
        System.out.println("子类--构造函数");  
    }  
    {  
    	System.out.println("子类--非静态代码块");  
    }  
}
