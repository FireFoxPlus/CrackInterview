package edu.crackInterview;

import java.util.LinkedList;
import java.util.Stack;

public class main {

	public static void main(String[] args) {
		String[] vals = {"abc" , "bca" , "ccc" , "bbc" , "bbb" , "cab"};
		int[] vals = {1 , 3 , 4 , 5 , 6 , 1};
		chap8_11 ob = new chap8_11();
		System.out.println(ob.found(vals , 0 , 5 , 6));
	}
}
