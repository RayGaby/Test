package cn.com.mine.dataStruction.List;

public class InsertTwoArray {
	public static void main(String[] args) {
		int[] a = {1,2,3,5,6,7};
		int[] b = {2,3,4,5,7,8,9};
		int[] c = insertArray(a, b);
		for(int x :c){
			System.out.println(x);
		}
	}
	public static int[] insertArray(int[] arrayOfA, int[] arrayOfB) {
		int[] newArray = new int[arrayOfA.length+arrayOfB.length];
		int indexOfnew = arrayOfA.length+arrayOfB.length-1;
		int indexOfA = arrayOfA.length-1;
		int indexOfB = arrayOfB.length-1;
		while (indexOfnew>=0) {
			if (indexOfA>=0 && indexOfB>=0) {
				if (arrayOfA[indexOfA]>arrayOfB[indexOfB]) {
					newArray[indexOfnew--] = arrayOfA[indexOfA--];
				}
				else {
					newArray[indexOfnew--] = arrayOfB[indexOfB--];
				}
			}else if (indexOfA<0 && indexOfB>=0) {
				newArray[indexOfnew--] = arrayOfB[indexOfB--];
			}else {
				newArray[indexOfnew--] = arrayOfA[indexOfA--];
			}
		}
		return newArray;	
	}
}
