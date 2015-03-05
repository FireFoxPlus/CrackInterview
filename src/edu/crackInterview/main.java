package edu.crackInterview;

import java.util.Stack;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		chap8_3 ob = new chap8_3();
		Stack<Integer> src = new Stack<Integer>();
		Stack<Integer> help = new Stack<Integer>();
		Stack<Integer> dst = new Stack<Integer>();
		src.push(6);
		src.push(5);
		src.push(4);
		src.push(3);
		src.push(2);
		src.push(1);
		ob.Hanoi(src, help, dst, 6);
		while(!dst.isEmpty())
			System.out.println(dst.pop());
	}

}
