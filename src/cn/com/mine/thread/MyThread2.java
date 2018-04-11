package cn.com.mine.thread;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class MyThread2 {
    public volatile int inc = 0;
 
    public /*synchronized*/ void increase() {
        inc++;
    }
 
    public static void main(String[] args) {
        final MyThread2 test = new MyThread2();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<1000;j++)
                        test.increase();
                };
            }.start();
        }
        
        while(Thread.activeCount()>1)  //保证前面的线程都执行完
            Thread.yield();
        System.out.println(test.inc);
        //线程安全map
        ConcurrentHashMap concurrentHashMap =new ConcurrentHashMap<>();
        Hashtable hashtable = new Hashtable<>();
        HashMap map = new HashMap<>();
        Collections.synchronizedMap(map);
        Iterator iterator=hashtable.entrySet().iterator();
        while (iterator.hasNext()) {
			Hashtable hashtable2=(Hashtable) iterator.next();			
		}
    }
}
