package cn.com.mine.algorithm.question;

import java.util.Random;

import org.junit.Test;

/** 
 * Created by ray on 2018/5/4. 
 */  
public class TestDemo {  
  
    @Test  
    public void test1(){  
        float arr[]= new float[1000000];  
        for (int i=0;i<1000000;i++){  
            Random random=new Random();  
            float v = random.nextFloat() * 50f;  
            arr[i]=v;  
        }  
        long start=System.currentTimeMillis();  
        float[] maxNumber = HeapUtils.getMaxNumber(100, arr);  
        HeapUtils.heapSort(maxNumber);  
        HeapUtils.print(maxNumber);  
        System.out.println(System.currentTimeMillis()-start);  
    }  
  
} 
