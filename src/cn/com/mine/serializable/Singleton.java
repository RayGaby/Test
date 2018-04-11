package cn.com.mine.serializable;

import java.io.Serializable;

/**
 * 使用静态内置类实现单例模式
 * 
 * @author Ray
 *
 */
public class Singleton implements Serializable {

	private static final long serialVersionUID = 4496910066045376175L;

	private static class SingletonHolder {
		private static final Singleton INSTANCE = new Singleton();
	}

	private Singleton() {
	}

	public static final Singleton getInstance() {
		return SingletonHolder.INSTANCE;
	}

	private Object readResolve() {
		System.out.println("调用了readResolve方法！");
		return SingletonHolder.INSTANCE;
	}

}
