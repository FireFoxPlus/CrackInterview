package edu.crackInterview;

import java.util.LinkedList;
import java.util.Stack;

public class main {

	public static void main(String[] args) {
		chap8_9 ob = new chap8_9();
		point src = new point(0 , 0);
		point dst = new point(2 , -1);
		point dis = new point(4 , -4);
		LinkedList<point> rs = new LinkedList<point>();
		ob.paths_2(src, dst, dis, rs);
	}
}
