package edu.crackInterview;

import java.util.LinkedList;
import java.util.Stack;

public class main {

	public static void main(String[] args) {
		int[] valA = {3 , 4 , 5 , 6 , 1 , 2};
		point[] person = {new point(4, 3) , new point(3, 2) ,new point(5, 5) 
		,new point(1, 1) ,new point(4, 1) ,new point(5, 0) ,};
		chap8_11 ob = new chap8_11();
		System.out.println(ob.Bubble(person));
	}
}
