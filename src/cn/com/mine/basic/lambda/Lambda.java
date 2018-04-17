package cn.com.mine.basic.lambda;

import java.util.Arrays;
import java.util.List;

public class Lambda {
public static void main(String[] args) {
	List ll = Arrays.asList("a","b","c");
	ll.forEach(n -> System.out.println(n));
}
}
