package edu.crackInterview;

import java.util.LinkedList;
import java.util.Stack;

public class main {

	public static void main(String[] args) {
		chap8_18 ob = new chap8_18();
		int [] vals = new int[52];
		for(int i  = 0; i < 52; i++)
			vals[i] = i + 1;
		
//		for(int a : vals)
//			System.out.println(a);
		
		ob.shuffle(vals , 52);
		for(int a : vals)
			System.out.println(a);
		
	}
}
