package edu.crackInterview;

import java.util.LinkedList;
import java.util.Stack;

public class main {

	public static void main(String[] args) {
		int[] valA = {3 , 4 , 5 , 6 , 1 , 2};
		String[] vals = {"" , "asa" , "asd" , "" ,"bs" , "" , "" , "cc" , ""};
		chap8_11 ob = new chap8_11();
		System.out.println(ob.getString(vals, 0 , 8, new String("asd")));
	}
}
