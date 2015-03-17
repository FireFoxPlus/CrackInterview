package edu.crackInterview;

import java.util.LinkedList;
import java.util.Stack;

public class main {

	public static void main(String[] args) {
		int[] vals = {4 , 5 , 8 , 9 , 1 , 6};
		chap8_11 ob = new chap8_11();
		ob.fastSort(vals, 0, 5);
		for(int a: vals)
		{
			System.out.println(a);
		}
	
	}
}
