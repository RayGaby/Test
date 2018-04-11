package cn.com.mine.springaop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args)
	{
	    ApplicationContext ctx = 
	            new ClassPathXmlApplicationContext("aop.xml");
	   	    
//	    HelloWorldImpl1 hw1 = (HelloWorldImpl1)ctx.getBean("helloWorldImpl1");
//	    HelloWorld hw2 = (HelloWorld)ctx.getBean("helloWorldImpl2");
//	    hw1.printHelloWorld();
//	    System.out.println();
//	    hw1.doPrint();
//	    System.out.println();
//	    
//	    hw2.printHelloWorld();
//	    System.out.println();
//	    hw2.doPrint();
	    
	    HelloWorldImpl3 hw3 = (HelloWorldImpl3)ctx.getBean("helloWorldImpl3");
	    hw3.doPrint();
	    
	}
}
