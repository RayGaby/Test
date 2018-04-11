package cn.com.mine.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SingletonTest {
	/**
	 * 简单地说，这个新对象是在反序列化过程中，通过反射调用无参数的构造方法创建的。
	 * 从源码角度看，使用ObjectInputStream进行反序列化时，会使用它的readObject()方法。
	 * 
	 */
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        // 序列化
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("storageFile"));
        oos.writeObject(Singleton.getInstance());
        
        // 反序列化
        File file = new File("storageFile");
        ObjectInputStream ois =  new ObjectInputStream(new FileInputStream(file));
        Singleton newInstance = (Singleton) ois.readObject();
        
        //判断是否是同一个对象
        System.out.println(newInstance == Singleton.getInstance());
    }
} 
