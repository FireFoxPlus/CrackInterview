package edu.crackInterview;

import java.util.LinkedList;
import java.util.Stack;

public class main {

	public static void main(String[] args) {
		chap8_9 ob = new chap8_9();
		int[] vals = {1 , 2 , 3};
		LinkedList<LinkedList<Integer> >rs = new LinkedList<LinkedList<Integer>>();
		ob.subSet(vals, 0, 2, rs);
		ob.printRs(rs);

	}
}
