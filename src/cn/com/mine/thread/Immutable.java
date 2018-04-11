package cn.com.mine.thread;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 不可变类-线程安全
 * 
 * 1.将类声明为final，所以它不能被继承；
 * 2.将所有的成员声明为私有的，这样就不允许直接访问这些成员；
 * 3.对变量不要提供setter方法；
 * 4.将所有可变的成员声明为final，这样只能对它们赋值一次；
 * 5.通过构造器初始化所有成员，进行深拷贝（deep copy）；
 * 6.在getter方法中，不要直接返回对象本身，而是克隆对象，并返回对象的拷贝；
 * 
 * @author Ray
 *
 */
public final class Immutable {
    private final int id;
    private final String name;
    private final HashMap map;
    
    public int getId() {
        return id;
    }
 
    public String getName() {
        return name;
    }
 
    /**
     * 可变对象的访问方法
     */
    public HashMap getMap() {
    	StringBuilder stringBuilder = null;
    	stringBuilder.append("ss");
    	synchronized (stringBuilder) {
			BigDecimal bigDecimal = new BigDecimal(1);
		}
    	
        return (HashMap) map.clone();
    }
 
    /**
     * 实现深拷贝的构造器*/
    public Immutable(int i, String n, Map hm){
    	this.id=i;
        this.name=n;
        HashMap tempMap=new HashMap();
        String key;
        Iterator it = hm.keySet().iterator();
        while(it.hasNext()){
            key=(String) it.next();
            tempMap.put(key, hm.get(key));
        }
        //遍历
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); 
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) { 
          System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue()); 
        }
        this.map = tempMap;
    }

}