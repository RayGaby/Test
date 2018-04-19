package cn.com.mine.thread.threadLocal;

/**
 * ThreadLocal为变量在每个线程中都创建了一个副本，那么每个线程可以访问自己内部的副本变量。
 * 它是一个线程级别变量，在并发模式下是绝对安全的变量，也是线程封闭的一种标准用法（除了局部变量外），即使你将它定义为static，它也是线程安全的。
 * 
 * @author Ray
 *
 */
public class Test {
	
    ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
    ThreadLocal<String> stringLocal = new ThreadLocal<String>();
 
    public void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }
    
//    ThreadLocal<Long> longLocal = new ThreadLocal<Long>(){
//        protected Long initialValue() {
//            return Thread.currentThread().getId();
//        };
//    };
//    ThreadLocal<String> stringLocal = new ThreadLocal<String>(){;
//        protected String initialValue() {
//            return Thread.currentThread().getName();
//        };
//    };
     
    public long getLong() {
    	if (longLocal.get() == null) {
			return 0;
		}
        return longLocal.get();
    }
     
    public String getString() {
        return stringLocal.get();
    }
     
    public static void main(String[] args) throws InterruptedException {
        final Test test = new Test();
         
         
        //test.set();
        System.out.println(test.getLong());
        System.out.println(test.getString());
     
         
        Thread thread1 = new Thread(){
            public void run() {
                test.set();
                System.out.println(test.getLong());
                System.out.println(test.getString());
            };
        };
        thread1.start();
        thread1.join();
         
        System.out.println(test.getLong());
        System.out.println(test.getString());
    }
}
