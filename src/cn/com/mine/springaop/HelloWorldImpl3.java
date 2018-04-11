package cn.com.mine.springaop;

public class HelloWorldImpl3 implements HelloWorld
{
    public void printHelloWorld()
    {
        System.out.println("Enter HelloWorldImpl3.printHelloWorld()");
    }
    
    public void doPrint()
    {
        System.out.println("Enter HelloWorldImpl3.doPrint()");
        throw new RuntimeException("我是异常");
    }
}