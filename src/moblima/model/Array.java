package moblima.model;

public class Array {
	public static void printArray(String[] a) {
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
			if(i != a.length-1) {
				System.out.print(" | ");
			}
		}
	}
	
}
