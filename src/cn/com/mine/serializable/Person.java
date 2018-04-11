package cn.com.mine.serializable;

import java.io.Serializable;

class Person implements Serializable{   

    private static final long serialVersionUID = 1L; 
    
    String name;
    int age;
    
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }   
    public String toString(){
        return "name:"+name+"\tage:"+age;
    }
    
    public String testMethod(){
    	return "success";
    }
}
