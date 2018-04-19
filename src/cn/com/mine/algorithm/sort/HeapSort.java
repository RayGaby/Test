package cn.com.mine.algorithm.sort;

import java.util.Arrays;

/*  
 * Java实现堆排序算法（改进）  
 * 由大到小排序  

 *两个步骤：1，建堆  2，对顶与堆的最后一个元素交换位置  
 */    
public class HeapSort {    
    
    public static void main(String[] args) {    
        int a[] = {3,1,5,7,2,4,9,6,10,8};      
        HeapSort  obj=new HeapSort();    
        System.out.println("初始值：");    
        obj.print(a);    
            
        for(int i=0;i<a.length;i++){    
            obj.createLittleHeap(a,a.length-1-i);//创建堆,创建的是小顶堆。每次循环完，二叉树的根节点都是最小值，所以与此时的未排好部分最后一个值交换位置    
            obj.swap(a, 0, a.length - 1 - i);//与最后一个值交换位置，最小值找到了位置    
            obj.print(a);    
            System.out.println();    
                
        }    
            
        System.out.println("\n排序后：");    
        obj.print(a);    
    
    }    
    /*  
     * 创建小顶堆：双亲节点小于子节点的值。从叶子节点开始，直到根节点。这样建立的堆定位最小值  
     */    
    private void createLittleHeap(int[] data, int last) {    
        for(int i=last;i>0;i--){  
            int parent=(i-1)/2;//当前节点的双亲节点  
            if(data[parent]> data[i])  
            swap(data, parent, i);     
        }  
    }    
    public void print(int a[]){    
        for(int i=0;i<a.length;i++){    
            System.out.print(a[i]+" ");    
        }    
    }    
     public  void swap(int[] data, int i, int j) {      
            if (i == j) {      
                return;      
            }      
            data[i] = data[i] + data[j];      
            data[j] = data[i] - data[j];      
            data[i] = data[i] - data[j];      
        }      
}
